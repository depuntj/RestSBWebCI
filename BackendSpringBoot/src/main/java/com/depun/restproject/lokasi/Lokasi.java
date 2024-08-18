package com.depun.restproject.lokasi;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lokasi")
public class Lokasi {

    @Id
    @Column(name = "id_pk")
    private Integer idPk;

    @Column(name = "nama_lokasi")
    private String namaLokasi;

    @Column(name = "negara")
    private String negara;

    @Column(name = "provinsi")
    private String provinsi;

    @Column(name = "kota")
    private String kota;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters and Setters
    public Integer getIdPk() {
        return idPk;
    }
    public void setIdPk(Integer idPk) {
        this.idPk = idPk;
    }
    public String getNamaLokasi() {
        return namaLokasi;
    }
    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }
    public String getNegara() {
        return negara;
    }
    public void setNegara(String negara) {
        this.negara = negara;
    }
    public String getProvinsi() {
        return provinsi;
    }
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
    public String getKota() {
        return kota;
    }
    public void setKota(String kota) {
        this.kota = kota;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
