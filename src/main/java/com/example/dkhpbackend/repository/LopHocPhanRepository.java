package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, String> {
    List<LopHocPhan> findByHocPhanMaHocPhan(String maHocPhan);
}