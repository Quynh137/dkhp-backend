package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.ChiTietHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietHocPhanRepository extends JpaRepository<ChiTietHocPhan, String> {
    List<ChiTietHocPhan> findByLopHocPhanMaLopHocPhan(String maLopHocPhan);
}