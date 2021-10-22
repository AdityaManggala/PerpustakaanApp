package model;

import helper.DbUtil;
import entity.PeminjamanEntity;

import java.sql.Connection;
import java.util.ArrayList;

public interface PeminjamanModelInterface {
    Connection conn = DbUtil.getConection();
    void add(PeminjamanEntity peminjaman);
    void verifPengembalian(String idPeminjaman);
    ArrayList<PeminjamanEntity> getAll();
    ArrayList<PeminjamanEntity> getByPeminjam(int id);
}
