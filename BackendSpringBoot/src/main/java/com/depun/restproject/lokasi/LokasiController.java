package com.depun.restproject.lokasi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @GetMapping
    public List<LokasiDTO> getAllLokasi() {
        return lokasiService.getAllLokasi().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LokasiDTO> getLokasiById(@PathVariable Integer id) {
        Optional<Lokasi> lokasi = lokasiService.getLokasiById(id);
        return lokasi.map(lokasiEntity -> ResponseEntity.ok(convertToDTO(lokasiEntity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LokasiDTO> createLokasi(@RequestBody LokasiDTO lokasiDTO) {
        Lokasi lokasi = convertToEntity(lokasiDTO);
        lokasi.setCreatedAt(LocalDateTime.now()); // Set current time if not set
        Lokasi createdLokasi = lokasiService.createLokasi(lokasi);
        return ResponseEntity.ok(convertToDTO(createdLokasi));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LokasiDTO> updateLokasi(@PathVariable Integer id, @RequestBody LokasiDTO lokasiDTO) {
        Optional<Lokasi> existingLokasi = lokasiService.getLokasiById(id);
        if (existingLokasi.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Lokasi lokasiDetails = new Lokasi();
        lokasiDetails.setIdPk(id);
        lokasiDetails.setNamaLokasi(lokasiDTO.getNamaLokasi());
        lokasiDetails.setNegara(lokasiDTO.getNegara());
        lokasiDetails.setProvinsi(lokasiDTO.getProvinsi());
        lokasiDetails.setKota(lokasiDTO.getKota());
        lokasiDetails.setCreatedAt(existingLokasi.get().getCreatedAt()); // Retain existing created_at

        Optional<Lokasi> updatedLokasi = lokasiService.updateLokasi(id, lokasiDetails);
        return updatedLokasi.map(lokasi -> ResponseEntity.ok(convertToDTO(lokasi)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Integer id) {
        boolean isDeleted = lokasiService.deleteLokasi(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private LokasiDTO convertToDTO(Lokasi lokasi) {
        LokasiDTO dto = new LokasiDTO();
        dto.setIdPk(lokasi.getIdPk());
        dto.setNamaLokasi(lokasi.getNamaLokasi());
        dto.setNegara(lokasi.getNegara());
        dto.setProvinsi(lokasi.getProvinsi());
        dto.setKota(lokasi.getKota());
        dto.setCreatedAt(lokasi.getCreatedAt());
        return dto;
    }

    private Lokasi convertToEntity(LokasiDTO lokasiDTO) {
        Lokasi lokasi = new Lokasi();
        lokasi.setIdPk(lokasiDTO.getIdPk());
        lokasi.setNamaLokasi(lokasiDTO.getNamaLokasi());
        lokasi.setNegara(lokasiDTO.getNegara());
        lokasi.setProvinsi(lokasiDTO.getProvinsi());
        lokasi.setKota(lokasiDTO.getKota());
        lokasi.setCreatedAt(lokasiDTO.getCreatedAt());
        return lokasi;
    }
}
