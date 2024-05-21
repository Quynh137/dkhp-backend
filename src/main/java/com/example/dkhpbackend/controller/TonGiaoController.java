package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.TonGiao;
import com.example.dkhpbackend.service.TonGiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tongiao")
public class TonGiaoController {

    @Autowired
    private TonGiaoService tonGiaoService;

    @GetMapping
    public List<TonGiao> getALlTonGiao(){
        return tonGiaoService.getAllTonGiao();
    }
}
