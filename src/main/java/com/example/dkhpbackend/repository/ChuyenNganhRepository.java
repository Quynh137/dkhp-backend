package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.ChuyenNganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh, String> {

}