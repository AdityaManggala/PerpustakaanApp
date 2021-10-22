package view;

import javax.swing.*;
import java.awt.*;

public class AnggotaGui extends ComponentGui{
    AnggotaGui(){
        initComponent();
    }

    void initComponent(){
        jendela.setSize(800, 600);
        jendela.setTitle("Login");
        jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jendela.setLocationRelativeTo(null);
        jendela.setLayout(new BorderLayout());
        jendela.setVisible(true);
        jendela.add(judul,BorderLayout.NORTH);
        jendela.add(menu,BorderLayout.WEST);
        jendela.add(isi,BorderLayout.CENTER);

        judul.add(new JLabel("Perpustakaan App"));
        judul.setLayout(new FlowLayout());

        menu.setLayout(new GridLayout(10,1));
        menu.add(btnpeminjaman);
        menu.add(btnaccount);
        menu.add(btnlogout);

        isi.setLayout(new BorderLayout());
        isi.add(spbuku,BorderLayout.CENTER);

        isi.add(sppeminjaman,BorderLayout.SOUTH);


    }



    public static void main(String[] args) {
        AnggotaGui anggotaGui = new AnggotaGui();
    }
}
