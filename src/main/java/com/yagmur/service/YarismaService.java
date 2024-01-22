package com.yagmur.service;

import com.yagmur.controller.YarismaController;
import com.yagmur.entity.Unlu;
import com.yagmur.entity.Yarisma;
import com.yagmur.entity.Yarismaci;
import com.yagmur.repository.YarismaRepository;
import com.yagmur.repository.YarismaciRepository;

import java.util.List;
import java.util.Optional;

public class YarismaService {
    public static void yarismayiBaslat() {
        List<Yarismaci> yarismaciList = new YarismaciRepository().findAll();
        List<Unlu> unluList = UnluService.randomUnluGetir();

        for (Yarismaci yarismaci : yarismaciList) {
            System.out.println("Yarişmaci...: " + yarismaci.getAdSoyad());
            YarismaController.tahminEt(yarismaci, unluList);
            yarismaci.setSure(0L);
        }

        Yarismaci kazanan = yarismaciList.get(0);
        for (Yarismaci yarismaci : yarismaciList) {
            if (yarismaci.getSure() > kazanan.getSure()) {
                kazanan = yarismaci;
            }
        }

        System.out.println("Oyunun Kazananı....: " + kazanan.getAdSoyad());
    }
}
