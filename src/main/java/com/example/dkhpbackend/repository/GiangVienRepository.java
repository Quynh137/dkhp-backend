package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, String> {
    GiangVien findByUsername(String username);
}
