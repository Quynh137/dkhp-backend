package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.LopHocPhanDaDangKy;
import com.example.dkhpbackend.service.LopHocPhanDaDangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/lophocphandadangky")
public class LopHocPhanDaDangKyController {
    @Autowired
    private LopHocPhanDaDangKyService lopHocPhanDaDangKyService;

    @PostMapping("/dang-ky")
    public ResponseEntity<LopHocPhanDaDangKy> dangKyLopHocPhan(@RequestBody LopHocPhanDaDangKy lopHocPhanDaDangKy) {
        LopHocPhanDaDangKy result = lopHocPhanDaDangKyService.addLopHocPhanDaDangKy(lopHocPhanDaDangKy);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/sinh-vien/{maSinhVien}")
    public ResponseEntity<List<LopHocPhanDaDangKy>> getDanhSachLopHocPhanDaDangKyBySinhVien(@PathVariable String maSinhVien) {
        List<LopHocPhanDaDangKy> danhSachLopHocPhan = lopHocPhanDaDangKyService.getDanhSachLopHocPhanDaDangKyBySinhVien(maSinhVien);
        return new ResponseEntity<>(danhSachLopHocPhan, HttpStatus.OK);
    }
    @GetMapping("/lop-hoc-phan/{maLopHocPhan}")
    public List<LopHocPhanDaDangKy> getSinhVienByLopHocPhan(@PathVariable String maLopHocPhan) {
        return lopHocPhanDaDangKyService.getSinhVienByLopHocPhan(maLopHocPhan);
    }
}
