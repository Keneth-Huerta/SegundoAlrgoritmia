package segundoalrgoritmia;

import java.util.Scanner;

public class Trianguloe {

    public static void main(String[] args) {
        int l1, l2, l3;
        String repetir = "si";
        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);
        while (repetir.equalsIgnoreCase("si")) {
            System.out.print("Dame el lado 1");
            l1 = in.nextInt();
            System.out.print("Dame el lado 2");
            l2 = in.nextInt();
            System.out.print("Dame el lado 3");
            l3 = in.nextInt();
            if (l1 == l2 && l2 == l3 && l1 == l3) {
                System.out.print("Es un triangulo equilatero");
            } else if ((l1 == l2 && l2 != l3 && l1 != l3) || (l1 == l3 && l3 != l2 && l1 != l2)
                    || (l2 == l3 && l2 != l1 && l3 != l1)) {
                System.out.println("Es un triangulo isoceles");
            } else {
                System.out.println("Es un triangulo escaleno");
            }
            System.out.println("Quieres repetir? si/no");
            repetir = inR.nextLine();
        }
    }
}
