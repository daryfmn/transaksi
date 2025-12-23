package ui.ft.ccit.faculty.transaksi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Details_TransaksiId implements Serializable {

    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Column(name = "id_barang", length = 4)
    private String idBarang;

    public Details_TransaksiId() {
    }

    public Details_TransaksiId(String kodeTransaksi, String idBarang) {
        this.kodeTransaksi = kodeTransaksi;
        this.idBarang = idBarang;
    }

    // === GETTERS & SETTERS ===

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    // === EQUALS & HASHCODE ===

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details_TransaksiId that = (Details_TransaksiId) o;
        return Objects.equals(kodeTransaksi, that.kodeTransaksi) &&
               Objects.equals(idBarang, that.idBarang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kodeTransaksi, idBarang);
    }
}