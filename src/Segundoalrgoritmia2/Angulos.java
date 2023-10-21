package Segundoalrgoritmia2;

import java.util.Scanner;

public class Angulos {

    public static void main(String[] args) {

        int angulo;
        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);

        String repetir = "si";
        while (repetir.equalsIgnoreCase("si")) {
        System.out.println("Dame un angulo");
        angulo = in.nextInt();

            if (angulo < 90 && angulo > 0) {

                System.out.println("Es un ángulo agudo");
            } else if (angulo == 90) {

                System.out.println("Es un ángulo recto");
            } else {

                System.out.println("Es un ángulo obtuso");
            }
            System.out.println("Quieres repetir el programa si / no");
            repetir = inR.nextLine();
        }

    }

}
