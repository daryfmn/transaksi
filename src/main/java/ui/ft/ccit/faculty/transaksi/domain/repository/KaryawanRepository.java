package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Karyawan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KaryawanRepository extends JpaRepository<Karyawan, String> {
    List<Karyawan> findByNamaContainingIgnoreCase(String keyword);
}