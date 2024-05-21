package com.example.dkhpbackend.service;

import com.example.dkhpbackend.entity.Khoa;

import java.util.List;
import java.util.Optional;

public interface KhoaService {
    public List<Khoa> getAllKhoa();

    Optional<Khoa> getKhoaById(String maKhoa);

    Khoa addKhoa(Khoa khoa);

    Khoa updateKhoa(String maKhoa, Khoa khoa);

    void deleteKhoa(String maKhoa);
}
