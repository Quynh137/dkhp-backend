package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.TrangThaiHocTap;
import com.example.dkhpbackend.service.TrangThaiHocTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/trangthaihoctap")
public class TrangThaiHocTapController {

    @Autowired
    private TrangThaiHocTapService trangThaiHocTapService;

    @GetMapping
    public List<TrangThaiHocTap> getALLTrangThaiHocTap(){
        return trangThaiHocTapService.getAllTrangThaiHocTap();
    }
}
