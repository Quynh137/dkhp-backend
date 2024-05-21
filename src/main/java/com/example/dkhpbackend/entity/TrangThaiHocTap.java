package com.example.dkhpbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TrangThaiHocTap")
public class TrangThaiHocTap {
    @Id
    private String maTrangThai;
    private String moTa;
    private String tenTrangThai;
}
