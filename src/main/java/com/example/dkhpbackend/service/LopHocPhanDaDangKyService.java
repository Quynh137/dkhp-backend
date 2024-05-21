package com.example.dkhpbackend.service;

import com.example.dkhpbackend.entity.LopHocPhan;
import com.example.dkhpbackend.entity.LopHocPhanDaDangKy;
import com.example.dkhpbackend.entity.SinhVien;

import java.util.List;

public interface LopHocPhanDaDangKyService {
    LopHocPhanDaDangKy addLopHocPhanDaDangKy(LopHocPhanDaDangKy lopHocPhanDaDangKy);

    List<LopHocPhanDaDangKy> getDanhSachLopHocPhanDaDangKyBySinhVien(String maSinhVien);

    List<LopHocPhanDaDangKy> getSinhVienByLopHocPhan(String maLopHocPhan);

}
