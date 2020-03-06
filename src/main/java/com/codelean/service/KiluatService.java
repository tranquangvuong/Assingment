package com.codelean.service;



import com.codelean.model.Kiluat;
import com.codelean.model.Nhanvien;

import java.util.Optional;

public interface KiluatService {
    Iterable<Kiluat> findAll();

    Optional<Kiluat> findById(Long id);

    void save(Kiluat kiluat);

    void remove(Long id);

    Iterable<Kiluat> findAllByNhanvien(Nhanvien nhanvien);
}
