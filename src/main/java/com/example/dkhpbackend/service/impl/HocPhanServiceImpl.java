package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.HocPhan;
import com.example.dkhpbackend.repository.HocPhanRepository;
import com.example.dkhpbackend.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocPhanServiceImpl implements HocPhanService {
    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Override
    public List<HocPhan> getAllHocPhan() {
        return hocPhanRepository.findAll();
    }

    @Override
    public HocPhan addHocPhan(HocPhan hocPhan) {
        return hocPhanRepository.save(hocPhan);
    }

    @Override
    public HocPhan updateHocPhan(String maHocPhan, HocPhan hocPhan) {
        HocPhan existingHocPhan = hocPhanRepository.findById(maHocPhan)
                .orElseThrow(() -> new RuntimeException("Hoc Phan not found"));

        existingHocPhan.setTenHocPhan(hocPhan.getTenHocPhan());
        existingHocPhan.setSoTinChi(hocPhan.getSoTinChi());
        // Cập nhật các thông tin khác của học phần

        return hocPhanRepository.save(existingHocPhan);
    }

    @Override
    public void deleteHocPhan(String maHocPhan) {
        hocPhanRepository.deleteById(maHocPhan);
    }

    @Override
    public List<HocPhan> getHocPhanByMaChuyenNganh(String maChuyenNganh) {
        return hocPhanRepository.findByMonHoc_ChuyenNganh_MaChuyenNganh(maChuyenNganh);
    }

}
