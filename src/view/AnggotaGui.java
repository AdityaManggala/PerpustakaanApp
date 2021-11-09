package view;

import entity.AnggotaEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnggotaGui extends ComponentGui{

    String text;
    AnggotaGui(int cek){
        initComponent(cek);
    }

    void initComponent(int cek){

//        for (AnggotaEntity anggota : AllObjectController.anggotaController.showDataAnggotaById(cek)) {
//            this.id =  anggota.getId();
//            this.nama = anggota.getNama();
//            this.password = anggota.getPassword();
//            this.noTelp = anggota.getNoTelp();
//            this.alamat = anggota.getAlamat();
//        }

        jendela.setSize(800, 600);
        jendela.setTitle("Perpustakaan App");
        jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jendela.setLocationRelativeTo(null);
        jendela.getContentPane().setBackground(new Color(0xf0e5d8));
        jendela.setLayout(new BorderLayout());
        jendela.setVisible(true);
        jendela.add(tab,BorderLayout.CENTER);
        btnlogout.setBackground(new Color(0xdc3545));
        btnlogout.setForeground(Color.white);
        btnlogout.setFocusPainted(false);
        btnlogout.setBorderPainted(false);
        jendela.add(btnlogout,BorderLayout.PAGE_END);

        datadiripanel.setBackground(new Color(0xf0e5d8));
        datadiripanel.setBorder(ttlakunsetting);
        datadiripanel.setLayout(null);
        lblnama.setBounds(35,20,80,25);
        flnama.setBounds(130,20,130,25);
        flnama.setText(AllObjectController.anggotaController.getData(cek).getNama());
        datadiripanel.add(lblnama);
        datadiripanel.add(flnama);

        lblpassword.setBounds(35,65,80,25);
        flpass.setBounds(130,65,130,25);
        flpass.setText(AllObjectController.anggotaController.getData(cek).getPassword());
        datadiripanel.add(lblpassword);
        datadiripanel.add(flpass);

        lblalamat.setBounds(35,110,80,25);
        flalamat.setBounds(130,110,130,25);
        flalamat.setText(AllObjectController.anggotaController.getData(cek).getAlamat());
        datadiripanel.add(flalamat);
        datadiripanel.add(lblalamat);

        lblnotelp.setBounds(35,155,80,25);
        flnotelp.setBounds(130,155,130,25);
        flnotelp.setText(AllObjectController.anggotaController.getData(cek).getNoTelp());
        datadiripanel.add(lblnotelp);
        datadiripanel.add(flnotelp);

        btnubahakun.setBounds(300,85,130,25);
        btnubahakun.setBackground(new Color(0xffc107));
        btnubahakun.setFocusPainted(false);
        btnubahakun.setBorderPainted(false);
        datadiripanel.add(btnubahakun);

        JTable tblriwayat = new JTable(dataTablePeminjamanByUser(AllObjectController.anggotaController.getData(cek).getId()));
        JScrollPane spriwayat = new JScrollPane(tblriwayat);
        peminjamanbukupanel.setLayout(new GridLayout(2,1));
        peminjamanbukupanel.add(pinjampanel,0);
        peminjamanbukupanel.add(riwayatpinjampanel,1);

        pinjampanel.setBorder(ttlpinjam);
        pinjampanel.setLayout(new BorderLayout());
        pinjampanel.add(spbuku,BorderLayout.CENTER);
        btnpinjam.setBackground(new Color(0x28a745));
        btnpinjam.setForeground(Color.white);
        btnpinjam.setFocusPainted(false);
        btnpinjam.setBorderPainted(false);
        pinjampanel.add(btnpinjam,BorderLayout.PAGE_END);
        pinjampanel.setBackground(new Color(0xf0e5d8));

        riwayatpinjampanel.setBorder(ttlriwayatpinjam);
        riwayatpinjampanel.setLayout(new BorderLayout());
        tblriwayat.setModel(dataTablePeminjamanByUser(cek));
        riwayatpinjampanel.add(spriwayat,BorderLayout.CENTER);
        riwayatpinjampanel.setBackground(new Color(0xf0e5d8));

        tab.addTab("Akun",datadiripanel);
        tab.addTab("Peminjaman",peminjamanbukupanel);

        btnubahakun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnubahakun.setBackground(Color.black);
                btnubahakun.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnubahakun.setBackground(new Color(0xffc107));
                btnubahakun.setForeground(Color.black);
            }
        });

        btnubahakun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opsi = {"Ubah Password","Ubah Alamat","Ubah Nomor"};
                int option = JOptionPane.showOptionDialog(null,"Pilih informasi yang ingin di ubah","Ubah Akun",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opsi,opsi[0]);
                if(option==0){
                    String input = JOptionPane.showInputDialog("input password");
                    try {
                        if(input.length()!=0){
                            AllObjectController.anggotaController.updateAkun(1,input,cek);
                            flpass.setText(input);
                        }else {
                            JOptionPane.showMessageDialog(null,"Inputan Kosong");
                        }
                    }catch (NullPointerException e1){
                        JOptionPane.showMessageDialog(null,"Kembali");
                    }
                }
                else if(option==1){
                    String input = JOptionPane.showInputDialog("input Alamat");
                    try {
                        if(input.length()!=0){
                            AllObjectController.anggotaController.updateAkun(2,input,cek);
                            flalamat.setText(input);
                        }else {
                            JOptionPane.showMessageDialog(null,"Inputan Kosong");
                        }
                    }catch (NullPointerException e2){
                        JOptionPane.showMessageDialog(null,"Kembali");
                    }
                }else if(option==2){
                    String input = JOptionPane.showInputDialog("input Nomor Telpon");
                    try {
                        if(input.length()!=0){
                            AllObjectController.anggotaController.updateAkun(3,input,cek);
                            flnotelp.setText(input);
                        }else {
                            JOptionPane.showMessageDialog(null,"Inputan Kosong");
                        }
                    }catch (NullPointerException e3){
                        JOptionPane.showMessageDialog(null,"Kembali");
                    }
                }
            }
        });

        tblbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = tblbuku.getSelectedRow();
                text = dataTableBuku().getValueAt(baris,1).toString();
            }
        });

        btnpinjam.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnpinjam.setBackground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnpinjam.setBackground(new Color(0x28a745));
                btnpinjam.setForeground(Color.white);
            }
        });

        btnpinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllObjectController.peminjamanController.insertPeminjaman(AllObjectController.bukuController.getData(text),AllObjectController.anggotaController.getData(cek));
                tblriwayat.setModel(dataTablePeminjamanByUser(cek));
            }
        });

        btnlogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogout.setBackground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnlogout.setBackground(new Color(0xdc3545));
                btnlogout.setForeground(Color.white);
            }
        });

        btnlogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jendela.dispose();
                LoginGui loginGui = new LoginGui();
            }
        });

    }

}
