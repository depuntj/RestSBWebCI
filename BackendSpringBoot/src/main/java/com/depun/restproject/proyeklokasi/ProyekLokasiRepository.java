package com.depun.restproject.proyeklokasi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, ProyekLokasiId> {
    List<ProyekLokasi> findByProyekIdPk(Integer proyekIdPk);
    void deleteByProyekIdPk(Integer proyekIdPk);
}
