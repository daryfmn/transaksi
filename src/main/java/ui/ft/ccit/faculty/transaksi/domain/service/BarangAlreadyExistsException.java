package ui.ft.ccit.faculty.transaksi.domain.service;

public class BarangAlreadyExistsException extends RuntimeException {

    public BarangAlreadyExistsException(String idBarang) {
        super("Barang dengan id " + idBarang + " sudah ada");
    }
}
