package ui.ft.ccit.faculty.transaksi.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.domain.repository.TransaksiRepository;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;

@Service
@Transactional
public class TransaksiService {

    private final TransaksiRepository transaksiRepository;

    public TransaksiService(TransaksiRepository transaksiRepository) {
        this.transaksiRepository = transaksiRepository;
    }

    public List<Transaksi> getAll() {
        return transaksiRepository.findAll();
    }

    public Transaksi getById(String id) {
        return transaksiRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Transaksi", id));
    }

    public Transaksi create(Transaksi transaksi) {
        return transaksiRepository.save(transaksi);
    }

    public Transaksi update(String id, Transaksi transaksiDetails) {
        Transaksi transaksi = getById(id);
        transaksi.setTglTransaksi(transaksiDetails.getTglTransaksi());
        transaksi.setPelanggan(transaksiDetails.getPelanggan());
        transaksi.setKaryawan(transaksiDetails.getKaryawan());
        return transaksiRepository.save(transaksi);
    }

    public void delete(String id) {
        Transaksi transaksi = getById(id);
        transaksiRepository.delete(transaksi);
    }
}