package model;

import entity.AnggotaEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnggotaModelInterfaceImpl implements AnggotaModelInterface{

    @Override
    public void add(AnggotaEntity anggota) {
        try{
            String sql = "INSERT INTO anggota(anggota_nama, anggota_password, anggota_notelp, anggota_alamat) VALUES (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,anggota.getNama());
            statement.setString(2,anggota.getPassword());
            statement.setString(3,anggota.getNoTelp());
            statement.setString(4,anggota.getAlamat());

            statement.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void remove(int id) {
        try {
            String sql = "UPDATE anggota SET anggota_aktif = False WHERE anggota_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public int login(String nama, String password) {
        int cek = 0;
        try{
            String sql ="SELECT * FROM anggota WHERE anggota_nama =? AND anggota_password = ? AND anggota_aktif = TRUE";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,nama);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                cek = rs.getInt("anggota_id");
            }else {
                cek = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }return cek;
    }

    @Override
    public ArrayList<AnggotaEntity> getAll() {
        ArrayList<AnggotaEntity> listAnggota = new ArrayList<>();
        try {
            String sql = "SELECT * From anggota WHERE anggota_aktif = TRUE";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                AnggotaEntity anggota = new AnggotaEntity(
                        rs.getString("anggota_nama"),
                        rs.getString("anggota_password"),
                        rs.getString("anggota_notelp"),
                        rs.getString("anggota_alamat"));
                anggota.setId(rs.getInt("anggota_id"));
                listAnggota.add(anggota);
            }
        }catch (SQLException e){e.printStackTrace();}
        return listAnggota;
    }

    @Override
    public AnggotaEntity getById(int id) {
        AnggotaEntity anggota = null;
        try{
            String sql = "SELECT * FROM anggota WHERE anggota_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                anggota = new AnggotaEntity(
                        rs.getString("anggota_nama"),
                        rs.getString("anggota_password"),
                        rs.getString("anggota_notelp"),
                        rs.getString("anggota_alamat"));
                anggota.setId(rs.getInt("anggota_id"));
            }
        }catch (SQLException e){e.printStackTrace();}
        return anggota;
    }

    @Override
    public void resetPassword(int id) {
        try{
            String sql = "UPDATE anggota SET anggota_password = '12345678' WHERE anggota_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void updateNoTelp(String noTelp, int id) {
        try{
            String sql = "UPDATE anggota SET anggota_notelp = ? WHERE anggota_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,noTelp);
            statement.setInt(2,id);
            statement.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void updateAlamat(String alamat, int id) {
        try{
            String sql = "UPDATE anggota SET anggota_alamat = ? WHERE anggota_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,alamat);
            statement.setInt(2,id);
            statement.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void updatePassword(String password, int id) {
        try{
            String sql = "UPDATE anggota SET anggota_password = ? WHERE anggota_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,password);
            statement.setInt(2,id);
            statement.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }
}
