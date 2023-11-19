import java.util.Scanner;

public class Pruebaserie2 {

  public static void main(String[] args) {
    int vi, vf, inc, contador = 0;

    System.out.println("Ingresa el valor inicial");
    Scanner leeV = new Scanner(System.in);
    vi = leeV.nextInt();

    System.out.println("Ingresa el valor final");
    Scanner leeF = new Scanner(System.in);
    vf = leeF.nextInt();

    System.out.println("Ingresa el incremento");
    Scanner leeC = new Scanner(System.in);
    inc = leeC.nextInt();

    System.out.println("La serie generada es: ");
    for (int i = vi; i <= vf; i += inc) {
      System.out.println("" + i);
      contador++;
    }
    int numeros[5]=new int[];

    System.out.println("El número de elementos de la serie es: " + contador);
  }
}
