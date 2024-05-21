package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.NhanVien;
import com.example.dkhpbackend.entity.GiangVien;
import com.example.dkhpbackend.entity.SinhVien;
import com.example.dkhpbackend.repository.NhanVienRepository;
import com.example.dkhpbackend.repository.GiangVienRepository;
import com.example.dkhpbackend.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NhanVien nhanVien = nhanVienRepository.findById(username).orElse(null);
        if (nhanVien != null) {
            return new CustomUserDetails(nhanVien);
        }

        GiangVien giangVien = giangVienRepository.findById(username).orElse(null);
        if (giangVien != null) {
            return new CustomUserDetails(giangVien);
        }

        SinhVien sinhVien = sinhVienRepository.findById(username).orElse(null);
        if (sinhVien != null) {
            return new CustomUserDetails(sinhVien);
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}