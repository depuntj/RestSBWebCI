package com.depun.restproject.proyeklokasi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProyekLokasiService {

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiRepository.findAll();
    }

    public ProyekLokasi createProyekLokasi(ProyekLokasi proyekLokasi) {
        return proyekLokasiRepository.save(proyekLokasi);
    }

    public ProyekLokasi getProyekLokasiById(ProyekLokasiId id) {
        return proyekLokasiRepository.findById(id).orElse(null);
    }

    public ProyekLokasi updateProyekLokasi(ProyekLokasiId id, ProyekLokasi proyekLokasi) {
        if (proyekLokasiRepository.existsById(id)) {
            proyekLokasi.setProyek(proyekLokasi.getProyek());
            proyekLokasi.setLokasi(proyekLokasi.getLokasi());
            return proyekLokasiRepository.save(proyekLokasi);
        }
        return null;
    }

    public void deleteProyekLokasi(ProyekLokasiId id) {
        proyekLokasiRepository.deleteById(id);
    }
}
