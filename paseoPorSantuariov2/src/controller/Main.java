package controller;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int respuesta = 0;
		int numeroAleatorio;
		int numBatallas = 3;

		String clase;

		String inventarioPersonaje[] = new String[10];
		
		int ejemplo=67;
		
		String nombre="Maria";

		// posición 0 vidaOriginal
		// posición 1 vida
		// posición 2 ataque
		// posición 3 bonus de arma
		int statsPersonaje[] = new int[4];

		/*
		 * String armas [] = new String[5];
		 * 
		 * armas[0] = "Espada"; armas[1] = "Hacha"; armas[2] = "Báculo"; armas[3] =
		 * "Jabalina"; armas[4] = "Arco";
		 */

		String clases[] = { "Bárbaro", "Paladín", "Amazona", "Hechicero" };
		String armas[] = { "Hacha", "Espada", "Jabalina", "Báculo", "Arco" };
		String enemigos[] = { "Goblin", "Araña", "Esqueleto", "Cultista", "Murciélago", "Dragón" };

		String enemigoElegido;
		int statsEnemigo[] = new int[3];

		System.out.println("Bienvenido a Santuario. Elige una clase");

		do {

			System.out.println("CLASES DISPONIBLES (ELIGE EL NÚMERO DE LA CLASE QUE QUIERAS)");
			System.out.println("============================================================");

			for (int i = 0; i < clases.length; i++) {
				System.out.println((i+1) + " - " + clases[i]);
			}

			respuesta = sc.nextInt();

			if (respuesta < 1 || respuesta > 4) {
				System.out.println();
				System.out.println("RESPUESTA ERRÓNEA, INTRODUCE UN NÚMERO CORRECTO");
				System.out.println();
			}

		} while (respuesta < 1 || respuesta > 4);

		if (respuesta == 1) {

			clase = "Bárbaro";
			inventarioPersonaje[0] = armas[0];
			statsPersonaje[0] = 100;
			statsPersonaje[1] = 100;
			statsPersonaje[2] = 6;
			statsPersonaje[3] = 4;

		} else if (respuesta == 2) {

			clase = "Paladín";
			inventarioPersonaje[0] = armas[1];
			statsPersonaje[0] = 150;
			statsPersonaje[1] = 150;
			statsPersonaje[2] = 20;
			statsPersonaje[3] = 1;

		} else if (respuesta == 3) {

			clase = "Amazona";
			inventarioPersonaje[0] = armas[2];
			statsPersonaje[0] = 80;
			statsPersonaje[1] = 80;
			statsPersonaje[2] = 12;
			statsPersonaje[3] = 2;

		} else {

			clase = "Hechicero";
			inventarioPersonaje[0] = armas[3];
			statsPersonaje[0] = 60;
			statsPersonaje[1] = 60;
			statsPersonaje[2] = 25;
			statsPersonaje[3] = 5;
		}

		System.out.println("La clase elegida es: " + clase);

		System.out.println("Tu arma inicial es: " + inventarioPersonaje[0]);

		while (numBatallas > 0 && statsPersonaje[1] > 0) {

			numeroAleatorio = rd.nextInt(0, enemigos.length);

			System.out.println();
			System.out.println("Avanzas por la espesura, y de repente...");
			System.out.println();

			//asignación de stats al enemigo aleatorio
			enemigoElegido = enemigos[numeroAleatorio];
			statsEnemigo[0] = (numeroAleatorio + 1) * 25;
			statsEnemigo[1] = statsEnemigo[0];
			statsEnemigo[2] = (numeroAleatorio + 2) * 2;

			System.out.println("Te sale al paso el siguiente enemigo: " + enemigoElegido);

			while (statsPersonaje[1] > 0 && statsEnemigo[1] > 0) {

				System.out.println();
				System.out.println(clase + " ataca a " + enemigoElegido + " con su " + inventarioPersonaje[0]);
				int potenciaAtaque = statsPersonaje[2] + statsPersonaje[3];
				System.out.println(enemigoElegido + " recibe un ataque de " + potenciaAtaque + " puntos de daño");
				statsEnemigo[1] -= potenciaAtaque;

				if (statsEnemigo[1] > 0) {
					System.out.println();
					System.out.println(enemigoElegido + " ataca a " + clase);
					System.out.println(clase + " recibe un ataque de " + statsEnemigo[2] + " puntos de daño");
					statsPersonaje[1] -= statsEnemigo[2];
				} else {
					statsEnemigo[1] = 0;
				}

				if (statsPersonaje[1] < 0) {
					statsPersonaje[1] = 0;
				}

				System.out.println();
				System.out.println("Puntos de vida de " + clase + ": " + statsPersonaje[1] + "/" + statsPersonaje[0]);
				System.out.println(
						"Puntos de vida de " + enemigoElegido + ": " + statsEnemigo[1] + "/" + statsEnemigo[0]);

			}

			System.out.println("FIN DEL COMBATE");
			numBatallas--;
		}

		if (statsPersonaje[1] == 0) {
			System.out.println("GAME OVER");
		} else {
			System.out.println("ENHORABUENA, AVENTURERO, HAS SALVADO SANTUARIO");
		}

	}

}

