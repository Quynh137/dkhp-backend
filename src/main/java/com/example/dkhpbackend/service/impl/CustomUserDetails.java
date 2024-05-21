package com.example.dkhpbackend.service.impl;

import com.example.dkhpbackend.entity.NhanVien;
import com.example.dkhpbackend.entity.GiangVien;
import com.example.dkhpbackend.entity.SinhVien;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(NhanVien nhanVien) {
        this.username = nhanVien.getMaNhanVien();
        this.password = nhanVien.getPasswordnv();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_NHANVIEN"));
    }

    public CustomUserDetails(GiangVien giangVien) {
        this.username = giangVien.getMaGiangVien();
        this.password = giangVien.getPasswordgv();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_GIANGVIEN"));
    }

    public CustomUserDetails(SinhVien sinhVien) {
        this.username = sinhVien.getMaSinhVien();
        this.password = sinhVien.getPasswordsv();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_SINHVIEN"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}