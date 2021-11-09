package controller;

import entity.AnggotaEntity;
import entity.BukuEntity;
import entity.PeminjamanEntity;

import java.util.ArrayList;

public class PeminjamanControllerInterfaceImpl implements PeminjamanControllerInterface{


    @Override
    public void insertPeminjaman(BukuEntity buku, AnggotaEntity anggota) {
        PeminjamanEntity peminjaman = new PeminjamanEntity(buku,anggota);
        AllObjectModel.peminjamanModel.add(peminjaman);
    }

    @Override
    public void verifPengembalian(String idPeminjaman) {
        AllObjectModel.peminjamanModel.verifPengembalian(idPeminjaman);
    }

    @Override
    public ArrayList<PeminjamanEntity> showAllData() {
        return AllObjectModel.peminjamanModel.getAll();
    }

    @Override
    public ArrayList<PeminjamanEntity> showDataByPeminjam(int id) {
        return AllObjectModel.peminjamanModel.getByPeminjam(id);
    }
}
