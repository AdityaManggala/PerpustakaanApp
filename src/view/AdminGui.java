package view;

import javax.swing.*;
import java.awt.*;

public class AdminGui extends JComponent {

    JFrame frame = new JFrame();
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton btndelete = new JButton("Hapus");
    JButton btnverif = new JButton("Terima Pengembalian");
    JButton btnlogout = new JButton("LOG OUT");
    JTable tblanggota = new JTable();
    JScrollPane spanggota = new JScrollPane(tblanggota);
    JTable tblpinjaman = new JTable();
    JScrollPane sppinjaman = new JScrollPane(tblpinjaman);

    AdminGui(){
        initComponent();
    }

    void initComponent(){
        frame.setSize(800, 600);
        frame.setTitle("Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        frame.add(btnlogout,BorderLayout.LINE_END);

        panel1.setLayout(null);
        spanggota.setBounds(0,0,500,200);
        btndelete.setBounds(400,210,100,20);
        panel1.add(spanggota,BorderLayout.CENTER);
        panel1.add(btndelete,BorderLayout.SOUTH);

        panel2.setLayout(new BorderLayout());
        panel2.add(sppinjaman,BorderLayout.CENTER);
        panel2.add(btnverif,BorderLayout.SOUTH);

        tabbedPane.addTab("Anggota",panel1);
        tabbedPane.addTab("Peminjaman",panel2);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(tabbedPane);
    }


    public static void main(String[] args) {
        AdminGui adminGui = new AdminGui();
    }
}
