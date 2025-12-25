package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.JenisBarang;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JenisBarangRepository extends JpaRepository<JenisBarang, Byte> {
    List<JenisBarang> findByNamaJenisContainingIgnoreCase(String keyword);
}
