package com.yagmur.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_yarisma")
@Entity
public class Yarisma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(TemporalType.DATE)
    LocalDate tarih;
    @ManyToMany(cascade = CascadeType.ALL ,mappedBy = "yarismalar")
    List<Yarismaci> yarismaciList;
    @OneToOne( cascade = CascadeType.ALL)
    List<Ipucu> ipucuList;

}