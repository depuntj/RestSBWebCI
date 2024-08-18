package com.depun.restproject.proyek;

import com.depun.restproject.lokasi.Lokasi;
import com.depun.restproject.lokasi.LokasiDTO;
import com.depun.restproject.proyek.ProyekDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    // Create a new Proyek including associated Lokasi
    @PostMapping
    public ResponseEntity<ProyekDTO> createProyek(@RequestBody ProyekDTO proyekDTO) {
        try {
            Proyek createdProyek = proyekService.createProyek(proyekDTO);
            ProyekDTO createdProyekDTO = convertToDTO(createdProyek);
            return new ResponseEntity<>(createdProyekDTO, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // Changed to BAD_REQUEST
        }
    }

    // Get all Proyek including associated Lokasi
    @GetMapping
    public ResponseEntity<List<ProyekDTO>> getAllProyek() {
        try {
            List<ProyekDTO> proyekDTOList = proyekService.getAllProyekWithLokasi();
            return new ResponseEntity<>(proyekDTOList, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get Proyek by ID including associated Lokasi
    @GetMapping("/{id}")
    public ResponseEntity<ProyekDTO> getProyekById(@PathVariable("id") Integer id) {
        ProyekDTO proyekDTO = proyekService.getProyekById(id);
        if (proyekDTO != null) {
            return new ResponseEntity<>(proyekDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing Proyek
    @PutMapping("/{id}")
    public ResponseEntity<ProyekDTO> updateProyek(@PathVariable("id") Integer id, @RequestBody ProyekDTO proyekDTO) {
        Proyek updatedProyek = proyekService.updateProyek(id, proyekDTO);
        if (updatedProyek != null) {
            ProyekDTO updatedProyekDTO = convertToDTO(updatedProyek);
            return new ResponseEntity<>(updatedProyekDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete an existing Proyek
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProyek(@PathVariable("id") Integer id) {
        try {
            proyekService.deleteProyek(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private ProyekDTO convertToDTO(Proyek proyek) {
        ProyekDTO dto = new ProyekDTO();
        dto.setIdPk(proyek.getIdPk());
        dto.setNamaProyek(proyek.getNamaProyek());
        dto.setClient(proyek.getClient());
        dto.setTglMulai(proyek.getTglMulai()); // Direct LocalDate usage
        dto.setTglSelesai(proyek.getTglSelesai()); // Direct LocalDate usage
        dto.setPimpinanProyek(proyek.getPimpinanProyek());
        dto.setKeterangan(proyek.getKeterangan());
        dto.setCreatedAt(proyek.getCreatedAt()); // Direct LocalDateTime usage

        List<LokasiDTO> lokasiDTOList = new ArrayList<>();
        for (Lokasi lokasi : proyek.getLokasiList()) {
            LokasiDTO lokasiDTO = convertToDTO(lokasi);
            lokasiDTOList.add(lokasiDTO);
        }
        dto.setLokasiList(lokasiDTOList);

        return dto;
    }

    private LokasiDTO convertToDTO(Lokasi lokasi) {
        LokasiDTO dto = new LokasiDTO();
        dto.setIdPk(lokasi.getIdPk());
        dto.setNamaLokasi(lokasi.getNamaLokasi());
        dto.setNegara(lokasi.getNegara());
        dto.setProvinsi(lokasi.getProvinsi());
        dto.setKota(lokasi.getKota());
        return dto;
    }
}
