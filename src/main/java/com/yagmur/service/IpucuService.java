package com.yagmur.service;

import com.yagmur.entity.Ipucu;
import com.yagmur.entity.Unlu;
import com.yagmur.repository.IpucuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IpucuService {
    public static List<Ipucu> ipucuGetir(List<Unlu> unluList){
        List<Ipucu>  ipucuList = new IpucuRepository() .findAll();
        List<Ipucu> ipucuListesi=new ArrayList<>();

        for (Unlu unlu : unluList) {
            Ipucu ipucu = ipucuList.stream().filter(x -> x.getUnlu().getId().equals(unlu.getId())).findFirst().orElse(null);
            if (ipucu != null) {
                System.out.println("********** İPUÇLARI *********");
                System.out.println("Cinsiyet" +ipucu.getCinsiyet());
                System.out.println("Yas" +ipucu.getYas());
                System.out.println("Uyruk" +ipucu.getUyruk());
                System.out.println("Medeni Hali" +ipucu.getMedeniHal());
                System.out.println("Meslek" +ipucu.getSektor());
                System.out.println("*****************************");
                ipucuListesi.add(ipucu);
            }

        }
        return ipucuListesi;
    }
}
