package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.ChiTietHocPhan;
import com.example.dkhpbackend.service.ChiTietHocPhanSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/chitiethocphan")
public class ChiTietHocPhanController {
    @Autowired
    private ChiTietHocPhanSercice chiTietHocPhanService;

    @GetMapping
    public List<ChiTietHocPhan> getAllChiTietHocPhan() {
        return chiTietHocPhanService.getAllChiTietHocPhan();
    }

    @PostMapping
    public ChiTietHocPhan addChiTietHocPhan(@RequestBody ChiTietHocPhan chiTietHocPhan)
    {
        return chiTietHocPhanService.addChiTietHocPhan(chiTietHocPhan);
    }
    @PutMapping("/{maChiTietHocPhan}")
    public ResponseEntity<ChiTietHocPhan> updateChiTietHocPhan(@PathVariable String maChiTietHocPhan, @RequestBody ChiTietHocPhan chiTietHocPhan) {
        try {
            ChiTietHocPhan updatedChiTietHocPhan = chiTietHocPhanService.updateChiTietHocPhan(maChiTietHocPhan, chiTietHocPhan);
            return ResponseEntity.ok(updatedChiTietHocPhan);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/lop/{maLopHocPhan}") // Thêm mapping để lấy chi tiết học phần theo mã lớp học phần
    public List<ChiTietHocPhan> getChiTietHocPhanByMaLopHocPhan(@PathVariable String maLopHocPhan) {
        return chiTietHocPhanService.getChiTietHocPhanByMaLopHocPhan(maLopHocPhan);
    }
    @DeleteMapping("/{maChiTietHocPhan}")
    public ResponseEntity<Void> deleteChiTietHocPhan(@PathVariable String maChiTietHocPhan) {
        try {
            chiTietHocPhanService.deleteChiTietHocPhan(maChiTietHocPhan);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
