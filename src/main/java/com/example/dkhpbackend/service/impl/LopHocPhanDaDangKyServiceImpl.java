package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.LopHocPhan;
import com.example.dkhpbackend.entity.LopHocPhanDaDangKy;
import com.example.dkhpbackend.repository.LopHocPhanDaDangKyRepository;
import com.example.dkhpbackend.service.LopHocPhanDaDangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LopHocPhanDaDangKyServiceImpl implements LopHocPhanDaDangKyService {
    @Autowired
    private LopHocPhanDaDangKyRepository lopHocPhanDaDangKyRepository;

    @Override
    public LopHocPhanDaDangKy addLopHocPhanDaDangKy(LopHocPhanDaDangKy lopHocPhanDaDangKy) {
        return lopHocPhanDaDangKyRepository.save(lopHocPhanDaDangKy);
    }

    @Override
    public List<LopHocPhanDaDangKy> getDanhSachLopHocPhanDaDangKyBySinhVien(String maSinhVien) {
        return lopHocPhanDaDangKyRepository.findBySinhVienMaSinhVien(maSinhVien);
    }

    @Override
    public List<LopHocPhanDaDangKy> getSinhVienByLopHocPhan(String maLopHocPhan) {
        return lopHocPhanDaDangKyRepository.findByLopHocPhan_MaLopHocPhan(maLopHocPhan);
    }
}
