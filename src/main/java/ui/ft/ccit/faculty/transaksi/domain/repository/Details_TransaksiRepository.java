package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Details_Transaksi;
import ui.ft.ccit.faculty.transaksi.model.Details_TransaksiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Details_TransaksiRepository extends JpaRepository<Details_Transaksi, Details_TransaksiId> {

    @Query("SELECT d FROM Details_Transaksi d WHERE " +
           "(:kodeTransaksi IS NULL OR d.id.kodeTransaksi = :kodeTransaksi) AND " +
           "(:idBarang IS NULL OR d.id.idBarang = :idBarang)")
    List<Details_Transaksi> findByAdvancedSearch(
        @Param("kodeTransaksi") String kodeTransaksi, 
        @Param("idBarang") String idBarang
    );

    // Find all details by kode transaksi
    List<Details_Transaksi> findByIdKodeTransaksi(String kodeTransaksi);
    
    // Find all details by id barang
    List<Details_Transaksi> findByIdIdBarang(String idBarang);
}