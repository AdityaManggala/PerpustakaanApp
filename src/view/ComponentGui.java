package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentGui extends JComponent{
    protected JFrame jendela = new JFrame();
    protected JButton btnlogin = new JButton("login");
    protected JButton btnregister = new JButton("test");
    protected JLabel lblnama = new JLabel("Nama");
    protected JLabel lblpassword = new JLabel("Password");
    protected JLabel bingkaigambar = new JLabel();
    protected JButton btnanggota = new JButton("Anggota");
    protected JButton btnbuku = new JButton("Buku");
    protected JButton btnpeminjaman = new JButton("Peminjaman");
    protected JButton btnverif = new JButton("Verif Pengembalian");
    protected JButton btnpinjam = new JButton("Pinjam");
    protected JButton btnaccount = new JButton("Akun");
    protected JButton btnlogout = new JButton("Log Out");
    protected JTextField flnama = new JTextField();
    protected JPasswordField flpass = new JPasswordField();

    protected JPanel judul = new JPanel();
    protected JPanel menu = new JPanel();
    protected JPanel isi = new JPanel();
    protected JPanel isi2 = new JPanel();


    protected JTable tblanggota = new JTable();
    protected JTable tblbuku = new JTable();
    protected JTable tblpeminjaman = new JTable();

    protected JScrollPane spanggota = new JScrollPane(tblanggota);
    protected JScrollPane spbuku = new JScrollPane(tblbuku);
    protected JScrollPane sppeminjaman = new JScrollPane(tblpeminjaman);

    BufferedImage bufferedImage = null;
    Image gambarresize;

//    void kosong(){
//        fieldnama.setText(null);
//        fieldnpm.setText(null);
//        fieldpassword.setText(null);
//        fieldnotelp.setText(null);
//    }

    protected DefaultTableModel dataTableBuku(){
        DefaultTableModel dataBuku = new DefaultTableModel();
        Object[] kolom = {"ISBN","JUDUL","PENERBIT","TERBIT","HALAMAN"};
        dataBuku.setColumnIdentifiers(kolom);
        int size = AllObjectController.bukuController.showAllData().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[5];
            data[0] = AllObjectController.bukuController.showAllData().get(i).getIsbn();
            data[1] = AllObjectController.bukuController.showAllData().get(i).getJudul();
            data[2] = AllObjectController.bukuController.showAllData().get(i).getPenerbit();
            data[3] = AllObjectController.bukuController.showAllData().get(i).getTerbit();
            data[4] = AllObjectController.bukuController.showAllData().get(i).getHalaman();
            dataBuku.addRow(data);
        }
        return dataBuku;
    }

    protected DefaultTableModel dataTableAnggota(){
        DefaultTableModel dataAnggota = new DefaultTableModel();
        Object[] kolom = {"NO","ID","NAMA","PASSWORD","NOMOR","ALAMAT"};
        dataAnggota.setColumnIdentifiers(kolom);
        int size = AllObjectController.anggotaController.showAllData().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[6];
            data[0] = i+1;
            data[1] = AllObjectController.anggotaController.showAllData().get(i).getId();
            data[2] = AllObjectController.anggotaController.showAllData().get(i).getNama();
            data[3] = AllObjectController.anggotaController.showAllData().get(i).getPassword();
            data[4] = AllObjectController.anggotaController.showAllData().get(i).getNoTelp();
            data[5] = AllObjectController.anggotaController.showAllData().get(i).getAlamat();
            dataAnggota.addRow(data);
        }
        return dataAnggota;
    }

    protected DefaultTableModel dataTablePeminjaman(){
        DefaultTableModel dataPeminjaman = new DefaultTableModel();
        Object[] kolom = {"NO","ID","ISBN","JUDUL","PEMINJAM","TGL PINJAM","TGL KEMBALI","STATUS KEMBALI"};
        dataPeminjaman.setColumnIdentifiers(kolom);
        int size = AllObjectController.peminjamanController.showAllData().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[7];
            data[0] = i+1;
            data[1] = AllObjectController.peminjamanController.showAllData().get(i).getIdPeminjaman();
            data[2] = AllObjectController.peminjamanController.showAllData().get(i).getIsbnBuku();
            data[3] = AllObjectController.peminjamanController.showAllData().get(i).getJudulBuku();
            data[4] = AllObjectController.peminjamanController.showAllData().get(i).getNamaAnggota();
            data[5] = AllObjectController.peminjamanController.showAllData().get(i).getTglPeminjaman();
            data[6] = AllObjectController.peminjamanController.showAllData().get(i).getTglPengembalian();
            data[7] = AllObjectController.peminjamanController.showAllData().get(i).getStatusPeminjaman();
            dataPeminjaman.addRow(data);
        }
        return dataPeminjaman;
    }

    protected DefaultTableModel dataTablePeminjamanByUser(int id){
        DefaultTableModel dataPeminjaman = new DefaultTableModel();
        Object[] kolom = {"NO","ID","ISBN","TGL PINJAM","TGL KEMBALI","STATUS KEMBALI"};
        dataPeminjaman.setColumnIdentifiers(kolom);
        int size = AllObjectController.peminjamanController.showDataByPeminjam(id).size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[5];
            data[0] = i+1;
            data[1] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getIdPeminjaman();
            data[2] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getIsbnBuku();
            data[3] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getTglPeminjaman();
            data[4] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getTglPengembalian();
            data[5] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getStatusPeminjaman();
            dataPeminjaman.addRow(data);
        }
        return dataPeminjaman;
    }
}
