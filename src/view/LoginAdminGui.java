package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginAdminGui extends ComponentGui {

    LoginAdminGui() {
        initComponent();
    }
    String pathicon;
    void initComponent() {
        jendela.setSize(320, 480);
        jendela.setTitle("Perpustakaan App");
        jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jendela.setLocationRelativeTo(null);
        jendela.getContentPane().setBackground(new Color(0xf0e5d8));
        jendela.setLayout(null);
        jendela.setVisible(true);

        lblnama.setBounds(35, 250, 40, 25);
        jendela.add(lblnama);
        jendela.validate();
        flnama.setBounds(130, 250, 130, 25);
        jendela.add(flnama);

        lblpassword.setBounds(35, 290, 80, 25);
        jendela.add(lblpassword);
        flpass.setBounds(130, 290, 130, 25);
        jendela.add(flpass);

        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        jendela.add(btnlogin);

        btnloginanggota.setBounds(70,400,180,25);
        btnloginanggota.setBorder(null);
        btnloginanggota.setForeground(Color.black);
        btnloginanggota.setBackground(new Color(0xf0e5d8));
        jendela.add(btnloginanggota);

        bingkaigambar.setBounds(80,70,150,150);
        jendela.add(bingkaigambar);

        pathicon = "./src/image/admin.png";

        try {
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        gambarresize = bufferedImage.getScaledInstance(150, 150,Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));

        btnlogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = flnama.getText();
                String pass = flpass.getText();
                if(AllObjectController.adminController.login(username,pass)){
                    jendela.dispose();
                    AdminGui adminGuiNew = new AdminGui();
                }else {
                    JOptionPane.showMessageDialog(null,"GAGAL LOGIN");
                    kosong();
                }
            }
        });

        btnloginanggota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnloginanggota.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnloginanggota.setForeground(Color.black);
            }
        });

        btnloginanggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jendela.dispose();
                new LoginGui().setVisible(true);
            }
        });
    }
}
