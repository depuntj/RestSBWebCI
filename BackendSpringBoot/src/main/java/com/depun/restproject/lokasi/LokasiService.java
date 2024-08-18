package com.depun.restproject.lokasi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }
    public Optional<Lokasi> getLokasiById(Integer id) {
        return lokasiRepository.findById(id);
    }
    public Lokasi createLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }
    public Optional<Lokasi> updateLokasi(Integer id, Lokasi lokasiDetails) {
        if (lokasiRepository.existsById(id)) {
            lokasiDetails.setIdPk(id); // Ensure ID is set for update
            return Optional.of(lokasiRepository.save(lokasiDetails));
        }
        return Optional.empty();
    }
    public boolean deleteLokasi(Integer id) {
        if (lokasiRepository.existsById(id)) {
            lokasiRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
