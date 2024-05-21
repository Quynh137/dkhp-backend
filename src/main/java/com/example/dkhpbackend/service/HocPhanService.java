package com.example.dkhpbackend.service;

import com.example.dkhpbackend.entity.HocPhan;

import java.util.List;

public interface HocPhanService {
    List<HocPhan> getAllHocPhan();

    HocPhan addHocPhan(HocPhan hocPhan);

    HocPhan updateHocPhan(String maHocPhan, HocPhan hocPhan);

    void deleteHocPhan(String maHocPhan);

    List<HocPhan> getHocPhanByMaChuyenNganh(String maChuyenNganh);

}
