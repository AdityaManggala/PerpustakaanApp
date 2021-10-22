package model;

import helper.DbUtil;
import entity.AnggotaEntity;

import java.sql.Connection;
import java.util.ArrayList;

public interface AnggotaModelInterface {
    Connection conn = DbUtil.getConection();
    void add(AnggotaEntity anggota);
    void remove(int id);
    int login(String nama, String password);
    ArrayList<AnggotaEntity> getAll();
    ArrayList<AnggotaEntity> getById(int id);
    void resetPassword(int id);
    void updateNoTelp(String noTelp, int id);
    void updateAlamat(String alamat, int id);
    void updatePassword(String password,int id);
}
