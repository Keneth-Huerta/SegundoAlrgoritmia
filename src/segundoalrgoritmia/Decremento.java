package Segundoalrgoritmia;
import java.util.Scanner;
public class Decremento {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int vi, vf, inc=5;
        System.out.println("Dame el valor inicial");
        vi= in.nextInt();
        System.out.println("Dame el valor final");
        vf= in.nextInt();
        System.out.println("El decremento es de "+inc);
        System.out.println("La serie generada es:");
        for (int i = vi; vi >=vf; vi=vi-=inc) {
            System.out.println(""+vi);
        }
    }
}
