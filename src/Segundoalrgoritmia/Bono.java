package Segundoalrgoritmia;

import java.util.Scanner;

public class Bono {

    public static void main(String[] args) {
        int s, h;
        String repetir = "si";

        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);

        while (repetir.equalsIgnoreCase("si")) {
            System.out.println("Ingresa las horas que laboras");
            h = in.nextInt();
            System.out.println("Cual es tu salario");
            s = in.nextInt();
            if (h >= 45) {
                System.out.println("Se proporcionara un bono extra de 15%");
                double sn = h * (s + (s * 0.15));
                System.out.println("Y tu salario sera de  $" + sn);
            } else if (h >= 30 && h <= 44) {
                System.out.println("Se proporconara un bono extra de 8%");
                double sn = h * (s + (s * 0.08));
                System.out.println("Y tu salario sera de  $" + sn);
            } else {
                System.out.println("No se proporcionara un bono extra");
                System.out.println("Y tu salario sera de   $" + s * h);
            }
            System.out.println("Quieres repetir? (si/no)");
            repetir = inR.nextLine();
        }
    }
}
