package ui.ft.ccit.faculty.transaksi.domain.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.model.Details_Transaksi;
import ui.ft.ccit.faculty.transaksi.model.Details_TransaksiId;
import ui.ft.ccit.faculty.transaksi.domain.repository.Details_TransaksiRepository;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;

@Service
@Transactional
public class Details_TransaksiService {

    private final Details_TransaksiRepository detailTransaksiRepository;

    public Details_TransaksiService(Details_TransaksiRepository detailTransaksiRepository){
        this.detailTransaksiRepository = detailTransaksiRepository;
    }

    public List<Details_Transaksi> getAll(){
        return detailTransaksiRepository.findAll();
    }

    public List<Details_Transaksi> getAllWithPagination(int page, int size) {
        return detailTransaksiRepository
                .findAll(PageRequest.of(page, size))
                .getContent();
    }

    public Details_Transaksi getById(String kodeTransaksi, String idBarang){
        Details_TransaksiId id = new Details_TransaksiId(kodeTransaksi, idBarang);
        return detailTransaksiRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Detail Transaksi", 
                kodeTransaksi + "-" + idBarang));
    }

    public List<Details_Transaksi> searchDetails(String kode, String barang) {
        return detailTransaksiRepository.findByAdvancedSearch(kode, barang);
    }

    public List<Details_Transaksi> getByKodeTransaksi(String kodeTransaksi){
        return detailTransaksiRepository.findByIdKodeTransaksi(kodeTransaksi);
    }

    public List<Details_Transaksi> getByIdBarang(String idBarang){
        return detailTransaksiRepository.findByIdIdBarang(idBarang);
    }

    public Details_Transaksi create(Details_Transaksi detailTransaksi){
        return detailTransaksiRepository.save(detailTransaksi);
    }

    public Details_Transaksi update(String kodeTransaksi, String idBarang, Details_Transaksi detailTransaksiDetails){
        Details_Transaksi detailTransaksi = getById(kodeTransaksi, idBarang);
        detailTransaksi.setJumlah(detailTransaksiDetails.getJumlah());
        return detailTransaksiRepository.save(detailTransaksi);
    }

    public void delete(String kodeTransaksi, String idBarang){
        Details_Transaksi detailTransaksi = getById(kodeTransaksi, idBarang);
        detailTransaksiRepository.delete(detailTransaksi);
    }
    
}