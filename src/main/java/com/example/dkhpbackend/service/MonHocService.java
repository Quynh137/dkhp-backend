package com.example.dkhpbackend.service;

import com.example.dkhpbackend.entity.MonHoc;

import java.util.List;

public interface MonHocService {
    List<MonHoc> getAllMonHoc();

    MonHoc addMonHoc(MonHoc monHoc);

    MonHoc updateMonHoc(String maMonHoc, MonHoc monHoc);

    void deleteMonHoc(String maMonHoc);
}
