package segundoalrgoritmia;

import java.util.Scanner;

public class Pruebas {

  public static void main(String[] args) {
    String frase;
    Scanner leeF = new Scanner(System.in);

    System.out.println("Ingresa 4 tipos de datos primitivos en Java");
    for (int contador = 1; contador <= 4; contador += 1) {
      System.out.println("Tipo " + contador);
      frase = leeF.nextLine();
    }
  }
}
