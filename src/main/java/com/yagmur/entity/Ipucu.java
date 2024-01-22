package com.yagmur.entity;

import com.yagmur.entity.enums.Cinsiyet;
import com.yagmur.entity.enums.Uyruk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_ipucu")
@Entity
public class Ipucu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @JoinColumn(name = "unlu_id", referencedColumnName = "id")
    Unlu unlu;
    String sektor;
    @Enumerated
    Cinsiyet cinsiyet;
    int yas;
    @Enumerated
    Uyruk uyruk;
    String medeniHal;
}
