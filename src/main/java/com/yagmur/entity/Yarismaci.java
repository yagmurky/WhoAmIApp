package com.yagmur.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_yarismaci")
@Entity
public class Yarismaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sure;
    int puan;
    @Column(name = "ad_soyad", nullable = false)
    String adSoyad;
    @Column(name = "telefon", nullable = false)
    String telefon;
    @ManyToOne
    Yarisma yarisma;

}

