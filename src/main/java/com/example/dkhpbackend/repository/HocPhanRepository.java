package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, String> {
    List<HocPhan> findByMonHoc_ChuyenNganh_MaChuyenNganh(String maChuyenNganh);
}
