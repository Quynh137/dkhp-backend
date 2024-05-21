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
@Table(name = "LoaiPhongHoc")
public class LoaiPhongHoc {
    @Id
    private String maLoaiPhong;
    private String tenLoaiPhong;
}
