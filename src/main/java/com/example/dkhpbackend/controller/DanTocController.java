package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.DanToc;
import com.example.dkhpbackend.service.DanTocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dantoc")
public class DanTocController {
    @Autowired
    private DanTocService danTocService;

    @GetMapping
    public List<DanToc> getAllDanToc(){
        return danTocService.getAllDanToc();
    }
}
