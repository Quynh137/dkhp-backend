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
@Table(name = "HocPhan")
public class HocPhan {
    @Id
    private String maHocPhan;
    private String tenHocPhan;
    private int soTinChi;

    @ManyToOne
    @JoinColumn(name = "maHocPhanTienQuyet")
    private HocPhan hocPhanTienQuyet;

    @ManyToOne
    @JoinColumn(name = "maHocKy")
    private HocKy hocKy;

    @ManyToOne
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "maChuyenNganh")
    private ChuyenNganh chuyenNganh;


}
