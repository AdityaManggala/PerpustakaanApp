package controller;

import entity.PeminjamanEntity;

import java.util.ArrayList;

public class PeminjamanControllerInterfaceImpl implements PeminjamanControllerInterface{


    @Override
    public void insertPeminjaman(String isbnBuku, int idAnggota) {
        PeminjamanEntity peminjaman = new PeminjamanEntity(isbnBuku,idAnggota);
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
