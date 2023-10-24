package Segundoalrgoritmia;

import java.util.Scanner;

public class NumeroPar5 {

    public static void main(String[] args) {
        // Declaramos la variable de control tipo bandera
        boolean continuar = true;

        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);

        // Bucle while que se repetirá hasta que la variable de control sea false
        while (continuar) {
            // Leemos un número entero
            System.out.println("Ingrese un número entero: ");
            int numero = in.nextInt();

            // Verificamos si el número es cero
            if (numero == 0) {
                System.out.println("El número es cero");
            } // Verificamos si el número es positivo
            else if (numero > 0) {
                // Verificamos si el número es par
                if (numero % 2 == 0) {
                    System.out.print("El número es positivo, par");
                    if (numero % 5 == 0) {
                        System.out.println(" y múltiplo de 5");
                    } else {
                        System.out.println(" y no múltiplo de 5");
                    }
                } // Verificamos si el número es impar
                else {
                    // Verificamos si el número es múltiplo de 5
                    if (numero % 5 == 0) {
                        System.out.println("El número es positivo, impar y múltiplo de 5");
                    } else {
                        System.out.println(
                                "El número es positivo, impar y no múltiplo de 5"
                        );
                    }
                }
            } // Verificamos si el número es negativo
            else {
                System.out.println("El número es negativo");
            }

            // Preguntamos al usuario si quiere continuar
            System.out.println("¿Desea continuar? (s/n): ");
            String respuesta = inR.nextLine();

            // Si la respuesta es no, la variable de control se pone a false y el bucle se detiene
            if (respuesta.equals("n")) {
                continuar = false;
            }
        }
    }
}
