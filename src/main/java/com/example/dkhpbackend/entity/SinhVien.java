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
@Table(name = "SinhVien")
public class SinhVien {
    @Id
    private String maSinhVien;
    private String hoTen;
    private String gmail;
    private String passwordsv;
    private String hoKhauThuongTru;
    private String maKhuVuc;
    private String soCCCD;
    private String soDienThoai;
    private Date ngaySinh;
    private String diaChi;
    private String gioiTinh;
    private String bacDaoTao;
    private String lopHoc;
    private String loaiHinhDaoTao;

    @ManyToOne
    @JoinColumn(name = "maChuyenNganh")
    private ChuyenNganh chuyenNganh;

    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;

    @ManyToOne
    @JoinColumn(name = "maTrangThai")
    private TrangThaiHocTap trangThaiHocTap;

    @ManyToOne
    @JoinColumn(name = "maTonGiao")
    private TonGiao tonGiao;

    @ManyToOne
    @JoinColumn(name = "maDanToc")
    private DanToc danToc;
}
