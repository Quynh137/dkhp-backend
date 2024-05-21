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
@Table(name = "ChiTietHocPhan")
public class ChiTietHocPhan {
    @Id
    private String maChiTietHocPhan;
    private int thu;
    private int tiet;
    private int tuan;
    private int thang;
    private String nhomThucHanh;
    private String phongHoc;
    private String dayNha;
    private Date thoiGianBD;
    private Date thoiGianKT;

    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;

    @ManyToOne
    @JoinColumn(name = "maGiangVien")
    private GiangVien giangVien;

}
