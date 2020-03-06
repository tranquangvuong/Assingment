package com.codelean.service;

import com.codelean.model.Nhanvien;
import com.codelean.model.Phongban;

import java.util.Optional;

public interface NhanvienService {
    Iterable<Nhanvien> findAll();

    Optional<Nhanvien> findById(Long id);

    void save(Nhanvien nhanvien);

    void remove(Long id);

    Iterable<Nhanvien> findAllByPhongBan(Phongban phongban);
}
