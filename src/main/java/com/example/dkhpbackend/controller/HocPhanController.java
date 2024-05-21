package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.HocPhan;
import com.example.dkhpbackend.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hocphan")
public class HocPhanController {
    @Autowired
    private HocPhanService hocPhanService;

    // Lấy tất cả học phần
    @GetMapping
    public List<HocPhan> getAllHocPhan() {
        return hocPhanService.getAllHocPhan();
    }

//    // Lấy học phần theo mã chuyên ngành
@GetMapping("/chuyen-nganh/{maChuyenNganh}")
public List<HocPhan> getHocPhanByMaChuyenNganh(@PathVariable String maChuyenNganh) {
    return hocPhanService.getHocPhanByMaChuyenNganh(maChuyenNganh);
}


    // Thêm học phần mới
    @PostMapping
    public HocPhan addHocPhan(@RequestBody HocPhan hocPhan) {
        return hocPhanService.addHocPhan(hocPhan);
    }

    // Sửa thông tin học phần
    @PutMapping("/{maHocPhan}")
    public ResponseEntity<HocPhan> updateHocPhan(@PathVariable String maHocPhan, @RequestBody HocPhan hocPhan) {
        try {
            HocPhan updatedHocPhan = hocPhanService.updateHocPhan(maHocPhan, hocPhan);
            return ResponseEntity.ok(updatedHocPhan);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa học phần
    @DeleteMapping("/{maHocPhan}")
    public ResponseEntity<Void> deleteHocPhan(@PathVariable String maHocPhan) {
        try {
            hocPhanService.deleteHocPhan(maHocPhan);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
