package fr.formation.java.lille;


import java.util.Scanner;

import static java.lang.System.exit;

public class SynchronizedTest {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        demande(" age");
        int age = Integer.parseInt(scanner.nextLine());

        demande(" nom");
        String nom = scanner.nextLine();

        demande(" pays");
        String pays = scanner.nextLine();

        try {
            testThrows(age, nom, pays);
        } catch (OurExeption e) {
            System.out.println(e.getMessage());
            exit(0);
        }
        System.out.println("Bienvenue Francois le francais");
    }

    public static void testThrows(int age, String nom, String pays) throws OurExeption {
        if (!(pays.equalsIgnoreCase("france")))
            throw new OurExeption();
    }

    public static void demande(String para){
        System.out.println("Entres votre" + para);
    }
}
