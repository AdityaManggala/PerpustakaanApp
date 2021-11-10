package controller;

import entity.AnggotaEntity;

import java.util.ArrayList;

public class AnggotaControllerInterfaceImpl implements AnggotaControllerInterface{

    @Override
    public void insertAnggota(String nama, String password, String noTelp, String alamat) {
        AnggotaEntity anggotaEntity = new AnggotaEntity(nama,password,noTelp,alamat);
        AllObjectModel.anggotaModel.add(anggotaEntity);
    }

    @Override
    public int login(String nama, String password) {
        return AllObjectModel.anggotaModel.login(nama,password);
    }

    @Override
    public ArrayList<AnggotaEntity> showAllData() {
        return AllObjectModel.anggotaModel.getAll();
    }

    @Override
    public AnggotaEntity getData(int id) {
        return AllObjectModel.anggotaModel.getById(id);
    }

    @Override
    public void updateAkun(int pilihan, String data, int id) {
        switch (pilihan){
            case 1:
                AllObjectModel.anggotaModel.updatePassword(data,id);
                break;
            case 2:
                AllObjectModel.anggotaModel.updateAlamat(data,id);
                break;
            case 3:
                AllObjectModel.anggotaModel.updateNoTelp(data,id);
                break;
        }
    }
}
