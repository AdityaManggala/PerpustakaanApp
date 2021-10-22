package model;

import entity.BukuEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BukuModelInterfaceImpl implements BukuModelInterface{

    @Override
    public void add(BukuEntity buku) {
        try{
            String sql = "INSERT INTO buku(buku_isbn,buku_judul,buku_penerbit,buku_terbit,buku_halaman) values (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, buku.getIsbn());
            statement.setString(2, buku.getJudul());
            statement.setString(3, buku.getPenerbit());
            statement.setInt(4, buku.getTerbit());
            statement.setInt(5, buku.getHalaman());

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateJudul(String isbn, String judul) {
        try{
            String sql="UPDATE buku SET buku_judul = ? WHERE buku_isbn = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,judul);
            statement.setString(2,isbn);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updatePenerbit(String isbn, String penerbit) {
        try{
            String sql="UPDATE buku SET buku_penerbit = ? WHERE buku_isbn = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,penerbit);
            statement.setString(2,isbn);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String isbn) {
        try{
            String sql="DELETE FROM buku WHERE buku_isbn = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, isbn);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<BukuEntity> getAll() {
        ArrayList<BukuEntity> listBuku = new ArrayList<>();
        try{
            String sql="SELECT * FROM buku";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                BukuEntity buku = new BukuEntity(rs.getString("buku_isbn"),
                        rs.getString("buku_judul"),
                        rs.getString("buku_penerbit"),
                        rs.getInt("buku_terbit"),
                        rs.getInt("buku_halaman"));
                listBuku.add(buku);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listBuku;
    }

}
