package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.SinhVien;
import com.example.dkhpbackend.repository.SinhVienRepository;
import com.example.dkhpbackend.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Override
    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    @Override
    public SinhVien addSinhVien(SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }

    @Override
    public SinhVien updateSinhVien(String maSinhVien, SinhVien sinhVien) {
        SinhVien existingSinhVien = sinhVienRepository.findById(maSinhVien)
                .orElseThrow(() -> new RuntimeException("SinhVien not found"));

        // Cập nhật thông tin sinh viên
        existingSinhVien.setHoTen(sinhVien.getHoTen());
        existingSinhVien.setGmail(sinhVien.getGmail());
        // Cập nhật các trường khác

        return sinhVienRepository.save(existingSinhVien);
    }

    @Override
    public void deleteSinhVien(String maSinhVien) {
        sinhVienRepository.deleteById(maSinhVien);

    }

    @Override
    public SinhVien getSinhVienByMaSinhVien(String maSinhVien) {
        return sinhVienRepository.findById(maSinhVien)
                .orElseThrow(() -> new RuntimeException("SinhVien not found"));
    }

}
