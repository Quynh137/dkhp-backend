package com.example.dkhpbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LopHocPhan")
public class LopHocPhan {
    @Id
    private String maLopHocPhan;
    private String tenLopHocPhan;
    private String lopDuKien;
    private int siSoToiDa;
    private int daDangKy;
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "maHocPhan")
    private HocPhan hocPhan;

    @ManyToOne
    @JoinColumn(name = "maHocKy")
    private HocKy hocKy;

    @ManyToOne
    @JoinColumn(name = "maGiangVien")
    private GiangVien giangVien;
}
