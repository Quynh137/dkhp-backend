package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.TonGiao;
import com.example.dkhpbackend.repository.TonGiaoRepository;
import com.example.dkhpbackend.service.TonGiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TonGiaoServiceImpl implements TonGiaoService {

    @Autowired
    private TonGiaoRepository tonGiaoRepository;

    @Override
    public List<TonGiao> getAllTonGiao() {
        return tonGiaoRepository.findAll();
    }
}
