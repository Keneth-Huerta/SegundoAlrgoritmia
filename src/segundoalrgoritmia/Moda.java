package segundoalrgoritmia;

import java.util.Arrays;
import java.util.Scanner;

public class Moda {

    public static void main(String[] args) {

        // Declaramos un arreglo de tamaño n
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] arreglo = new int[n];

        // Leemos los datos del arreglo
        for (int i = 0; i < n; i++) {
            arreglo[i] = (int) (Math.random() * 10) + 1;
        }
        System.out.println("el arreglo es: " + Arrays.toString(arreglo));

        // Calculamos la moda
        int moda = 0;
        int frecuencia = 0;
        for (int i = 0; i < n; i++) {
            int contador = 0;
            for (int j = 0; j < n; j++) {
                if (arreglo[i] == arreglo[j]) {
                    contador++;
                }
            }
            if (contador > frecuencia) {
                moda = arreglo[i];
                frecuencia = contador;
            }
        }

        // Imprimimos el resultado
        System.out.println("La moda es: " + moda + ", que se repite: " + frecuencia + " veces");
    }
}
