package com.codelean.service;

import com.codelean.model.Phongban;
import com.codelean.repository.PhongbanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PhongbanServiceImpl implements PhongbanService{

    @Autowired
    private PhongbanRepository phongbanRepository;

    @Override
    public Iterable<Phongban> findAll() {
        return phongbanRepository.findAll();
    }

    @Override
    public Optional<Phongban> findById(Long id) {
        return phongbanRepository.findById(id);
    }

    @Override
    public void save(Phongban phongban) {
        phongbanRepository.save(phongban);
    }

    @Override
    public void remove(Long id) {
        phongbanRepository.deleteById(id);
    }
}
