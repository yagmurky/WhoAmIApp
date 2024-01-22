package com.yagmur.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_unluler")
@Entity
public class Unlu{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String adSoyad;
    String telefon;
    String medyaUrl;
    @OneToOne(mappedBy = "unlu", cascade = CascadeType.ALL)
    Ipucu ipucu;

}
