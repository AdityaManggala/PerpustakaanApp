package helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

    public static Connection getConection(){
        Connection conn = null;
        String driver ="com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_perpus";
        String user = "root";
        String pass = "";

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("GAGAL");
            e.printStackTrace();
        }
        return conn;
    }

}
