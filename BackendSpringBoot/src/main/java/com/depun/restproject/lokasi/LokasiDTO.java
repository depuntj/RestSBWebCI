package com.depun.restproject.lokasi;

import java.time.LocalDateTime;

public class LokasiDTO {
    private Integer idPk;
    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;
    private LocalDateTime createdAt;

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
