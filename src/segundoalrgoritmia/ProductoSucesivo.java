package Segundoalrgoritmia;

import java.util.Scanner;

public class ProductoSucesivo {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num, sucesivo = 1, contador = 1;
    System.out.println("Dame un número");
    num = in.nextInt();

    for (num = num; num >= 2; num--) {
      sucesivo = sucesivo * num;
      contador = num - 1;
      System.out.println(sucesivo + "*" + contador);
    }
    System.out.println("El factorial es: " + sucesivo);
  }
}
