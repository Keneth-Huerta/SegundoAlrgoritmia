
import java.util.Random;
import java.util.Scanner;

public class SumaDeFracciones {

    public static void main(String[] args) {
        // Variables
        int respuestasCorrectas = 0;
        int respuestasIncorrectas = 0;
        
        Random random = new Random();
        Scanner in = new Scanner(System.in);

        // Bucle principal
        for (int i = 0; i < 10; i++) {
            // Generar dos fracciones aleatorias
            int numerador1 = random.nextInt(100);
            int denominador1 = random.nextInt(100);
            int numerador2 = random.nextInt(100);
            int denominador2 = random.nextInt(100);

            // Mostrar las fracciones
            System.out.println("Fracción 1: " + numerador1 + "/" + denominador1);
            System.out.println("Fracción 2: " + numerador2 + "/" + denominador2);

            // Obtener la respuesta del usuario
            System.out.println("Suma: ");
            String respuestaUsuario = in.nextLine();

            // Obtener la respuesta correcta
            int numeradorResultado = numerador1 * denominador2 + numerador2 * denominador1;
            int denominadorResultado = denominador1 * denominador2;
            int a = numeradorResultado, b = denominadorResultado;
            while (b != 0) {
                int aux = a;
                a = b;
                b = aux % b;
            }
            numeradorResultado /= a;
            denominadorResultado /= a;

            String respuestaCorrecta = numeradorResultado + "/" + denominadorResultado;

            // Comparar las respuestas
            if (respuestaCorrecta.equals(respuestaUsuario)) {
                respuestasCorrectas++;
            } else if (respuestaUsuario.equalsIgnoreCase("Terminar")) {
                break;
            } else {
                respuestasIncorrectas++;
                System.out.println("Respuesta incorrecta. La respuesta correcta es: " + respuestaCorrecta);
            }
        }

        // Mostrar los resultados
        System.out.println("Respuestas correctas: " + respuestasCorrectas);
        System.out.println("Respuestas incorrectas: " + respuestasIncorrectas);
    }
}
