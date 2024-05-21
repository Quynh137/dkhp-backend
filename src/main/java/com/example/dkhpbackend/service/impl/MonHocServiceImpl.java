package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.MonHoc;
import com.example.dkhpbackend.repository.MonHocRepository;
import com.example.dkhpbackend.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonHocServiceImpl implements MonHocService {
    @Autowired
    private MonHocRepository monHocRepository;

    @Override
    public List<MonHoc> getAllMonHoc() {
        return monHocRepository.findAll();
    }

    @Override
    public MonHoc addMonHoc(MonHoc monHoc) {
        // Thêm môn học vào cơ sở dữ liệu
        return monHocRepository.save(monHoc);
    }

    @Override
    public MonHoc updateMonHoc(String maMonHoc, MonHoc monHoc) {
        // Kiểm tra xem môn học có tồn tại không
        MonHoc existingMonHoc = monHocRepository.findById(maMonHoc)
                .orElseThrow(() -> new RuntimeException("Mon Hoc not found"));

        // Cập nhật thông tin của môn học
        existingMonHoc.setTenMonHoc(monHoc.getTenMonHoc());
        existingMonHoc.setChuyenNganh(monHoc.getChuyenNganh());

        // Lưu và trả về môn học đã cập nhật
        return monHocRepository.save(existingMonHoc);
    }

    @Override
    public void deleteMonHoc(String maMonHoc) {
        // Xóa môn học khỏi cơ sở dữ liệu
        monHocRepository.deleteById(maMonHoc);
    }
}
