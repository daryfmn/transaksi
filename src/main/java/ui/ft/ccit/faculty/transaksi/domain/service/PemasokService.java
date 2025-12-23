package ui.ft.ccit.faculty.transaksi.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.domain.repository.PemasokRepository;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;

@Service
@Transactional
public class PemasokService {

    private final PemasokRepository pemasokRepository;

    public PemasokService(PemasokRepository pemasokRepository){
        this.pemasokRepository = pemasokRepository;
    }

    public List<Pemasok> getAll(){
        return pemasokRepository.findAll();
    }

    public Pemasok getById(String id){
        return pemasokRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Pemasok", id));
    }

    public Pemasok create(Pemasok pemasok){
        return pemasokRepository.save(pemasok);
    }

    public Pemasok update(String id, Pemasok pemasokDetails){
        Pemasok pemasok = getById(id);
        pemasok.setNamaPemasok(pemasokDetails.getNamaPemasok());
        pemasok.setAlamat(pemasokDetails.getAlamat());
        pemasok.setTelepon(pemasokDetails.getTelepon());
        pemasok.setEmail(pemasokDetails.getEmail());
        return pemasokRepository.save(pemasok);
    }

    public void delete(String id){
        Pemasok pemasok = getById(id);
        pemasokRepository.delete(pemasok);
    }
    
}