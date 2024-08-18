package com.depun.restproject.proyek;

import com.depun.restproject.lokasi.Lokasi;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "proyek")
public class Proyek {

    @Id
    @Column(name = "id_pk")
    private Integer idPk;

    @Column(name = "nama_proyek")
    private String namaProyek;

    @Column(name = "client")
    private String client;

    @Column(name = "tgl_mulai")
    private LocalDate tglMulai;

    @Column(name = "tgl_selesai")
    private LocalDate tglSelesai;

    @Column(name = "pimpinan_proyek")
    private String pimpinanProyek;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "proyek_lokasi",
            joinColumns = @JoinColumn(name = "proyek_id_pk"),
            inverseJoinColumns = @JoinColumn(name = "lokasi_id_pk")
    )
    private List<Lokasi> lokasiList;

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

    public List<Lokasi> getLokasiList() {
        return lokasiList;
    }
    public void setLokasiList(List<Lokasi> lokasiList) {
        this.lokasiList = lokasiList;
    }
}
