package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminGui extends ComponentGui{

    JPanel panelatas = new JPanel();
    JPanel panelbawah = new JPanel();

    String text;
    Object[] message = {
            lblisbn,flisbn,
            lbljudulbuku,fljudulbuku,
            lblpenerbit,flpenerbit,
            lblterbit,flterbit,
            lblhalaman,flhalaman
    };

    AdminGui(){
        initComponent();
    }

    void initComponent(){
        jendela.setSize(800, 600);
        jendela.setTitle("Perpustakaan App");
        jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jendela.setLocationRelativeTo(null);
        jendela.setLayout(new BorderLayout());
        jendela.add(adminpanel,BorderLayout.CENTER);
        jendela.add(btnlogout,BorderLayout.PAGE_END);

        adminpanel.setLayout(new GridLayout(2,1));
        adminpanel.add(panelatas);
        panelatas.setLayout(new GridLayout(1,2));
        adminpanel.add(panelbawah);
        panelbawah.setLayout(new BorderLayout());

        btnlogout.setFocusPainted(false);
        btnlogout.setBorderPainted(false);
        btnlogout.setBackground(new Color(0xdc3545));
        btnlogout.setForeground(Color.white);
        jendela.setVisible(true);

        daftaranggota.setBorder(ttldaftaranggota);
        daftaranggota.setLayout(new BorderLayout());
        daftaranggota.add(spanggota,BorderLayout.CENTER);
        daftaranggota.add(btngroupanggota,BorderLayout.PAGE_END);
        btngroupanggota.setLayout(new GridLayout(1,2));

        btnresetpass.setFocusPainted(false);
        btnresetpass.setBorderPainted(false);
        btnresetpass.setBackground(new Color(0xffc107));
        btnresetpass.setForeground(Color.black);
        btngroupanggota.add(btnresetpass);

        btnhapusanggota.setFocusPainted(false);
        btnhapusanggota.setBorderPainted(false);
        btnhapusanggota.setBackground(new Color(0xdc3545));
        btnhapusanggota.setForeground(Color.white);
        btngroupanggota.add(btnhapusanggota);
        panelatas.add(daftaranggota);

        daftarbuku.setBorder(ttldaftarbuku);
        daftarbuku.setLayout(new BorderLayout());
        daftarbuku.add(spbuku,BorderLayout.CENTER);
        daftarbuku.add(btngroupbuku,BorderLayout.PAGE_END);
        btngroupbuku.setLayout(new GridLayout(1,3));
        btntambahbuku.setBackground(new Color(0x28a745));
        btntambahbuku.setForeground(Color.white);
        btntambahbuku.setFocusPainted(false);
        btntambahbuku.setBorderPainted(false);
        btngroupbuku.add(btntambahbuku);
        btnubahbuku.setBackground(new Color(0xffc107));
        btnubahbuku.setFocusPainted(false);
        btnubahbuku.setBorderPainted(false);
        btngroupbuku.add(btnubahbuku);
        btnhapusbuku.setBackground(new Color(0xdc3545));
        btnhapusbuku.setForeground(Color.white);
        btnhapusbuku.setFocusPainted(false);
        btnhapusbuku.setBorderPainted(false);
        btngroupbuku.add(btnhapusbuku);
        panelatas.add(daftarbuku);

        daftarpinjaman.setBorder(ttldaftarpinjaman);
        daftarpinjaman.setLayout(new BorderLayout());
        daftarpinjaman.add(sppeminjaman,BorderLayout.CENTER);
        btnverif.setBackground(new Color(0x007bff));
        btnverif.setForeground(Color.white);
        btnverif.setFocusPainted(false);
        btnverif.setBorderPainted(false);
        daftarpinjaman.add(btnverif,BorderLayout.PAGE_END);
        panelbawah.add(daftarpinjaman);

        tblanggota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = tblanggota.getSelectedRow();
                text = dataTableAnggota().getValueAt(baris,1).toString();
            }
        });

        btnhapusanggota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnhapusanggota.setBackground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnhapusanggota.setBackground(new Color(0xdc3545));
                btnhapusanggota.setForeground(Color.white);
            }
        });

        btnhapusanggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllObjectController.adminController.deleteAnggota(Integer.parseInt(text));
                tblanggota.setModel(dataTableAnggota());
            }
        });

        btnresetpass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnresetpass.setBackground(Color.black);
                btnresetpass.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnresetpass.setBackground(new Color(0xffc107));
                btnresetpass.setForeground(Color.BLACK);
            }
        });

        btnresetpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllObjectController.adminController.resetPassAnggota(Integer.parseInt(text));
                tblanggota.setModel(dataTableAnggota());
            }
        });

        tblbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = tblbuku.getSelectedRow();
                text = dataTableBuku().getValueAt(baris,1).toString();
            }
        });

        tblpeminjaman.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = tblpeminjaman.getSelectedRow();
                text = dataTablePeminjaman().getValueAt(baris,1).toString();
            }
        });

        btnubahbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnubahbuku.setBackground(Color.black);
                btnubahbuku.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnubahbuku.setBackground(new Color(0xffc107));
                btnubahbuku.setForeground(Color.BLACK);
            }
        });

        btnubahbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opsi = {"Judul","Penerbit"};
                int dialog = JOptionPane.showOptionDialog(null,"Pilihan Ubah","Ubah Informasi Buku",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opsi,opsi[0]);
                if(dialog == 0){
                    String input = JOptionPane.showInputDialog("Input Judul");
                    try {
                        if (input.length()!=0) {
                            AllObjectController.bukuController.updateBuku(1, text, input);
                        }else {
                            JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong");
                        }
                    }catch (NullPointerException exception){
                        JOptionPane.showMessageDialog(null,"Kembali");
                    }
                }else if(dialog == 1){
                    String input = JOptionPane.showInputDialog("Input Penerbit");
                    try{
                        if (input.length()!=0) {
                            AllObjectController.bukuController.updateBuku(2,text,input);
                        }else {
                            JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong");
                        }
                    }catch (NullPointerException exception){
                        JOptionPane.showMessageDialog(null,"Kembali");
                    }
                }
                tblbuku.setModel(dataTableBuku());
            }
        });

        btntambahbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btntambahbuku.setBackground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btntambahbuku.setBackground(new Color(0x28a745));
                btntambahbuku.setForeground(Color.white);
            }
        });

        btntambahbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, message, "Insert Buku", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String isbn = flisbn.getText();
                    String judul = fljudulbuku.getText();
                    String penerbit = flpenerbit.getText();
                    String terbit = flterbit.getText();
                    String halaman = flhalaman.getText();
                    if(isbn.length()!=0 && judul.length()!=0 && penerbit.length()!=0 && terbit.length()!=0 && halaman.length()!=0){
                        AllObjectController.bukuController.InsertBuku(isbn,judul,penerbit,Integer.parseInt(terbit),Integer.parseInt(halaman));
                        kosong();
                        tblbuku.setModel(dataTableBuku());
                    }else {
                        JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong");
                        kosong();
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Kembali");
                }
            }
        });

        btnhapusbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnhapusbuku.setBackground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnhapusbuku.setBackground(new Color(0xdc3545));
                btnhapusbuku.setForeground(Color.white);
            }
        });

        btnhapusbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllObjectController.bukuController.deleteBuku(text);
                tblbuku.setModel(dataTableBuku());
            }
        });

        btnverif.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnverif.setBackground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnverif.setBackground(new Color(0x007bff));
                btnverif.setForeground(Color.white);
            }
        });

        btnverif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllObjectController.peminjamanController.verifPengembalian(text);
                tblpeminjaman.setModel(dataTablePeminjaman());
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
                LoginAdminGui loginAdminGui = new LoginAdminGui();
                loginAdminGui.setVisible(true);
            }
        });
    }
}
