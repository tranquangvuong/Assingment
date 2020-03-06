package com.codelean.service;

import com.codelean.model.Nhanvien;
import com.codelean.model.Phongban;
import com.codelean.repository.NhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class NhanvienServiceImpl implements NhanvienService {

    @Autowired
    private NhanvienRepository nhanvienRepository;

    @Override
    public Iterable<Nhanvien> findAll() {
        return nhanvienRepository.findAll();
    }

    @Override
    public Optional<Nhanvien> findById(Long id) {
        return nhanvienRepository.findById(id);
    }

    @Override
    public void save(Nhanvien nhanvien) {
    nhanvienRepository.save(nhanvien);
    }

    @Override
    public void remove(Long id) {
    nhanvienRepository.deleteById(id);
    }

    @Override
    public Iterable<Nhanvien> findAllByPhongBan(Phongban phongban) {
        return nhanvienRepository.findAllByPhongban(phongban);
    }

}
