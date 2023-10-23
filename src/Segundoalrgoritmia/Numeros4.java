package Segundoalrgoritmia;
import java.util.Scanner;
public class Numeros4 {
    public static void main(String[] args) {
        int n1, n2, n3, n4, nma, nme, neto;
        String repetir ;
        repetir= "si";
        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);
        while (repetir.equalsIgnoreCase("si")) {
            System.out.println("Dame el número uno");
            n1 = in.nextInt();
            System.out.println("Dame el número dos");
            n2 = in.nextInt();
            System.out.println("Dame el número tres");
            n3 = in.nextInt();
            System.out.println("Dame el número cuatro");
            n4 = in.nextInt();
            if ((n1 > n2) && (n1 > n3) && (n1 > n4)) {
                System.out.println("El mayor es " + n1);
                nma = n1;
            } else if ((n2 > n3) && (n2 > n4)) {
                System.out.println("El mayor es " + n2);
                nma = n2;
            } else if (n3 > n4) {
                System.out.println("El mayor es " + n3);
                nma = n3;
            } else {
                System.out.println("El mayor es " + n4);
                nma = n4;
            }
            if ((n1 < n2) && (n1 < n3) && (n1 < n4)) {
                System.out.println("El menor es " + n1);
                nme = n1;
            } else if ((n2 < n3) && (n2 < n4)) {
                System.out.println("El menor es " + n2);
                nme = n2;
            } else if (n3 < n4) {
                System.out.println("El menor es " + n3);
                nme = n3;
            } else {
                System.out.println("El menor es " + n4);
                nme = n4;
            }
            neto = (nma + nme);
            System.out.println("Y la suma de ambos es " + neto);
            System.out.println("Quieres repetir? si/no");
        repetir=inR.nextLine();
        }
        
    }
}
