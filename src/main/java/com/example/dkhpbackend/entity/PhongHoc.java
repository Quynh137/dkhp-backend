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
@Table(name = "PhongHoc")
public class PhongHoc {
    @Id
    private String maPhongHoc;
    private String tenPhongHoc;

    @ManyToOne
    @JoinColumn(name = "maLoaiPhong")
    private LoaiPhongHoc loaiPhongHoc;
}
