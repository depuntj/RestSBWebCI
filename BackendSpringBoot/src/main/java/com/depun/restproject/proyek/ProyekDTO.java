package com.depun.restproject.proyek;

import com.depun.restproject.lokasi.LokasiDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ProyekDTO {
    private Integer idPk;
    private String namaProyek;
    private String client;
    private LocalDate tglMulai;
    private LocalDate tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private LocalDateTime createdAt;
    private List<LokasiDTO> lokasiList;

    public Integer getIdPk() {
        return idPk;
    }
    public void setIdPk(Integer idPk) {
        this.idPk = idPk;
    }
    public String getNamaProyek() {
        return namaProyek;
    }
    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public LocalDate getTglMulai() {
        return tglMulai;
    }
    public void setTglMulai(LocalDate tglMulai) {
        this.tglMulai = tglMulai;
    }
    public LocalDate getTglSelesai() {
        return tglSelesai;
    }
    public void setTglSelesai(LocalDate tglSelesai) {
        this.tglSelesai = tglSelesai;
    }
    public String getPimpinanProyek() {
        return pimpinanProyek;
    }
    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }
    public String getKeterangan() {
        return keterangan;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public List<LokasiDTO> getLokasiList() {
        return lokasiList;
    }
    public void setLokasiList(List<LokasiDTO> lokasiList) {
        this.lokasiList = lokasiList;
    }
}
