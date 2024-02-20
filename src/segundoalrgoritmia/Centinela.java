package Segundoalrgoritmia;

import java.util.Scanner;

public class Centinela {

    public static void main(String[] args) {

        int numero;
        String repetir = "";

        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);

        while (!repetir.equals("*")) {

            System.out.println("Escribe un número entero");
            numero = in.nextInt();
            System.out.println("Quieres salir? '*' ");
            repetir = inR.nextLine();
        }

    }
}
