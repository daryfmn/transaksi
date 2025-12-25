package ui.ft.ccit.faculty.transaksi.domain.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.domain.repository.JenisBarangRepository;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;

@Service
@Transactional
public class JenisBarangService {

    private final JenisBarangRepository jenisBarangRepository;

    public JenisBarangService(JenisBarangRepository jenisBarangRepository){
        this.jenisBarangRepository = jenisBarangRepository;
    }

    public List<JenisBarang> getAll(){
        return jenisBarangRepository.findAll();
    }

    public List<JenisBarang> getAllWithPagination(int page, int size) {
        return jenisBarangRepository
                .findAll(PageRequest.of(page, size))
                .getContent();
    }

    public List<JenisBarang> searchByNamaJenis(String keyword) {
        return jenisBarangRepository.findByNamaJenisContainingIgnoreCase(keyword);
    }

    public JenisBarang getById(Byte id){
        return jenisBarangRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Jenis Barang", id.toString()));
    }

    public JenisBarang create(JenisBarang jenisBarang){
        return jenisBarangRepository.save(jenisBarang);
    }

    public JenisBarang update(Byte id, JenisBarang jenisBarangDetails){
        JenisBarang jenisBarang = getById(id);
        jenisBarang.setNamaJenis(jenisBarangDetails.getNamaJenis());
        return jenisBarangRepository.save(jenisBarang);
    }

    public void delete(Byte id){
        JenisBarang jenisBarang = getById(id);
        jenisBarangRepository.delete(jenisBarang);
    }
    
}