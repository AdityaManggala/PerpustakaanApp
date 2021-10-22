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

public class LoginGui extends ComponentGui {

    LoginGui() {
        initComponent();
    }
    String pathicon;
    void initComponent() {
        jendela.setSize(320, 480);
        jendela.setTitle("Login");
        jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jendela.setLocationRelativeTo(null);
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

        btnregister.setBounds(70, 400, 180, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.white);
        jendela.add(btnregister);

        bingkaigambar.setBounds(-10,30,320,229);
        jendela.add(bingkaigambar);

        pathicon = "./src/image/books.png";

        try {
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        gambarresize = bufferedImage.getScaledInstance(320, 229,Image.SCALE_DEFAULT);
        bingkaigambar.setIcon(new ImageIcon(bufferedImage));

        btnregister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnregister.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnregister.setForeground(Color.black);
            }
        });
        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                new RegisterGui().setVisible(true);
            }
        });

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
    }

    public static void main(String[] args) {
        LoginGui gui = new LoginGui();
    }
}
