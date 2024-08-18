package com.depun.restproject.proyeklokasi;

import jakarta.persistence.*;
import com.depun.restproject.proyek.Proyek;
import com.depun.restproject.lokasi.Lokasi;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "proyek_lokasi")
@IdClass(ProyekLokasiId.class)
public class ProyekLokasi implements Serializable {

    @Id
    @Column(name = "proyek_id_pk")
    private Integer proyekIdPk;

    @Id
    @Column(name = "lokasi_id_pk")
    private Integer lokasiIdPk;

    @ManyToOne
    @JoinColumn(name = "proyek_id_pk", insertable = false, updatable = false)
    private Proyek proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id_pk", insertable = false, updatable = false)
    private Lokasi lokasi;
    public ProyekLokasi() {}

    public ProyekLokasi(Integer proyekIdPk, Integer lokasiIdPk) {
        this.proyekIdPk = proyekIdPk;
        this.lokasiIdPk = lokasiIdPk;
    }

    // Getters and Setters
    public Integer getProyekIdPk() {
        return proyekIdPk;
    }

    public void setProyekIdPk(Integer proyekIdPk) {
        this.proyekIdPk = proyekIdPk;
    }

    public Integer getLokasiIdPk() {
        return lokasiIdPk;
    }

    public void setLokasiIdPk(Integer lokasiIdPk) {
        this.lokasiIdPk = lokasiIdPk;
    }

    public Proyek getProyek() {
        return proyek;
    }

    public void setProyek(Proyek proyek) {
        this.proyek = proyek;
        if (proyek != null) {
            this.proyekIdPk = proyek.getIdPk();
        }
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
        if (lokasi != null) {
            this.lokasiIdPk = lokasi.getIdPk();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyekLokasi that = (ProyekLokasi) o;
        return Objects.equals(proyekIdPk, that.proyekIdPk) &&
                Objects.equals(lokasiIdPk, that.lokasiIdPk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyekIdPk, lokasiIdPk);
    }
}
