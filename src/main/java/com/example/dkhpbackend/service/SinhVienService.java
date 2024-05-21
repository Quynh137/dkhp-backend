package com.example.dkhpbackend.service;

import com.example.dkhpbackend.entity.SinhVien;

import java.util.List;

public interface SinhVienService {
    public List<SinhVien> getAllSinhVien();

    SinhVien addSinhVien(SinhVien sinhVien);

    SinhVien updateSinhVien(String maSinhVien, SinhVien sinhVien);

    void deleteSinhVien(String maSinhVien);

    SinhVien getSinhVienByMaSinhVien(String maSinhVien);

}
