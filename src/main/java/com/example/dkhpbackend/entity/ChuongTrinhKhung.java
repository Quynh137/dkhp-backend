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
@Table(name = "ChuongTrinhKhung")
public class ChuongTrinhKhung {
    @Id
    private String maMonHoc;
    private String hocKy;
    private String tenMonHoc;
    private String hocPhanTienQuyet;
    private int soTinChi;
    private int soTietLyThuyet;
    private int soTietThucHanh;
    private String dat;
    private boolean hocPhanBatBuoc;
    private boolean hocPhanTuChon;

    @ManyToOne
    @JoinColumn(name = "maChuyenNganh")
    private ChuyenNganh chuyenNganh;

    @ManyToOne
    @JoinColumn(name = "maHocPhan")
    private HocPhan hocPhan;
}
