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
@Table(name = "ChuyenNganh")
public class ChuyenNganh {
    @Id
    private String maChuyenNganh;
    private String tenChuyenNganh;

    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;

}
