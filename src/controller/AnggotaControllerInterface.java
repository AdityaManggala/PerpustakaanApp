package controller;

import entity.AnggotaEntity;

import java.util.ArrayList;

public interface AnggotaControllerInterface {
    void insertAnggota(String nama, String password, String noTelp, String alamat);
    int login(String nama, String password);
    ArrayList<AnggotaEntity> showAllData();
    AnggotaEntity getData(int id);
    void updateAkun(int pilihan, String data, int id);
}
