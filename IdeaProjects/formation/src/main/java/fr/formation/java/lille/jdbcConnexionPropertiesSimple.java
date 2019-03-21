package fr.formation.java.lille;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcConnexionPropertiesSimple {
    private static Connection connection = null;
    static CallableStatement pstat = null;
    static String connectionURL = "jdbc:mysql://localhost:3306/formation";

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/formation";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";


    public static void main(String... args) throws SQLException {

        connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Savepoint savepoint1 = null;
//////////////////////////////////SAVEPOINT////////////////////////////////////////
        try {

            System.out.println("Connexion....");


            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();

            String SQL1 = "INSERT INTO employees VALUES (444, 29, 'gfdgdfg', 'tgdgde')";
            stmt.executeUpdate(SQL1);

            savepoint1 = connection.setSavepoint("pepito");

            //submit a malformed SQL statement that breaks
            String SQL2 = "INSERTe INTO employees VALUES (555,22,'fdsfsd','Sinsfdsdfgh')";
            stmt.executeUpdate(SQL2);

            // If there is not error
            connection.commit();
        }catch (SQLException se){
            // If there is any error
            connection.rollback(savepoint1);
        }

    }
}