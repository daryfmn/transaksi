package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Transaksi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
    @Query("SELECT t FROM Transaksi t WHERE " +
       "(:kode IS NULL OR LOWER(t.kodeTransaksi) LIKE LOWER(CONCAT('%', :kode, '%'))) AND " +
       "(:tgl IS NULL OR CAST(t.tglTransaksi AS date) = :tgl) AND " +
       "(:karyawan IS NULL OR LOWER(t.karyawan.nama) LIKE LOWER(CONCAT('%', :karyawan, '%'))) AND " +
       "(:pelanggan IS NULL OR LOWER(t.pelanggan.nama) LIKE LOWER(CONCAT('%', :pelanggan, '%')))")
    List<Transaksi> findByAdvancedSearch(
        @Param("kode") String kode, 
        @Param("tgl") java.time.LocalDate tgl, 
        @Param("karyawan") String karyawan, 
        @Param("pelanggan") String pelanggan
    );
}