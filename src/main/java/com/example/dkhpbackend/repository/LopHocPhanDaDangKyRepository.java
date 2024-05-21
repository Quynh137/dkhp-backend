package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.LopHocPhanDaDangKy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LopHocPhanDaDangKyRepository extends JpaRepository<LopHocPhanDaDangKy, Integer> {
    List<LopHocPhanDaDangKy> findBySinhVienMaSinhVien(String maSinhVien);

    List<LopHocPhanDaDangKy> findByLopHocPhan_MaLopHocPhan(String maLopHocPhan);
}