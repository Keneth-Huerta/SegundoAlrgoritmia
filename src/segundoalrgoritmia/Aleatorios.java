package segundoalrgoritmia;

import java.util.Scanner;

public class Aleatorios {

    public static void main(String[] args) {

        int numero;
        String repetir;
        repetir = "si";
        Scanner in = new Scanner(System.in);
        while (repetir.equalsIgnoreCase("si")) {
            numero = (int) (Math.random() * (45 - 1 + 2) + 1);
            System.out.println(" " + numero);
            System.out.println("Otro numero si / no");
            repetir = in.nextLine();
            //   repetir = repetir.toLowerCase();
        }
    }
}
