package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Details_Transaksi;
import ui.ft.ccit.faculty.transaksi.model.Details_TransaksiId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Details_TransaksiRepository extends JpaRepository<Details_Transaksi, Details_TransaksiId> {
    
    // Find all details by kode transaksi
    List<Details_Transaksi> findByIdKodeTransaksi(String kodeTransaksi);
    
    // Find all details by id barang
    List<Details_Transaksi> findByIdIdBarang(String idBarang);
}