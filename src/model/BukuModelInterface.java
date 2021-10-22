package model;

import helper.DbUtil;
import entity.BukuEntity;

import java.sql.Connection;
import java.util.ArrayList;

public interface BukuModelInterface {
    Connection conn = DbUtil.getConection();
    void add(BukuEntity buku);
    void updateJudul(String isbn,String judul);
    void updatePenerbit(String isbn, String penerbit);
    void delete(String isbn);
    ArrayList<BukuEntity> getAll();
}
