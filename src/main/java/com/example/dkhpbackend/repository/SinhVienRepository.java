package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
    SinhVien findByUsername(String username);
}
