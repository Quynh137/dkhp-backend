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
@Table(name = "DanhSachSinhVienLopHocPhan")
public class DanhSachSinhVienLopHocPhan {
    @Id
    private int maDanhSachSinhVienLopHocPhan;

    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;

    @ManyToOne
    @JoinColumn(name = "maSinhVien")
    private SinhVien sinhVien;
}
