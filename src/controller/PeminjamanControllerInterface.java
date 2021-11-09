package controller;

import entity.AnggotaEntity;
import entity.BukuEntity;
import entity.PeminjamanEntity;

import java.util.ArrayList;

public interface PeminjamanControllerInterface {
    void insertPeminjaman(BukuEntity buku, AnggotaEntity anggota);
    void verifPengembalian(String idPeminjaman);
    ArrayList<PeminjamanEntity> showAllData();
    ArrayList<PeminjamanEntity> showDataByPeminjam(int id);
}
