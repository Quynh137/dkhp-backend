package com.example.dkhpbackend.controller;


import com.example.dkhpbackend.entity.SinhVien;
import com.example.dkhpbackend.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sinhvien")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    // Lấy tất cả sinh viên
    @GetMapping
    public List<SinhVien> getAllSinhVien() {
        return sinhVienService.getAllSinhVien();
    }

    // Thêm sinh viên mới
    @PostMapping
    public SinhVien addSinhVien(@RequestBody SinhVien sinhVien) {
        return sinhVienService.addSinhVien(sinhVien);
    }

    // Sửa thông tin sinh viên
    @PutMapping("/{maSinhVien}")
    public ResponseEntity<SinhVien> updateSinhVien(@PathVariable String maSinhVien, @RequestBody SinhVien sinhVien) {
        try {
            SinhVien updatedSinhVien = sinhVienService.updateSinhVien(maSinhVien, sinhVien);
            return ResponseEntity.ok(updatedSinhVien);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{maSinhVien}")
    public ResponseEntity<SinhVien> getSinhVienByMaSinhVien(@PathVariable String maSinhVien) {
        SinhVien sinhVien = sinhVienService.getSinhVienByMaSinhVien(maSinhVien);
        return ResponseEntity.ok(sinhVien);
    }

    // Xóa sinh viên
    @DeleteMapping("/{maSinhVien}")
    public ResponseEntity<Void> deleteSinhVien(@PathVariable String maSinhVien) {
        try {
            sinhVienService.deleteSinhVien(maSinhVien);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
