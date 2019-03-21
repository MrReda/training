package fr.formation.java.lille;

import java.util.Scanner;

public class SynchronizeTest {
    public static void main(String... args) {



            Scanner sc = new Scanner(System.in);

            ecriture("pseudo");
            String log = sc.nextLine();

            ecriture("mot de passe");
            String mdp = sc.nextLine();

            ecriture("pays");
            String pays = sc.nextLine();

            ecriture("age");
            int age1 = Integer.parseInt(sc.nextLine());


            try {
                testThrows(log, mdp, pays, age1);


            } catch (AccessDeniedException e) {
                System.out.println(e.getMessage());

            }
        }


    public static void testThrows(String user, String pass,String pays, int age) throws AccessDeniedException {
        if(!(user.equalsIgnoreCase("raven") || pass.equalsIgnoreCase("1515")) || age<20 || !(pays.equalsIgnoreCase("france"))){
            throw new AccessDeniedException();

        }
    }

    public static void ecriture( String dm){
        System.out.println("entrez votre " + dm);
    }
}