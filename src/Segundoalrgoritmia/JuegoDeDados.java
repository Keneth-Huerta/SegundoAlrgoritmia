package Segundoalrgoritmia;

import java.util.Arrays;
import java.util.Random;

public class JuegoDeDados {

    public static void main(String[] args) {

        // Declaramos los arreglos para almacenar la puntuación de cada jugador
        int[] puntuacionJugador1 = new int[3];
        int[] puntuacionJugador2 = new int[3];

        // Declaramos un objeto Random para generar números aleatorios
        Random random = new Random();

        // Lanzamos los dados tres veces para cada jugador
        for (int i = 0; i < 3; i++) {
            // Lanzamos los dados para el jugador 1
            int dado1Jugador1 = random.nextInt(6) + 1;
            int dado2Jugador1 = random.nextInt(6) + 1;

            // Guardamos la puntuación del jugador 1
            if (dado1Jugador1 == dado2Jugador1) {
                puntuacionJugador1[i] = (dado1Jugador1 * 10);
            } else {
                puntuacionJugador1[i] = 0;
            }

            // Lanzamos los dados para el jugador 2
            int dado1Jugador2 = random.nextInt(6) + 1;
            int dado2Jugador2 = random.nextInt(6) + 1;

            // Guardamos la puntuación del jugador 2
            if (dado1Jugador2 == dado2Jugador2) {
                puntuacionJugador2[i] = (dado1Jugador2 * 10);
            } else {
                puntuacionJugador2[i] = 0;
            }
        }
        System.out.println("Puntuaciones: \n" + "Puntuaciones jugador 1: " + Arrays.toString(puntuacionJugador1) + "\nPuntuaciones jugador 2: " + Arrays.toString(puntuacionJugador2));

        // Calculamos la puntuación total de cada jugador
        int puntuacionTotalJugador1 = 0;
        for (int i = 0; i < 3; i++) {
            puntuacionTotalJugador1 += puntuacionJugador1[i];
        }

        int puntuacionTotalJugador2 = 0;
        for (int i = 0; i < 3; i++) {
            puntuacionTotalJugador2 += puntuacionJugador2[i];
        }

        // Declaramos una variable para almacenar el nombre del jugador ganador
        String ganador = "";

        // Comparamos las puntuaciones de los jugadores para determinar el ganador
        if (puntuacionTotalJugador1 > puntuacionTotalJugador2) {
            ganador = "Jugador 1";
            System.out.println("El ganador es: " + ganador + ". Puntuación: " + puntuacionTotalJugador1);
        } else if (puntuacionTotalJugador1 < puntuacionTotalJugador2) {
            ganador = "Jugador 2";
            System.out.println("El ganador es: " + ganador + ". Puntuación: " + puntuacionTotalJugador2);
        } else {
            ganador = "Empate";
            System.out.println("El ganador es: " + ganador + ". Puntuación jugador 1: " + puntuacionTotalJugador1 + "\nPuntuación jugador 2: " + puntuacionTotalJugador2);
        }

        // Imprimimos el nombre del jugador ganador
    }
}
