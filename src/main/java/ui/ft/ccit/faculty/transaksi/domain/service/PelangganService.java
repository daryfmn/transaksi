package ui.ft.ccit.faculty.transaksi.domain.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.domain.repository.PelangganRepository;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;

@Service
@Transactional
public class PelangganService {

    private final PelangganRepository pelangganRepository;

    public PelangganService(PelangganRepository pelangganRepository){
        this.pelangganRepository = pelangganRepository;
    }

    public List<Pelanggan> getAll(){
        return pelangganRepository.findAll();
    }

    public List<Pelanggan> getAllWithPagination(int page, int size) {
        return pelangganRepository
                .findAll(PageRequest.of(page, size))
                .getContent();
    }

    public List<Pelanggan> searchByNama(String keyword) {
        return pelangganRepository.findByNamaContainingIgnoreCase(keyword);
    }

    public Pelanggan getById(String id){
        return pelangganRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Pelanggan", id));
    }

    public Pelanggan create(Pelanggan pelanggan){
        return pelangganRepository.save(pelanggan);
    }

    public Pelanggan update(String id, Pelanggan pelangganDetails){
        Pelanggan pelanggan = getById(id);
        pelanggan.setNama(pelangganDetails.getNama());
        pelanggan.setJenisKelamin(pelangganDetails.getJenisKelamin());
        pelanggan.setAlamat(pelangganDetails.getAlamat());
        pelanggan.setTelepon(pelangganDetails.getTelepon());
        pelanggan.setTglLahir(pelangganDetails.getTglLahir());
        pelanggan.setJenisPelanggan(pelangganDetails.getJenisPelanggan());
        return pelangganRepository.save(pelanggan);
    }

    public void delete(String id){
        Pelanggan pelanggan = getById(id);
        pelangganRepository.delete(pelanggan);
    }
    
}