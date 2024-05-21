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
@Table(name = "GiangVien")
public class GiangVien {
    @Id
    private String maGiangVien;
    private String passwordgv;
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;


}
