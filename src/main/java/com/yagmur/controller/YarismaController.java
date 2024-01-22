package com.yagmur.controller;

import com.yagmur.entity.Ipucu;
import com.yagmur.entity.Unlu;
import com.yagmur.entity.Yarisma;
import com.yagmur.entity.Yarismaci;
import com.yagmur.service.IpucuService;
import com.yagmur.service.YarismaService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class YarismaController {

    public static void tahminEt(Yarismaci yarismaci, List<Unlu> unluList){
        Scanner scanner=new Scanner(System.in);

        long baslangicZamani =0L;

        for (Unlu unlu: unluList) {
            System.out.println("************************************");
            System.out.println("************ WHO AM I **************");
            System.out.println("************************************");
            List<Ipucu> ipucuList = IpucuService.ipucuGetir(List.of(unlu));
            baslangicZamani= System.currentTimeMillis();
            boolean dogruTahmin=false;
            do {
                System.out.println("Ben kimim?.....");
                String tahmin=scanner.nextLine();
                Ipucu ipucu=ipucuList.get(0);

                if (unlu.getId().equals(ipucu.getUnlu().getId())){
                    if (tahmin.equalsIgnoreCase(unlu.getAdSoyad())){
                        System.out.println("Evet, benim!");
                        dogruTahmin=true;
                        break;
                    }else {
                        System.out.println("Beni bulamadın.");
                    }
                }
            }while (!dogruTahmin);
        }
        long bitisZamani = System.currentTimeMillis();
        int yarismaSuresi = (int) ((bitisZamani - baslangicZamani) / 1000);
        yarismaci.setSure((long)yarismaSuresi);

    }
}
