package com.codelean.service;

import com.codelean.model.Kiluat;
import com.codelean.model.Nhanvien;
import com.codelean.repository.KiluatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class KiluatServiceImpl implements KiluatService {

    @Autowired
    private KiluatRepository kiluatRepository;

    @Override
    public Iterable<Kiluat> findAll() {
       return kiluatRepository.findAll();
    }

    @Override
    public Optional<Kiluat> findById(Long id) {
        return kiluatRepository.findById(id);
    }

    @Override
    public void save(Kiluat kiluat) {
    kiluatRepository.save(kiluat);
    }

    @Override
    public void remove(Long id) {
kiluatRepository.deleteById(id);
    }

    @Override
    public Iterable<Kiluat> findAllByNhanvien(Nhanvien nhanvien) {
        return kiluatRepository.findAllByNhanvien(nhanvien);
    }
}
