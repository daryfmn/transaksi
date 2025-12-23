package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
    
}