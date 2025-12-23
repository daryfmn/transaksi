package ui.ft.ccit.faculty.transaksi.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.domain.repository.KaryawanRepository;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;

@Service
@Transactional
public class KaryawanService {

    private final KaryawanRepository karyawanRepository;

    public KaryawanService(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    public List<Karyawan> getAll() {
        return karyawanRepository.findAll();
    }

    public Karyawan getById(String id) {
        return karyawanRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Karyawan", id));
    }

    public Karyawan create(Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

    public Karyawan update(String id, Karyawan karyawanDetails) {
        Karyawan karyawan = getById(id);
        karyawan.setNama(karyawanDetails.getNama());
        karyawan.setJenisKelamin(karyawanDetails.getJenisKelamin());
        karyawan.setAlamat(karyawanDetails.getAlamat());
        karyawan.setTelepon(karyawanDetails.getTelepon());
        karyawan.setTglLahir(karyawanDetails.getTglLahir());
        karyawan.setGaji(karyawanDetails.getGaji());
        return karyawanRepository.save(karyawan);
    }

    public void delete(String id) {
        Karyawan karyawan = getById(id);
        karyawanRepository.delete(karyawan);
    }
}