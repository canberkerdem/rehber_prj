package com.bilgeadam.rehberprj.test;

import com.bilgeadam.rehberprj.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.dto.KullaniciDTO;

public class KullaniciDAOTest {
    public static void main(String[] args) {
        try {
            KullaniciDTO kullanici = new KullaniciDTO();
            kullanici.setKullaniciAdi("admin");
            kullanici.setSifre("admin1234");

            boolean sonuc = KullaniciDAO.giriseYetkilimi(kullanici);
            if (sonuc)
                System.out.println("Girişe Yetkilidir.");
            else
                System.out.println("Girişe Yetkili Değildir.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
