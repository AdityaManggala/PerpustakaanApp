package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterAnggotaGui extends ComponentGui{

    public RegisterAnggotaGui(){
        initComponent();
    }

    void initComponent(){
        jendela.setTitle("Perpustakaan App");
        jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jendela.setSize(320,480);
        jendela.setLocationRelativeTo(null);
        jendela.getContentPane().setBackground(new Color(0xf0e5d8));
        jendela.setLayout(null);

        jendela.setVisible(true);

        lblregister.setBounds(120,50,70,25);
        jendela.add(lblregister);
        lblnama.setBounds(35,95,40,25);
        jendela.add(lblnama);
        flnama.setBounds(130,95,130,25);
        jendela.add(flnama);

        lblalamat.setBounds(35,140,80,25);
        jendela.add(lblalamat);
        flalamat.setBounds(130,140,130,25);
        jendela.add(flalamat);

        lblpassword.setBounds(35,185,80,25);
        jendela.add(lblpassword);
        flpass.setBounds(130,185,130,25);
        jendela.add(flpass);

        lblnotelp.setBounds(35,230,80,25);
        jendela.add(lblnotelp);
        flnotelp.setBounds(130,230,130,25);
        jendela.add(flnotelp);

        btnregister.setBounds(90,290,140,25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        jendela.add(btnregister);

        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(new Color(0xf0e5d8));
        btnlogin.setBorder(null);
        jendela.add(btnlogin);

        btnregister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });

        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = flnama.getText();
                String alamat = flalamat.getText();
                String password = flpass.getText();
                String notelp = flnotelp.getText();
                if(nama.length()!=0 && alamat.length()!=0 && password.length()!=0 && notelp.length()!=0){
                    AllObjectController.anggotaController.insertAnggota(nama,password,notelp,alamat);
                    JOptionPane.showMessageDialog(null,"Silahkan Log in kembali");
                    jendela.dispose();
                    new LoginGui().setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });

        btnlogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogin.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnlogin.setForeground(Color.black);
            }
        });

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jendela.dispose();
                LoginGui loginGui = new LoginGui();
                loginGui.setVisible(true);
            }
        });
    }
}
