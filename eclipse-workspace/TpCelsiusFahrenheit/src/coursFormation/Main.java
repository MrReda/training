package coursFormation;

import java.util.Scanner;

public class Main {
	public static double arrondi(double A, int B) {
		return (double) ((int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
	}

	public static void main(String[] args) {

		System.out.println("TP : CONVERSION DEGRES CELSIUS/FAHRENHEIT");

		char type = ' ';
		double temperature = ' ';
		char reponse = 'O';

		Scanner sc = new Scanner(System.in);
		

		do {

			do {
				System.out.println("choisissez un mode de conversion disponible :");
				System.out.println("1. celsius - fahrenheit");
				System.out.println("2. fahrenheit - celsius");

				type = sc.nextLine().charAt(0);

				if (type != '1' && type != '2') {
					System.out.println("type inconnu");
				}

			} while (type != '1' && type != '2');

			System.out.println("température à convertir :");
			temperature = sc.nextDouble();
			sc.nextLine();
			if (type == '1') {
				double resultat = ((9.0 / 5.0) * temperature) + 32.0;
				System.out.println("donne :" + resultat + " °F.");
			} else {
				double resultat = ((temperature - 32.0) * 5.0) / 9.0;
				System.out.println("donne :" + resultat + " °C.");
			}

			do {
				System.out.println("voulez-vous recommencer? (O/N)");
				reponse = sc.nextLine().charAt(0);
			} while (reponse != 'O' && reponse != 'N');

		} while (reponse == 'O');

		System.out.println("Ciao");
		;

	}

}
