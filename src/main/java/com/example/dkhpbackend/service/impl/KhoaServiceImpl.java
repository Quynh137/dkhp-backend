package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.Khoa;
import com.example.dkhpbackend.repository.KhoaRepository;
import com.example.dkhpbackend.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaServiceImpl implements KhoaService {
    @Autowired
    private KhoaRepository khoaRepository;

    @Override
    public List<Khoa> getAllKhoa() {
        return khoaRepository.findAll();
    }

    @Override
    public Optional<Khoa> getKhoaById(String maKhoa) {
        return khoaRepository.findById(maKhoa);
    }

    @Override
    public Khoa addKhoa(Khoa khoa) {
        return khoaRepository.save(khoa);
    }

    @Override
    public Khoa updateKhoa(String maKhoa, Khoa khoa) {
        Optional<Khoa> existingKhoa = khoaRepository.findById(maKhoa);
        if (existingKhoa.isPresent()) {
            Khoa updatedKhoa = existingKhoa.get();
            updatedKhoa.setTenKhoa(khoa.getTenKhoa());
            return khoaRepository.save(updatedKhoa);
        } else {
            throw new RuntimeException("Khoa not found with id: " + maKhoa);
        }
    }

    @Override
    public void deleteKhoa(String maKhoa) {
        Optional<Khoa> optionalKhoa = khoaRepository.findById(maKhoa);
        if (optionalKhoa.isPresent()) {
            khoaRepository.delete(optionalKhoa.get());
        } else {
            throw new RuntimeException("Khoa not found with maKhoa: " + maKhoa);
        }
    }
}
