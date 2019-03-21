package fr.formation.java.lille;

import java.sql.*;

public class Connexion {

    private static Connection connection = null;


    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        Savepoint savepoint1 = null;

        try {
            //JDBC DRIVER
            Class.forName("com.mysql.jdbc.Driver");
            //Connexion à la BDD avec les log : l'url , user et password
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/formation", "root", "");

            System.out.println("Connexion....");

            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO employees VALUES (777, 48, 'fsdf', 'fsdfsd')");


            savepoint1 = connection.setSavepoint("pepito");

            //submit a malformed SQL statement that breaks

            stmt.executeUpdate("INSERTe INTO employees VALUES (888, 55, 'fsdfsd', 'fsdfsd')");

            // If there is not error
            connection.commit();


            //catch l'erreur si il y a un probleme avec la liaison du Driver installé
        }catch (ClassNotFoundException e){
            // TODO: handle exception
            System.out.println("Erreur Driver");

            //catch l'erreur si il y a un probléme avec l'appel de la BDD
        }catch (SQLException ee) {
            // TODO: handle exception
            System.out.println("Erreur Database");

            // If there is any error
            connection.rollback(savepoint1);

        }
    }

}