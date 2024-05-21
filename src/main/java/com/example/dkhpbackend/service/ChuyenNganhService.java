package com.example.dkhpbackend.service;

import com.example.dkhpbackend.entity.ChuyenNganh;

import java.util.List;
import java.util.Optional;

public interface ChuyenNganhService {
    public List<ChuyenNganh> getAllChuyenNganh();

    public Optional<ChuyenNganh> getChuyenNganhById(String maChuyenNganh);

    public ChuyenNganh addChuyenNganh(ChuyenNganh chuyenNganh);

    public ChuyenNganh updateChuyenNganh(String maChuyenNganh, ChuyenNganh chuyenNganh);

    public void deleteChuyenNganh(String maChuyenNganh);
}