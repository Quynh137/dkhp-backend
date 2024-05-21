package com.example.dkhpbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "KhoaHoc")
public class KhoaHoc {
    @Id
    private String maKhoaHoc;
    private String tenKhoaHoc;
    private String moTa;
    private Date thoiGianBD;

}
