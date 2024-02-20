package segundoalrgoritmia;

import java.util.Scanner;

public class Tabla {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num[] = new int[10];
        System.out.println("Dame un número");
        int number = in.nextInt();
        for (int i = 0; i < 10; i++) {

            num[i] = number * (i + 1);
        }
        for (int i = 0; i < num.length; i++) {

            System.out.println(number + " X " + (i + 1) + " =" + num[i]);
        }
    }
}
