package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.Khoa;
import com.example.dkhpbackend.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/khoa")
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    @GetMapping
    public List<Khoa> getAllKhoa() {
        return khoaService.getAllKhoa();
    }

    @GetMapping("/{maKhoa}")
    public ResponseEntity<Khoa> getKhoaById(@PathVariable String maKhoa) {
        Optional<Khoa> khoa = khoaService.getKhoaById(maKhoa);
        return khoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Khoa addKhoa(@RequestBody Khoa khoa) {
        return khoaService.addKhoa(khoa);
    }

    @PutMapping("/{maKhoa}")
    public ResponseEntity<Khoa> updateKhoa(@PathVariable String maKhoa, @RequestBody Khoa khoa) {
        try {
            Khoa updatedKhoa = khoaService.updateKhoa(maKhoa, khoa);
            return ResponseEntity.ok(updatedKhoa);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{maKhoa}")
    public ResponseEntity<Void> deleteKhoa(@PathVariable String maKhoa) {
        try {
            khoaService.deleteKhoa(maKhoa);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Thay đổi ở đây
        }
    }
}
