package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.LopHocPhan;
import com.example.dkhpbackend.service.LopHocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/lophocphan")
public class LopHocPhanController {
    @Autowired
    private LopHocPhanService lopHocPhanService;

    // Lấy tất cả lớp học phần
    @GetMapping
    public List<LopHocPhan> getAllLopHocPhan() {
        return lopHocPhanService.getAllLopHocPhan();
    }

    // Lấy lớp học phần theo mã học phần
    @GetMapping("/hocphan/{maHocPhan}")
    public List<LopHocPhan> getLopHocPhanByHocPhan(@PathVariable String maHocPhan) {
        return lopHocPhanService.getLopHocPhanByHocPhan(maHocPhan);
    }

    // Thêm lớp học phần mới
    @PostMapping
    public LopHocPhan addLopHocPhan(@RequestBody LopHocPhan lopHocPhan) {
        return lopHocPhanService.addLopHocPhan(lopHocPhan);
    }

    // Sửa thông tin lớp học phần
    @PutMapping("/{maLopHocPhan}")
    public ResponseEntity<LopHocPhan> updateLopHocPhan(@PathVariable String maLopHocPhan, @RequestBody LopHocPhan lopHocPhan) {
        try {
            LopHocPhan updatedLopHocPhan = lopHocPhanService.updateLopHocPhan(maLopHocPhan, lopHocPhan);
            return ResponseEntity.ok(updatedLopHocPhan);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa lớp học phần
    @DeleteMapping("/{maLopHocPhan}")
    public ResponseEntity<Void> deleteLopHocPhan(@PathVariable String maLopHocPhan) {
        try {
            lopHocPhanService.deleteLopHocPhan(maLopHocPhan);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
