package com.depun.restproject.proyek;

import com.depun.restproject.lokasi.Lokasi;
import com.depun.restproject.lokasi.LokasiDTO;
import com.depun.restproject.lokasi.LokasiRepository;
import com.depun.restproject.proyeklokasi.ProyekLokasi;
import com.depun.restproject.proyeklokasi.ProyekLokasiRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    @Transactional
    public Proyek createProyek(ProyekDTO proyekDTO) {
        Proyek proyek = new Proyek();
        proyek.setIdPk(proyekDTO.getIdPk());
        proyek.setNamaProyek(proyekDTO.getNamaProyek());
        proyek.setClient(proyekDTO.getClient());

        proyek.setTglMulai(proyekDTO.getTglMulai());
        proyek.setTglSelesai(proyekDTO.getTglSelesai());

        proyek.setPimpinanProyek(proyekDTO.getPimpinanProyek());
        proyek.setKeterangan(proyekDTO.getKeterangan());
        proyek.setCreatedAt(proyekDTO.getCreatedAt() != null ? proyekDTO.getCreatedAt() : LocalDateTime.now());

        Proyek savedProyek = proyekRepository.save(proyek);

        List<LokasiDTO> lokasiDTOList = proyekDTO.getLokasiList();
        if (lokasiDTOList != null && !lokasiDTOList.isEmpty()) {
            for (LokasiDTO lokasiDTO : lokasiDTOList) {
                Lokasi lokasi = lokasiRepository.findById(lokasiDTO.getIdPk())
                        .orElseThrow(() -> new RuntimeException("Lokasi not found with id: " + lokasiDTO.getIdPk()));
                ProyekLokasi proyekLokasi = new ProyekLokasi(savedProyek.getIdPk(), lokasi.getIdPk());
                proyekLokasiRepository.save(proyekLokasi);
            }
        }

        return savedProyek;
    }

    public List<ProyekDTO> getAllProyekWithLokasi() {
        List<Proyek> proyekList = proyekRepository.findAll();
        return proyekList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProyekDTO convertToDTO(Proyek proyek) {
        ProyekDTO dto = new ProyekDTO();
        dto.setIdPk(proyek.getIdPk());
        dto.setNamaProyek(proyek.getNamaProyek());
        dto.setClient(proyek.getClient());
        dto.setTglMulai(proyek.getTglMulai()); // Directly set LocalDate
        dto.setTglSelesai(proyek.getTglSelesai()); // Directly set LocalDate
        dto.setPimpinanProyek(proyek.getPimpinanProyek());
        dto.setKeterangan(proyek.getKeterangan());
        dto.setCreatedAt(proyek.getCreatedAt()); // Directly set LocalDateTime

        List<LokasiDTO> lokasiDTOList = proyekLokasiRepository.findByProyekIdPk(proyek.getIdPk()).stream()
                .map(proyekLokasi -> {
                    Lokasi lokasi = lokasiRepository.findById(proyekLokasi.getLokasiIdPk())
                            .orElseThrow(() -> new RuntimeException("Lokasi not found with id: " + proyekLokasi.getLokasiIdPk()));
                    LokasiDTO lokasiDTO = new LokasiDTO();
                    lokasiDTO.setIdPk(lokasi.getIdPk());
                    lokasiDTO.setNamaLokasi(lokasi.getNamaLokasi());
                    lokasiDTO.setNegara(lokasi.getNegara());
                    lokasiDTO.setProvinsi(lokasi.getProvinsi());
                    lokasiDTO.setKota(lokasi.getKota());
                    return lokasiDTO;
                })
                .collect(Collectors.toList());
        dto.setLokasiList(lokasiDTOList);
        return dto;
    }

    public ProyekDTO getProyekById(Integer id) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek not found with id: " + id));
        return convertToDTO(proyek);
    }

    public Proyek updateProyek(Integer id, ProyekDTO proyekDTO) {
        if (proyekRepository.existsById(id)) {
            Proyek proyek = proyekRepository.findById(id).orElseThrow(() -> new RuntimeException("Proyek not found with id: " + id));
            proyek.setNamaProyek(proyekDTO.getNamaProyek());
            proyek.setClient(proyekDTO.getClient());
            proyek.setTglMulai(proyekDTO.getTglMulai());
            proyek.setTglSelesai(proyekDTO.getTglSelesai());
            proyek.setPimpinanProyek(proyekDTO.getPimpinanProyek());
            proyek.setKeterangan(proyekDTO.getKeterangan());
            proyek.setCreatedAt(proyekDTO.getCreatedAt() != null ? proyekDTO.getCreatedAt() : LocalDateTime.now()); // Set created_at to the current timestamp if null

            return proyekRepository.save(proyek);
        }
        return null;
    }

    @Transactional
    public void deleteProyek(Integer id) {
        proyekLokasiRepository.deleteByProyekIdPk(id);
        proyekRepository.deleteById(id);
    }
}
