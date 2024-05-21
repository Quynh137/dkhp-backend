package com.example.dkhpbackend.service;

import com.example.dkhpbackend.entity.LopHocPhan;

import java.util.List;

public interface LopHocPhanService {
    List<LopHocPhan> getAllLopHocPhan();

    LopHocPhan addLopHocPhan(LopHocPhan lopHocPhan);

    LopHocPhan updateLopHocPhan(String maLopHocPhan, LopHocPhan lopHocPhan);

    void deleteLopHocPhan(String maLopHocPhan);

    List<LopHocPhan> getLopHocPhanByHocPhan(String maHocPhan);

}
