package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Pelanggan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PelangganRepository extends JpaRepository<Pelanggan, String> {
    List<Pelanggan> findByNamaContainingIgnoreCase(String keyword);
}