package segundoalrgoritmia;

import java.util.Scanner;

public class MesDelAño {

  public static void main(String[] args) {
    // Declaramos las variables
    int diasTranscurridos;
    String mes, repetir = "si";

    Scanner in = new Scanner(System.in);
    Scanner inR = new Scanner(System.in);

    while (repetir.equalsIgnoreCase("si")) {
      // Leemos los datos del usuario
      System.out.println("Ingrese el número de días transcurridos del año: ");
      diasTranscurridos = in.nextInt();

      // Calculamos el mes
      if (diasTranscurridos <= 31) {
        mes = "Enero";
      } else if (diasTranscurridos <= 59) {
        mes = "Febrero";
      } else if (diasTranscurridos <= 90) {
        mes = "Marzo";
      } else if (diasTranscurridos <= 120) {
        mes = "Abril";
      } else if (diasTranscurridos <= 151) {
        mes = "Mayo";
      } else if (diasTranscurridos <= 181) {
        mes = "Junio";
      } else if (diasTranscurridos <= 212) {
        mes = "Julio";
      } else if (diasTranscurridos <= 243) {
        mes = "Agosto";
      } else if (diasTranscurridos <= 273) {
        mes = "Septiembre";
      } else if (diasTranscurridos <= 304) {
        mes = "Octubre";
      } else if (diasTranscurridos <= 334) {
        mes = "Noviembre";
      } else {
        mes = "Diciembre";
      }

      // Imprimimos el resultado
      System.out.println("El mes correspondiente es: " + mes);
      System.out.println("Quieres repetir? si/no");
      repetir = inR.nextLine();
    }
  }
}
