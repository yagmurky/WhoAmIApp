package com.yagmur;

import com.yagmur.entity.Ipucu;
import com.yagmur.entity.Unlu;
import com.yagmur.entity.Yarisma;
import com.yagmur.entity.Yarismaci;
import com.yagmur.entity.enums.Cinsiyet;
import com.yagmur.entity.enums.Uyruk;
import com.yagmur.repository.IpucuRepository;
import com.yagmur.repository.UnluRepository;
import com.yagmur.repository.YarismaRepository;
import com.yagmur.repository.YarismaciRepository;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        veriEkle();

    }

    private static void veriEkle() {
        YarismaRepository yarismaRepository = new YarismaRepository();
        YarismaciRepository yarismaciRepository = new YarismaciRepository();
        UnluRepository unluRepository = new UnluRepository();
        IpucuRepository ipucuRepository = new IpucuRepository();

        Yarismaci yagmurKiraz = Yarismaci.builder()
                .adSoyad("Yagmur Kiraz")
                .telefon("123456")
                .build();
        yarismaciRepository.save(yagmurKiraz);

        Yarismaci damlaKiraz = Yarismaci.builder()
                .adSoyad("Damla Kiraz")
                .telefon("123456")
                .build();
        yarismaciRepository.save(damlaKiraz);

        Yarismaci atillaKiraz = Yarismaci.builder()
                .adSoyad("Atilla Kiraz")
                .telefon("123456")
                .build();
        yarismaciRepository.save(atillaKiraz);

        Unlu unlu1 = Unlu.builder()
                .adSoyad("Freddie Mercury")
                .medyaUrl("https://freddie-mercury.com/")
                .telefon("9191991")
                .build();
        unluRepository.save(unlu1);

        Unlu unlu2 = Unlu.builder()
                .adSoyad("Michael Jackson")
                .medyaUrl("https://michaeljackson.com/")
                .telefon("9191992")
                .build();
        unluRepository.save(unlu2);

        Unlu unlu3 = Unlu.builder()
                .adSoyad("Beyoncé")
                .medyaUrl("https://beyonce.com/")
                .telefon("9191993")
                .build();
        unluRepository.save(unlu3);

        Unlu unlu4 = Unlu.builder()
                .adSoyad("Elvis Presley")
                .medyaUrl("https://elvispresley.com/")
                .telefon("9191994")
                .build();
        unluRepository.save(unlu4);

        Unlu unlu5 = Unlu.builder()
                .adSoyad("Madonna")
                .medyaUrl("https://madonna.com/")
                .telefon("9191995")
                .build();
        unluRepository.save(unlu5);

        Ipucu ipucu1 = Ipucu.builder()
                .cinsiyet(Cinsiyet.ERKEK)
                .yas(45)
                .uyruk(Uyruk.INGILIZ)
                .medeniHal("Bekar")
                .unlu(unlu1)
                .build();
        ipucuRepository.save(ipucu1);

        Ipucu ipucu2 = Ipucu.builder()
                .cinsiyet(Cinsiyet.ERKEK)
                .yas(45)
                .uyruk(Uyruk.INGILIZ)
                .medeniHal("Bekar")
                .unlu(unlu2)
                .build();
        ipucuRepository.save(ipucu2);

        Ipucu ipucu3 = Ipucu.builder()
                .cinsiyet(Cinsiyet.KADIN)
                .yas(35)
                .uyruk(Uyruk.ISPANYOL)
                .medeniHal("Bekar")
                .unlu(unlu3)
                .build();
        ipucuRepository.save(ipucu3);

        Ipucu ipucu4 = Ipucu.builder()
                .cinsiyet(Cinsiyet.ERKEK)
                .yas(45)
                .uyruk(Uyruk.INGILIZ)
                .medeniHal("Bekar")
                .unlu(unlu4)
                .build();
        ipucuRepository.save(ipucu4);

        Ipucu ipucu5 = Ipucu.builder()
                .cinsiyet(Cinsiyet.KADIN)
                .yas(50)
                .uyruk(Uyruk.INGILIZ)
                .medeniHal("Bekar")
                .unlu(unlu5)
                .build();
        ipucuRepository.save(ipucu5);

        unlu1.setIpucu(ipucu1);
        unlu2.setIpucu(ipucu2);
        unlu3.setIpucu(ipucu3);
        unlu4.setIpucu(ipucu4);
        unlu5.setIpucu(ipucu5);

        Yarisma yarisma = Yarisma.builder()
                .ipucuList(new ArrayList<>())
                .yarismaciList(new ArrayList<>())
                .build();

        yarisma.setIpucuList(List.of(ipucu1, ipucu2, ipucu3, ipucu4, ipucu5));
        yarisma.setYarismaciList(List.of(yagmurKiraz, damlaKiraz, atillaKiraz));
        yarismaRepository.save(yarisma);
    }


}
