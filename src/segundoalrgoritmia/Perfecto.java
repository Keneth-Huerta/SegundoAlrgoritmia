package segundoalrgoritmia;

import java.util.Scanner;

public class Perfecto {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese un número entero positivo: ");
    int numero = scanner.nextInt();

    if (numero <= 0) {
      System.out.println("El número debe ser mayor que 0");
    } else {
      int sumaDivisores = 1;
      for (int i = 2; i < numero; i++) {
        if (numero % i == 0) {
          sumaDivisores += i;
        }
      }

      if (sumaDivisores == numero) {
        System.out.println("El número " + numero + " es perfecto");
      } else {
        System.out.println("El número " + numero + " no es perfecto");
      }
    }
  }
}
