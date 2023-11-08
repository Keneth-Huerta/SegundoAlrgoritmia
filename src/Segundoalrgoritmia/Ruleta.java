package Segundoalrgoritmia;

import java.util.Random;

public class Ruleta {

  public static void main(String[] args) {
    // Variables
    int minimo = 0;
    int maximo = 38;
    int numero;
    int contadorPares = 0;
    int contadorImpares = 0;

    // Bucle para generar números aleatorios
    for (int i = 0; i < maximo; i++) {
      numero = new Random().nextInt(maximo + 1);

      // Contador de números pares
      if (numero % 2 == 0) {
        contadorPares++;
      }
      // Contador de números impares
      else {
        contadorImpares++;
      }

      // Finalización del proceso
      if (numero == 0) {
        break;
      }
    }

    // Salida
    System.out.println("Número de números pares: " + contadorPares);
    System.out.println("Número de números impares: " + contadorImpares);
  }
}
