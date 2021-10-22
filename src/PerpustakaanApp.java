import controller.*;
import entity.AnggotaEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PerpustakaanApp {
    public static Scanner input = new Scanner(System.in);
    public static AdminControllerInterface adminController = new AdminControllerInterfaceImpl();
    public static AnggotaControllerInterface anggotaController = new AnggotaControllerInterfaceImpl();
    public static BukuControllerInterface bukuController = new BukuControllerInterfaceImpl();
    public static PeminjamanControllerInterface peminjamanController = new PeminjamanControllerInterfaceImpl();

    public static void main(String[] args) {
        System.out.println("PERPUSTAKAAN APP");
        System.out.println("1.GUI");
        System.out.println("2.Console");
        System.out.print("PILIHAN : ");
        int pilihan = input.nextInt();
        switch (pilihan){
            case 1:
                //
                break;
            case 2:
                console();
                break;
            default:
                System.out.println("INPUTAN TIDAK DIKETAHUI");
                break;
        }
    }

    public static void console(){
        int pilih;
        do {
            System.out.println("SELAMAT DATAMG");
            System.out.println("1.REGISTRASI");
            System.out.println("2.LOGIN");
            System.out.println("3.KELUAR");
            System.out.print("PILIHAN : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    registrasi();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("KELUAR");
                    break;
            }
        }while (pilih<=2);
    }

    public static void registrasi(){
        System.out.print("NAMA : ");
        String nama = input.next();
        System.out.print("PASSWORD : ");
        String password = input.next();
        System.out.print("NO TELP : ");
        String noTelp = input.next();
        System.out.print("ALAMAT : ");
        String alamat = input.next();
        anggotaController.insertAnggota(nama,password,noTelp,alamat);
    }

    public static void login(){
        int pilih;
        do{
            System.out.println("LOGIN AS :");
            System.out.println("1.ADMIN");
            System.out.println("2.ANGGOTA");
            System.out.print("PILIHAN : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginAnggota();
                    break;

            }
        }while (pilih<=2);
    }

    public static void loginAdmin(){
        System.out.print("USERNAME : ");
        String username = input.next();
        System.out.print("PASSWORD : ");
        String pass = input.next();
        if (adminController.login(username,pass)){
            menuAdmin();
        }else{
            System.out.println("USER ATAU PASS SALAH");
        }
    }

    public static void loginAnggota(){
        System.out.print("USERNAME : ");
        String username = input.next();
        System.out.print("PASSWORD : ");
        String pass = input.next();
        if (anggotaController.login(username,pass)!=0){
            int id = anggotaController.login(username,pass);
            menuAnggota(id);
        }else{
            System.out.println("USER ATAU PASS SALAH");
        }
    }

    public static void menuAdmin(){
        int pilih;
        do{
            System.out.println("MENU USER ADMIN");
            System.out.println("1.LIHAT DAFTAR ANGGOTA");
            System.out.println("2.HAPUS ANGGOTA");
            System.out.println("3.RESET PASSWORD ANGGOTA");
            System.out.println("4.LIHAT DAFTAR BUKU");
            System.out.println("5.TAMBAH DAFTAR BUKU");
            System.out.println("6.HAPUS DAFTAR BUKU");
            System.out.println("7.UBAH INFORMASI BUKU");
            System.out.println("8.LIHAT DAFTAR PEMINJAMAN");
            System.out.println("9.VERIFIKASI PENGEMBALIAN");
            System.out.println("10.KELUAR");
            System.out.print("PILIHAN : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    daftarAnggota();
                    break;
                case 2:
                    hapusAnggota();
                    break;
                case 3:
                    resetPasswordAnggota();
                    break;
                case 4:
                    daftarBuku();
                    break;
                case 5:
                    tambahDaftarBuku();
                    break;
                case 6:
                    hapusBuku();
                    break;
                case 7:
                    ubahbuku();
                    break;
                case 8:
                    lihatDaftarPeminjaman();
                    break;
                case 9:
                    verifikasiPengembalian();
                    break;
            }
        }while (pilih<=9);
    }

    public static void daftarAnggota(){
        int size = anggotaController.showAllData().size();
        System.out.println("DATA DAFTAR ANGGOTA");
        for (int i = 0; i < size; i++) {
            System.out.println((i+1)+". "+anggotaController.showAllData().get(i).getId()+" "+
                    anggotaController.showAllData().get(i).getNama()+" "+
                    anggotaController.showAllData().get(i).getPassword()+" "+
                    anggotaController.showAllData().get(i).getNoTelp()+" "+
                    anggotaController.showAllData().get(i).getAlamat()
            );
        }
    }

    public static void hapusAnggota(){
        daftarAnggota();
        System.out.print("ID : ");
        int id = input.nextInt();
        adminController.deleteAnggota(id);
    }

    public static void resetPasswordAnggota(){
        daftarAnggota();
        System.out.print("ID : ");
        int id = input.nextInt();
        adminController.resetPassAnggota(id);
    }

    public static void daftarBuku(){
        int size = bukuController.showAllData().size();
        for (int i = 0; i < size; i++) {
            System.out.println((i+1)+". "+bukuController.showAllData().get(i).getIsbn()+" "+
                    bukuController.showAllData().get(i).getJudul()+" "+
                    bukuController.showAllData().get(i).getPenerbit()+" "+
                    bukuController.showAllData().get(i).getTerbit()+" "+
                    bukuController.showAllData().get(i).getHalaman()
            );
        }
    }

    public static void tambahDaftarBuku(){
        System.out.print("ISBN Buku : ");
        String isbn = input.next();
        System.out.print("Judul Buku : ");
        String judul = input.next();
        judul += input.nextLine();
        System.out.print("Penerbit Buku : ");
        String penerbit = input.next();
        penerbit += input.nextLine();
        System.out.print("Jumlah Halaman Buku : ");
        int halaman = input.nextInt();
        System.out.print("Tahun Terbit Buku : ");
        int tanggal = input.nextInt();
        bukuController.InsertBuku(isbn,judul,penerbit,tanggal,halaman);
    }

    public static void hapusBuku(){
        daftarBuku();
        System.out.print("KODE ISBN : ");
        String isbn = input.next();
        bukuController.deleteBuku(isbn);
    }

    public static void ubahbuku(){
        int pilih;
        do {
            System.out.println("1.UBAH JUDUL BUKU");
            System.out.println("2.UBAH PENERBIT BUKU");
            System.out.println("3.KEMBALI KE MENU");
            System.out.print("PILIHAN : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    daftarBuku();
                    System.out.print("JUDUL BARU : ");
                    String judul = input.next();
                    judul += input.nextLine();
                    System.out.print("ISBN BUKU : ");
                    String isbn = input.next();
                    bukuController.updateBuku(1,isbn,judul);
                    break;
                case 2:
                    daftarBuku();
                    System.out.print("PENERBIT BARU : ");
                    String penerbit = input.next();
                    penerbit += input.nextLine();
                    System.out.print("ISBN BUKU : ");
                    isbn = input.next();
                    bukuController.updateBuku(2,isbn,penerbit);
                    break;
            }
        }while (pilih<=2);

    }

    public static void lihatDaftarPeminjaman(){
        int size = peminjamanController.showAllData().size();
        for (int i = 0; i < size; i++) {
            String status = !peminjamanController.showAllData().get(i).getStatusPeminjaman() ? "Masih dipinjam":"Telah Kembali";
            System.out.println((i+1)+". "+peminjamanController.showAllData().get(i).getIdPeminjaman()+" "+
                    peminjamanController.showAllData().get(i).getIsbnBuku()+" "+
                    peminjamanController.showAllData().get(i).getJudulBuku()+" "+
                    peminjamanController.showAllData().get(i).getNamaAnggota()+" "+
                    peminjamanController.showAllData().get(i).getTglPeminjaman()+" "+
                    peminjamanController.showAllData().get(i).getTglPengembalian()+" "+status);
        }
    }

    public static void verifikasiPengembalian(){
        lihatDaftarPeminjaman();
        System.out.print("ID PEMINJAMAN : ");
        String idPeminjaman = input.next();
        peminjamanController.verifPengembalian(idPeminjaman);
    }

    public static void menuAnggota(int id){
        int pilih;
        do{
            System.out.println(id);
            System.out.println("1.LIHAT RIWAYAT PEMINJAMAN");
            System.out.println("2.LAKUKAN PEMINJAMAN ");
            System.out.println("3.EDIT DATA DIRI");
            System.out.println("4.KELUAR");
            System.out.print("PILIHAN : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    lihatRiwayatPeminjaman(id);
                    break;
                case 2:
                    pinjamBuku(id);
                    break;
                case 3:
                    editDataAnggota(id);
                    break;
            }
        }while (pilih<=3);
    }

    public static void lihatRiwayatPeminjaman(int id){
        int size = peminjamanController.showDataByPeminjam(id).size();
        for (int i = 0; i < size; i++) {
            String status = !peminjamanController.showDataByPeminjam(id).get(i).getStatusPeminjaman() ? "Masih dipinjam":"Telah Kembali";
            System.out.println((i+1)+". "+peminjamanController.showDataByPeminjam(id).get(i).getIdPeminjaman()+" "+
                    peminjamanController.showDataByPeminjam(id).get(i).getIsbnBuku()+" "+
                    peminjamanController.showDataByPeminjam(id).get(i).getTglPeminjaman()+" "+
                    peminjamanController.showDataByPeminjam(id).get(i).getTglPengembalian()+" "+
                    status
            );
        }
    }

    public static void pinjamBuku(int id){
        daftarBuku();
        System.out.print("ISBN BUKU : ");
        String isbn = input.next();
        peminjamanController.insertPeminjaman(isbn,id);
    }

    public static void editDataAnggota(int id){
        int pilih;
        do{
            System.out.println("1.UBAH PASSWORD");
            System.out.println("2.UBAH ALAMAT");
            System.out.println("3.UBAH NOTELP");
            System.out.println("4.KELUAR");
            pilih = input.nextInt();
            if (pilih == 1){
                dataAnggotaById(id);
                System.out.print("PASSWORD BARU : ");
                String pass = input.next();
                anggotaController.updateAkun(1,pass,id);
            }else if(pilih == 2){
                dataAnggotaById(id);
                System.out.print("ALAMAT BARU : ");
                String alamat = input.next();
                anggotaController.updateAkun(2,alamat,id);
            }else if(pilih == 3){
                dataAnggotaById(id);
                System.out.print("NOTELP BARU : ");
                String noTelp = input.next();
                anggotaController.updateAkun(3,noTelp,id);
            }
        }while (pilih<=3);
    }

    public static void dataAnggotaById(int id){
        for (AnggotaEntity anggota: anggotaController.showDataAnggotaById(id)) {
            System.out.println(
                    anggota.getNama()+" "+
                    anggota.getPassword()+" "+
                    anggota.getNoTelp()+" "+
                    anggota.getAlamat()
            );
        }
    }

}
