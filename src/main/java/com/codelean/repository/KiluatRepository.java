package com.codelean.repository;

import com.codelean.model.Kiluat;
import com.codelean.model.Nhanvien;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KiluatRepository extends PagingAndSortingRepository<Kiluat, Long> {
    Iterable<Kiluat> findAllByNhanvien(Nhanvien nhanvien);
}
