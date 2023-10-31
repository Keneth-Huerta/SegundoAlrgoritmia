package Segundoalrgoritmia;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        String repetir = "s";
        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);

        while (repetir.equalsIgnoreCase("s")) {

            System.out.println("Que numero le quieres aplicar el factorial?");
            int factorial = in.nextInt();
            long factoriales = factorial;

            for (int i = 1; i < factorial; i++) {

                factoriales *= i;
                System.out.println("Resultado: " + factoriales);
            }
            System.out.println("Quieres repetir? s/n");
            repetir=inR.nextLine();
        }
    }
}
