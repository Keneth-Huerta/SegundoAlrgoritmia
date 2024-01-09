package Segundoalrgoritmia;

import java.util.Scanner;

public class SerieNumeros {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Solicitamos los dos primeros números de la serie
    System.out.print("Ingrese el primer número: ");
    int numero1 = scanner.nextInt();
    System.out.print("Ingrese el segundo número: ");
    int numero2 = scanner.nextInt();

    // Solicitamos la cantidad de elementos de la serie
    System.out.print("Ingrese la cantidad de elementos de la serie: ");
    int cantidad = scanner.nextInt();

    // Creamos un arreglo para almacenar la serie
    int[] serie = new int[cantidad];

    // Generamos la serie
    serie[0] = numero1;
    serie[1] = numero2;
    for (int i = 2; i < cantidad; i++) {
      serie[i] = serie[i - 1] + serie[i - 2];
    }

    // Imprimimos la serie
    for (int i = 0; i < cantidad; i++) {
      System.out.print(serie[i]);
      if (i != cantidad - 1) {
        System.out.print(", ");
      }
    }
        System.out.println("");
  }
}
