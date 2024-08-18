package com.depun.restproject.proyeklokasi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/proyek-lokasi")
public class ProyekLokasiController {

    @Autowired
    private ProyekLokasiService proyekLokasiService;

    @GetMapping
    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiService.getAllProyekLokasi();
    }

    @PostMapping
    public ProyekLokasi createProyekLokasi(@RequestBody ProyekLokasi proyekLokasi) {
        return proyekLokasiService.createProyekLokasi(proyekLokasi);
    }

    @GetMapping("/{proyekIdPk}/{lokasiIdPk}")
    public ProyekLokasi getProyekLokasi(@PathVariable Integer proyekIdPk, @PathVariable Integer lokasiIdPk) {
        ProyekLokasiId id = new ProyekLokasiId(proyekIdPk, lokasiIdPk);
        return proyekLokasiService.getProyekLokasiById(id);
    }

    @PutMapping("/{proyekIdPk}/{lokasiIdPk}")
    public ProyekLokasi updateProyekLokasi(
            @PathVariable Integer proyekIdPk,
            @PathVariable Integer lokasiIdPk,
            @RequestBody ProyekLokasi proyekLokasi) {
        ProyekLokasiId id = new ProyekLokasiId(proyekIdPk, lokasiIdPk);
        return proyekLokasiService.updateProyekLokasi(id, proyekLokasi);
    }

    @DeleteMapping("/{proyekIdPk}/{lokasiIdPk}")
    public void deleteProyekLokasi(@PathVariable Integer proyekIdPk, @PathVariable Integer lokasiIdPk) {
        ProyekLokasiId id = new ProyekLokasiId(proyekIdPk, lokasiIdPk);
        proyekLokasiService.deleteProyekLokasi(id);
    }
}
