package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Pemasok;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PemasokRepository extends JpaRepository<Pemasok, String> {
    List<Pemasok> findByNamaPemasokContainingIgnoreCase(String keyword);
}
