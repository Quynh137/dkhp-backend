package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.TrangThaiHocTap;
import com.example.dkhpbackend.repository.TrangThaiHocTapRepository;
import com.example.dkhpbackend.service.TrangThaiHocTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrangThaiHocTapServiceImpl implements TrangThaiHocTapService {
    @Autowired
    private TrangThaiHocTapRepository trangThaiHocTapRepository;

    @Override
    public List<TrangThaiHocTap> getAllTrangThaiHocTap() {
        return trangThaiHocTapRepository.findAll();
    }
}
