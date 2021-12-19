package com.bilgeadam.rehberprj.gui;

import com.bilgeadam.rehberprj.dao.KisiDAO;
import com.bilgeadam.rehberprj.dto.KisiDTO;
import com.bilgeadam.rehberprj.util.CevirmeIslemleri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class EkleForm extends JFrame{
    private JPanel jPanel1;
    private JTextField noTF;
    private JTextField adTF;
    private JTextField soyadTF;
    private JTextField maasTF;
    private JTextField dogtarTF;
    private JTextField mobiltelTF;
    private JButton button1;

    public EkleForm(){

        add(jPanel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Kişi EKle Ekranı");
        setSize(300,300);
        setLocationRelativeTo(null);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    KisiDTO kisi = new KisiDTO();

                    kisi.setNo(Integer.parseInt(noTF.getText()));
                    kisi.setAd(adTF.getText());
                    kisi.setSoyad(soyadTF.getText());
                    kisi.setMaas(Double.parseDouble(maasTF.getText()));
                    kisi.setDogtar(CevirmeIslemleri.strToUtilDate(dogtarTF.getText()));
                    kisi.setMobilTel(mobiltelTF.getText());

                    boolean sonuc = KisiDAO.ekle(kisi);

                    if (sonuc)
                    {
                        JOptionPane.showMessageDialog(null,"Kişi Başarıyla Eklendi" );
                        temizle();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Kişi Ekleme Başarısız" );
                    }


                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata" + ex.getMessage());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata" + throwables.getMessage());
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata" + classNotFoundException.getMessage());
                }
            }
        });
    }
    public void temizle(){
        noTF.setText("");
        adTF.setText("");
        soyadTF.setText("");
        maasTF.setText("");
        dogtarTF.setText("");
        mobilTelTF.setText("");
}
}

