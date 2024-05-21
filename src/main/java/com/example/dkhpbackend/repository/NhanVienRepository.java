package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    NhanVien findByUsername(String username);
}
