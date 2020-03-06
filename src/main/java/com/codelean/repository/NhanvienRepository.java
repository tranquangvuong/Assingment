package com.codelean.repository;

import com.codelean.model.Nhanvien;
import com.codelean.model.Phongban;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanvienRepository extends PagingAndSortingRepository<Nhanvien, Long> {
    Iterable<Nhanvien> findAllByPhongban(Phongban phongban);
}
