package com.example.dkhpbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LopHocPhanDaDangKy")
public class LopHocPhanDaDangKy {
    @Id
    private int maDangKy;
    private String lopHocDuKien;
    private int soTinChi;
    private double hocPhi;
    private Date hanNop;
    private String thu;
    private String trangThaiDangKy;
    private Date ngayDangKy;
    private String trangThaiLHP;

    @ManyToOne
    @JoinColumn(name = "maSinhVien")
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;
}
