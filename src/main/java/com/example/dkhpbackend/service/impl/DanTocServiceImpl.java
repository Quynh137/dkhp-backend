package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.DanToc;
import com.example.dkhpbackend.repository.DanTocRepository;
import com.example.dkhpbackend.service.DanTocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanTocServiceImpl implements DanTocService {
    @Autowired
    private DanTocRepository danTocRepository;

    @Override
    public List<DanToc> getAllDanToc() {
        return danTocRepository.findAll();
    }
}
