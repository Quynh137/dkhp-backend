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
@Table(name = "KetQua")
public class KetQua {
    @Id
    private int maKetQua;
    private float diem;
    private float diemk;
    private float diemTh1;
    private float diemTh2;
    private float diemtk1;
    private float diemtk2;
    private float diemtk3;
    private float diemGK;
    private float diemCK;
    private float diemTHCK;

    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;

    @ManyToOne
    @JoinColumn(name = "maSinhVien")
    private SinhVien sinhVien;

}
