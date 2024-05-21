package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.LopHocPhan;
import com.example.dkhpbackend.repository.LopHocPhanRepository;
import com.example.dkhpbackend.service.LopHocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LopHocPhanServiceImpl implements LopHocPhanService {
    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    @Override
    public List<LopHocPhan> getAllLopHocPhan() {
        return lopHocPhanRepository.findAll();
    }

    @Override
    public LopHocPhan addLopHocPhan(LopHocPhan lopHocPhan) {
        return lopHocPhanRepository.save(lopHocPhan);
    }

    @Override
    public LopHocPhan updateLopHocPhan(String maLopHocPhan, LopHocPhan lopHocPhan) {
        LopHocPhan existingLopHocPhan = lopHocPhanRepository.findById(maLopHocPhan)
                .orElseThrow(() -> new RuntimeException("Lop Hoc Phan not found"));

        existingLopHocPhan.setTenLopHocPhan(lopHocPhan.getTenLopHocPhan());
        existingLopHocPhan.setLopDuKien(lopHocPhan.getLopDuKien());
        existingLopHocPhan.setSiSoToiDa(lopHocPhan.getSiSoToiDa());
        existingLopHocPhan.setDaDangKy(lopHocPhan.getDaDangKy());
        existingLopHocPhan.setTrangThai(lopHocPhan.getTrangThai());
        existingLopHocPhan.setGiangVien(lopHocPhan.getGiangVien());
        existingLopHocPhan.setHocPhan(lopHocPhan.getHocPhan());

        return lopHocPhanRepository.save(existingLopHocPhan);
    }

    @Override
    public void deleteLopHocPhan(String maLopHocPhan) {
        lopHocPhanRepository.deleteById(maLopHocPhan);
    }

    @Override
    public List<LopHocPhan> getLopHocPhanByHocPhan(String maHocPhan) {
        return lopHocPhanRepository.findByHocPhanMaHocPhan(maHocPhan);
    }
}
