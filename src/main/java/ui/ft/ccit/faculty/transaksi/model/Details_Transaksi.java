package ui.ft.ccit.faculty.transaksi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_transaksi")
public class Details_Transaksi {

    @EmbeddedId
    private Details_TransaksiId id;

    @ManyToOne
    @MapsId("kodeTransaksi")
    @JoinColumn(name = "kode_transaksi", nullable = false)
    private Transaksi transaksi;

    @ManyToOne
    @MapsId("idBarang")
    @JoinColumn(name = "id_barang", nullable = false)
    private Barang barang;

    @Column(name = "jumlah", nullable = false)
    private Integer jumlah;

    protected Details_Transaksi() {
        // untuk JPA
    }

    public Details_Transaksi(Details_TransaksiId id, Transaksi transaksi, Barang barang, Integer jumlah) {
        this.id = id;
        this.transaksi = transaksi;
        this.barang = barang;
        this.jumlah = jumlah;
    }

    // === GETTERS & SETTERS ===

    public Details_TransaksiId getId() {
        return id;
    }

    public void setId(Details_TransaksiId id) {
        this.id = id;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}