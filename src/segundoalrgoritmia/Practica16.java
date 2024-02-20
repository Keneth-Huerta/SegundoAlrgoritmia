package segundoalrgoritmia;

import java.util.Scanner;

public class Practica16 {

  public static void main(String[] args) {
    int a = 8, b = 6;
    double x = 0;
    String repetir;
    repetir = "si";
    Scanner in = new Scanner(System.in);
    Scanner inR = new Scanner(System.in);
    while (repetir.equalsIgnoreCase("si")) {
      x = Math.pow(Math.pow(a, 2) + Math.pow(b, 2), 2);
      System.out.println(
        x +
        "=x=(((" +
        a +
        "*" +
        a +
        ")+(" +
        b +
        "*" +
        b +
        ")))*(((" +
        a +
        "*" +
        a +
        ")+(" +
        b +
        "*" +
        b +
        ")))"
      );
      System.out.println("Quieres repetir esta acción si/no");
      repetir = inR.nextLine();
    }
  }
}
