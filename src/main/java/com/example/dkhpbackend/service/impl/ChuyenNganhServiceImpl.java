package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.ChuyenNganh;
import com.example.dkhpbackend.repository.ChuyenNganhRepository;
import com.example.dkhpbackend.repository.KhoaRepository;
import com.example.dkhpbackend.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChuyenNganhServiceImpl implements ChuyenNganhService {
    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;

    @Override
    public List<ChuyenNganh> getAllChuyenNganh() {
        return chuyenNganhRepository.findAll();
    }

    @Override
    public Optional<ChuyenNganh> getChuyenNganhById(String maChuyenNganh) {
        return chuyenNganhRepository.findById(maChuyenNganh);
    }

    @Override
    public ChuyenNganh addChuyenNganh(ChuyenNganh chuyenNganh) {
        return chuyenNganhRepository.save(chuyenNganh);
    }

    @Override
    public ChuyenNganh updateChuyenNganh(String maChuyenNganh, ChuyenNganh chuyenNganh) {
        chuyenNganh.setMaChuyenNganh(maChuyenNganh);
        return chuyenNganhRepository.save(chuyenNganh);
    }

    @Override
    public void deleteChuyenNganh(String maChuyenNganh) {
        chuyenNganhRepository.deleteById(maChuyenNganh);
    }
}
