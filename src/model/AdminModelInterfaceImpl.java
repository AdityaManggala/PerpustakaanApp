package model;

import entity.AdminEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModelInterfaceImpl implements AdminModelInterface {

    @Override
    public boolean login(AdminEntity adminEntity) {
        boolean cek = false;
        try {
            String sql ="SELECT * FROM admin WHERE admin_nama = ? AND admin_password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,adminEntity.getNama());
            statement.setString(2,adminEntity.getPassword());
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                cek = true;
            }else {
                cek = false;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return cek;
    }

}
