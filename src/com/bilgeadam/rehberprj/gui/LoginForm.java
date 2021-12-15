package com.bilgeadam.rehberprj.gui;

import com.bilgeadam.rehberprj.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.dto.KullaniciDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    private JTextField adTF;
    private JPasswordField sifrePF;
    private JButton girisButton;
    private JPanel JPanel;
    private JPanel jpanel1;

    public LoginForm()
    {
        add(jpanel1);

        //Formun çarpısına basınca programdan çıksın
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(300,200);

        //Ekrana göre ortala
        //mutlaka setsize den sonra çağrılmalı
        setLocationRelativeTo(null);

        setTitle("Giriş Ekranı");


        girisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"Butona basıldı");

                if (adTF.getText().length() == 0){
                    JOptionPane.showMessageDialog(null,"Ad alanı boş geçilemez");
                //Eğer ad yazılmazsa Aşağıdaki kodları çalıştırmasın diye return yazdık
                return;
                }
                if (String.valueOf(sifrePF.getPassword()).length() == 0){
                    JOptionPane.showMessageDialog(null,"Şifre alanı boş geçilemez");
                //Eğer şifre yazılmazsa Aşağıdaki kodları çalıştırmasın diye return yazdık
                return;
                }
                try {
                    KullaniciDTO kullanici = new KullaniciDTO();
                    kullanici.setKullaniciAdi(adTF.getText());
                    kullanici.setSifre(String.valueOf(sifrePF.getPassword()));

                    boolean sonuc =KullaniciDAO.giriseYetkilimi(kullanici);

                    if(sonuc)
                        JOptionPane.showMessageDialog(null,"Girişe Yetkilidir");
                    else
                        JOptionPane.showMessageDialog(null,"Girişe Yetkili Değildir");

                }

                catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:"+ ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:"+ ex.getMessage());
                }

            }
        });
    }

}
