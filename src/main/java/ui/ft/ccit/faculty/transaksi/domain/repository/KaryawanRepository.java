package ui.ft.ccit.faculty.transaksi.domain.repository;

import ui.ft.ccit.faculty.transaksi.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaryawanRepository extends JpaRepository<Karyawan, String> {
}