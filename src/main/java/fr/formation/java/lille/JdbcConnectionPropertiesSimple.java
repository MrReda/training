package fr.formation.java.lille;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcConnectionPropertiesSimple {
    public static void main(String... args){

        try {
            FileInputStream fis = new FileInputStream("src/main/ressources/connection.prop");
            Properties p = new Properties();
            p.load(fis);
            String dname = (String) p.get("Dname");
            String url = (String) p.get("URL");
            String username = (String) p.get("Uname");
            String password = (String) p.get("password");
            Class.forName(dname);
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = con.prepareStatement("call updateNom(1, 'Nikosissos')");

            int rs =stmt.executeUpdate();
            System.out.println(rs);
            /*while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            rs.close();*/
            stmt.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
