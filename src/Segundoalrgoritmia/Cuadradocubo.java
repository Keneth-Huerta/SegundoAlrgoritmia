package Segundoalrgoritmia;

import java.util.Scanner;

public class Cuadradocubo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num=0, sucesivo = 0;

        for (int i = 1; i <= 10; i++) {
            sucesivo = sucesivo * Math.pow(num, 2);
        }
    }
}
