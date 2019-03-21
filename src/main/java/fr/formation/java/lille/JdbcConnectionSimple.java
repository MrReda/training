package fr.formation.java.lille;

import java.sql.*;

import static java.lang.Class.forName;

public class JdbcConnectionSimple {

    static final String jdbc_driver = "com.mysql.jdbc.Driver";
    static final String db_url = "jdbc:mysql://localhost/formation";

    static final String user = "root";
    static final String pass = "";

    public static void main(String... args){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting database...");
            conn = DriverManager.getConnection(db_url,user,pass);

            System.out.println("creating statment...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employees ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                //extraction des valeurs de la base
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //On montre les valeurs
                System.out.print(", ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //Nettoyage de l'environnement
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Bye !");
    }

}
