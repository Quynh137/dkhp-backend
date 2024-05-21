package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.ChiTietHocPhan;
import com.example.dkhpbackend.repository.ChiTietHocPhanRepository;
import com.example.dkhpbackend.service.ChiTietHocPhanSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietHocPhanServiceImpl implements ChiTietHocPhanSercice {
    @Autowired
    private ChiTietHocPhanRepository chiTietHocPhanRepository;

    public List<ChiTietHocPhan> getAllChiTietHocPhan() {
        return chiTietHocPhanRepository.findAll();
    }

    public ChiTietHocPhan addChiTietHocPhan(ChiTietHocPhan chiTietHocPhan) {
        return chiTietHocPhanRepository.save(chiTietHocPhan);
    }

    public ChiTietHocPhan updateChiTietHocPhan(String maChiTietHocPhan, ChiTietHocPhan chiTietHocPhan) {
        if (!chiTietHocPhanRepository.existsById(maChiTietHocPhan)) {
            throw new RuntimeException("Chi tiết học phần không tồn tại");
        }
        chiTietHocPhan.setMaChiTietHocPhan(maChiTietHocPhan);
        return chiTietHocPhanRepository.save(chiTietHocPhan);
    }

    public void deleteChiTietHocPhan(String maChiTietHocPhan) {
        if (!chiTietHocPhanRepository.existsById(maChiTietHocPhan)) {
            throw new RuntimeException("Chi tiết học phần không tồn tại");
        }
        chiTietHocPhanRepository.deleteById(maChiTietHocPhan);
    }

    public List<ChiTietHocPhan> getChiTietHocPhanByMaLopHocPhan(String maLopHocPhan) {
        return chiTietHocPhanRepository.findByLopHocPhanMaLopHocPhan(maLopHocPhan);
    }

}
