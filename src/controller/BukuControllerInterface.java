package controller;

import entity.BukuEntity;

import java.sql.Date;
import java.util.ArrayList;

public interface BukuControllerInterface {
    void InsertBuku(String isbn, String judul, String penerbit, int terbit, int halaman);
    void deleteBuku(String isbn);
    void updateBuku(int pilihan, String isbn,String data);
    ArrayList<BukuEntity> showAllData();
}
