package com.depun.restproject.proyeklokasi;

import java.io.Serializable;
import java.util.Objects;

public class ProyekLokasiId implements Serializable {
    private static final long serialVersionUID = 1L; // Added serialVersionUID for serialization

    private Integer proyekIdPk;
    private Integer lokasiIdPk;

    public ProyekLokasiId() {}

    public ProyekLokasiId(Integer proyekIdPk, Integer lokasiIdPk) {
        this.proyekIdPk = proyekIdPk;
        this.lokasiIdPk = lokasiIdPk;
    }
    
    public Integer getProyekIdPk() { return proyekIdPk; }
    public void setProyekIdPk(Integer proyekIdPk) { this.proyekIdPk = proyekIdPk; }

    public Integer getLokasiIdPk() { return lokasiIdPk; }
    public void setLokasiIdPk(Integer lokasiIdPk) { this.lokasiIdPk = lokasiIdPk; }

    // Override equals method to compare based on composite key values
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyekLokasiId that = (ProyekLokasiId) o;
        return Objects.equals(proyekIdPk, that.proyekIdPk) &&
                Objects.equals(lokasiIdPk, that.lokasiIdPk);
    }

    // Override hashCode method to generate hash based on composite key values
    @Override
    public int hashCode() {
        return Objects.hash(proyekIdPk, lokasiIdPk);
    }
}
