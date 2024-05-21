package com.example.dkhpbackend.service;

import com.example.dkhpbackend.entity.ChiTietHocPhan;

import java.util.List;

public interface ChiTietHocPhanSercice {
    public List<ChiTietHocPhan> getAllChiTietHocPhan();

    public ChiTietHocPhan addChiTietHocPhan(ChiTietHocPhan chiTietHocPhan);

    public ChiTietHocPhan updateChiTietHocPhan(String maChiTietHocPhan, ChiTietHocPhan chiTietHocPhan);

    public void deleteChiTietHocPhan(String maChiTietHocPhan);

    public List<ChiTietHocPhan> getChiTietHocPhanByMaLopHocPhan(String maLopHocPhan);

}
