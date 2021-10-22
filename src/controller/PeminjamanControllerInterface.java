package controller;

import entity.PeminjamanEntity;

import java.util.ArrayList;

public interface PeminjamanControllerInterface {
    void insertPeminjaman(String isbnBuku, int idAnggota);
    void verifPengembalian(String idPeminjaman);
    ArrayList<PeminjamanEntity> showAllData();
    ArrayList<PeminjamanEntity> showDataByPeminjam(int id);
}
