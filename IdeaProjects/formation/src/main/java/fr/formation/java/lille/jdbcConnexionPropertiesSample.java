package fr.formation.java.lille;


import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcConnexionPropertiesSample {
    public static void main(String... args){

        try{
            FileInputStream fis = new FileInputStream("src/main/ressources/connexion.prop");
            Properties p = new Properties();
            p.load(fis);
            String dname = (String) p.get("Dname");
            String url = (String) p.get("URL");
            String username = (String) p.get("Uname");
            String password =(String) p.get("password");
            Class.forName(dname);
            Connection con = DriverManager.getConnection(url,username, password);

            ////////////////////////////////////////////////////////APPEL PROCEDURE//////////////////////////////////
//            CallableStatement stmt = con.prepareCall(" CALL TestModifNom(? , ?)");
//            stmt.setInt(1,2);
//            stmt.registerOutParameter(2, Types.VARCHAR);
//            stmt.execute();
//            System.out.println(stmt.getString(2));

            ///////////////////////////////////////////////////////APPEL FONCTION//////////////////////////////////////
            CallableStatement call = con.prepareCall("{? = call verifAge(25)}");
            call.registerOutParameter(1, Types.VARCHAR);
            call.execute();
            System.out.println(call.getString(1));



//            ResultSet rs = stmt.executeQuery("select * from employees");
//            while(rs.next()){
//                System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3));
//            }
//
//            rs.close();
//            stmt.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
