package controller;

import entity.BukuEntity;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BukuControllerInterfaceImpl implements BukuControllerInterface{


    @Override
    public void InsertBuku(String isbn, String judul, String penerbit, int terbit, int halaman) {
        BukuEntity buku = new BukuEntity(isbn,judul,penerbit,terbit,halaman);
        AllObjectModel.bukuModel.add(buku);
    }

    @Override
    public void deleteBuku(String isbn) {
        AllObjectModel.bukuModel.delete(isbn);
    }

    @Override
    public void updateBuku(int pilihan, String isbn, String data) {
        if (pilihan == 1) {
            AllObjectModel.bukuModel.updateJudul(isbn,data);
        }else if (pilihan == 2) {
            AllObjectModel.bukuModel.updatePenerbit(isbn,data);
        }else
            System.out.println("Opsi Tidak Ditemukan");
    }

    @Override
    public ArrayList<BukuEntity> showAllData() {
        return AllObjectModel.bukuModel.getAll();
    }
}
