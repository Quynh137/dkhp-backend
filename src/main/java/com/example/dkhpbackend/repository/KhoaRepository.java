package com.example.dkhpbackend.repository;

import com.example.dkhpbackend.entity.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, String> {
}