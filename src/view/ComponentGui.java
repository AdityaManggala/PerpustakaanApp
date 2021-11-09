package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentGui extends JComponent{
    protected JFrame jendela = new JFrame();
    protected JPanel adminpanel = new JPanel();
    protected JPanel datadiripanel = new JPanel();
    protected JPanel pinjampanel = new JPanel();
    protected JPanel riwayatpinjampanel = new JPanel();
    protected JPanel peminjamanbukupanel = new JPanel();
    protected JPanel daftaranggota = new JPanel();
    protected JPanel daftarbuku = new JPanel();
    protected JPanel daftarpinjaman = new JPanel();
    protected JPanel btngroupbuku = new JPanel();
    protected JPanel btngroupanggota = new JPanel();
    protected JLabel lblnama = new JLabel("Nama");
    protected JLabel lblpassword = new JLabel("Password");
    protected JLabel lblregister = new JLabel("Register");
    protected JLabel lblalamat = new JLabel("Alamat");
    protected JLabel lblnotelp = new JLabel("No Telp");
    protected JLabel lblisbn = new JLabel("ISBN");
    protected JLabel lbljudulbuku = new JLabel("Judul");
    protected JLabel lblpenerbit = new JLabel("Penerbit");
    protected JLabel lblterbit = new JLabel("Tahun Terbit");
    protected JLabel lblhalaman = new JLabel("Jumlah Halaman");
    protected JLabel bingkaigambar = new JLabel();
    protected JTextField flisbn = new JTextField();
    protected JTextField fljudulbuku = new JTextField();
    protected JTextField flpenerbit = new JTextField();
    protected JTextField flterbit = new JTextField();
    protected JTextField flhalaman = new JTextField();
    protected JTextField flnama = new JTextField();
    protected JPasswordField flpass = new JPasswordField();
    protected JTextField flalamat = new JTextField();
    protected JTextField flnotelp = new JTextField();
    protected JButton btnlogin = new JButton("Login");
    protected JButton btnloginadmin = new JButton();
    protected JButton btnloginanggota = new JButton("Login As Anggota");
    protected JButton btnregister = new JButton("Register");
    protected JButton btnubahakun = new JButton("Ubah Informasi");
    protected JButton btntambahbuku = new JButton("Tambah");
    protected JButton btnubahbuku = new JButton("Ubah");
    protected JButton btnhapusbuku = new JButton("Hapus");
    protected JButton btnverif = new JButton("Verif Pengembalian");
    protected JButton btnresetpass = new JButton("Reset Password");
    protected JButton btnhapusanggota = new JButton("Hapus Anggota");
    protected JButton btnpinjam = new JButton("Pinjam");
    protected JButton btnlogout = new JButton("Log Out");

    protected TitledBorder ttldaftaranggota = BorderFactory.createTitledBorder("Daftar Anggota");
    protected TitledBorder ttldaftarbuku = BorderFactory.createTitledBorder("Daftar Buku");
    protected TitledBorder ttldaftarpinjaman = BorderFactory.createTitledBorder("Daftar Pinjaman");
    protected TitledBorder ttlakunsetting = BorderFactory.createTitledBorder("Informasi Akun");
    protected TitledBorder ttlpinjam = BorderFactory.createTitledBorder("Peminjaman Buku");
    protected TitledBorder ttlriwayatpinjam = BorderFactory.createTitledBorder("Riwayat Peminjaman Buku");


    protected JTable tblanggota = new JTable(dataTableAnggota());
    protected JTable tblbuku = new JTable(dataTableBuku());
    protected JTable tblpeminjaman = new JTable(dataTablePeminjaman());

    protected JTabbedPane tab = new JTabbedPane();

    protected JScrollPane spanggota = new JScrollPane(tblanggota);
    protected JScrollPane spbuku = new JScrollPane(tblbuku);
    protected JScrollPane sppeminjaman = new JScrollPane(tblpeminjaman);

    BufferedImage bufferedImage = null;
    Image gambarresize;

    void kosong(){
        flnama.setText(null);
        flalamat.setText(null);
        flpass.setText(null);
        flnotelp.setText(null);
        flisbn.setText(null);
        fljudulbuku.setText(null);
        flpenerbit.setText(null);
        flterbit.setText(null);
        flhalaman.setText(null);
    }

    protected DefaultTableModel dataTableBuku(){
        DefaultTableModel dataBuku = new DefaultTableModel();
        Object[] kolom = {"NO","ISBN","JUDUL","PENERBIT","TERBIT","HALAMAN"};
        dataBuku.setColumnIdentifiers(kolom);
        int size = AllObjectController.bukuController.showAllData().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[6];
            data[0] = i+1;
            data[1] = AllObjectController.bukuController.showAllData().get(i).getIsbn();
            data[2] = AllObjectController.bukuController.showAllData().get(i).getJudul();
            data[3] = AllObjectController.bukuController.showAllData().get(i).getPenerbit();
            data[4] = AllObjectController.bukuController.showAllData().get(i).getTerbit();
            data[5] = AllObjectController.bukuController.showAllData().get(i).getHalaman();
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
            Object[] data = new Object[8];
            data[0] = i+1;
            data[1] = AllObjectController.peminjamanController.showAllData().get(i).getIdPeminjaman();
            data[2] = AllObjectController.peminjamanController.showAllData().get(i).getBuku().getIsbn();
            data[3] = AllObjectController.peminjamanController.showAllData().get(i).getBuku().getJudul();
            data[4] = AllObjectController.peminjamanController.showAllData().get(i).getAnggota().getNama();
            data[5] = AllObjectController.peminjamanController.showAllData().get(i).getTglPeminjaman();
            data[6] = AllObjectController.peminjamanController.showAllData().get(i).getTglPengembalian();
            data[7] = AllObjectController.peminjamanController.showAllData().get(i).getStatusPeminjaman()? "Telah Kembali":"Masih dipinjam";
            dataPeminjaman.addRow(data);
        }
        return dataPeminjaman;
    }

    protected DefaultTableModel dataTablePeminjamanByUser(int id){
        DefaultTableModel dataPeminjaman = new DefaultTableModel();
        Object[] kolom = {"NO","ID","JUDUL","TGL PINJAM","TGL KEMBALI","STATUS KEMBALI"};
        dataPeminjaman.setColumnIdentifiers(kolom);
        int size = AllObjectController.peminjamanController.showDataByPeminjam(id).size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[6];
            data[0] = i+1;
            data[1] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getIdPeminjaman();
            data[2] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getBuku().getJudul();
            data[3] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getTglPeminjaman();
            data[4] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getTglPengembalian();
            data[5] = AllObjectController.peminjamanController.showDataByPeminjam(id).get(i).getStatusPeminjaman()? "Telah Kembali":"Masih dipinjam";
            dataPeminjaman.addRow(data);
        }
        return dataPeminjaman;
    }
}
