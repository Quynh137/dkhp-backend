package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.MonHoc;
import com.example.dkhpbackend.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/monhoc")
public class MonHocController {

    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public List<MonHoc> getAllMonHoc(){
        return  monHocService.getAllMonHoc();
    }

    // Thêm môn học
    @PostMapping
    public MonHoc addMonHoc(@RequestBody MonHoc monHoc) {
        return monHocService.addMonHoc(monHoc);
    }

    // Sửa thông tin môn học
    @PutMapping("/{maMonHoc}")
    public ResponseEntity<MonHoc> updateMonHoc(@PathVariable String maMonHoc, @RequestBody MonHoc monHoc) {
        try {
            MonHoc updatedMonHoc = monHocService.updateMonHoc(maMonHoc, monHoc);
            return ResponseEntity.ok(updatedMonHoc);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa môn học
    @DeleteMapping("/{maMonHoc}")
    public ResponseEntity<Void> deleteMonHoc(@PathVariable String maMonHoc) {
        try {
            monHocService.deleteMonHoc(maMonHoc);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
