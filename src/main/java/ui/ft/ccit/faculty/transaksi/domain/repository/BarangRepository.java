package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BarangRepository extends JpaRepository<Barang, String> {

    // cari berdasarkan nama mengandung kata tertentu
    List<Barang> findByNamaContainingIgnoreCase(String keyword);

    // contoh lain: barang dengan stok kurang dari angka tertentu
    List<Barang> findByStokLessThan(Integer stok);

    // hitung berapa banyak barang dengan idBarang dalam daftar tertentu
    long countByIdBarangIn(List<String> idBarangList);
}
