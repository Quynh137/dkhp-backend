package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.entity.ChuyenNganh;
import com.example.dkhpbackend.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/chuyennganh")
public class ChuyenNganhController {

    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @GetMapping
    public List<ChuyenNganh> getAllChuyenNganh() {
        return chuyenNganhService.getAllChuyenNganh();
    }

    @GetMapping("/{maChuyenNganh}")
    public ResponseEntity<ChuyenNganh> getChuyenNganhById(@PathVariable String maChuyenNganh) {
        Optional<ChuyenNganh> chuyenNganh = chuyenNganhService.getChuyenNganhById(maChuyenNganh);
        return chuyenNganh.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ChuyenNganh addChuyenNganh(@RequestBody ChuyenNganh chuyenNganh) {
        return chuyenNganhService.addChuyenNganh(chuyenNganh);
    }

    @PutMapping("/{maChuyenNganh}")
    public ResponseEntity<ChuyenNganh> updateChuyenNganh(@PathVariable String maChuyenNganh, @RequestBody ChuyenNganh chuyenNganh) {
        try {
            ChuyenNganh updatedChuyenNganh = chuyenNganhService.updateChuyenNganh(maChuyenNganh, chuyenNganh);
            return ResponseEntity.ok(updatedChuyenNganh);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{maChuyenNganh}")
    public ResponseEntity<Void> deleteChuyenNganh(@PathVariable String maChuyenNganh) {
        try {
            chuyenNganhService.deleteChuyenNganh(maChuyenNganh);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
