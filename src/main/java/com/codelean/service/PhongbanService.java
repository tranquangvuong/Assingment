package com.codelean.service;

import com.codelean.model.Phongban;

import java.util.Optional;

public interface PhongbanService {
    Iterable<Phongban> findAll();
    Optional<Phongban> findById(Long id);
    void save(Phongban phongban);
    void remove(Long id);
}
