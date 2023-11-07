package Segundoalrgoritmia;

import java.util.Scanner;

public class NombresArreglo {

    public static void main(String[] args) {
        String[] nombres = new String[5];
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < nombres.length; i++) {
            System.out.print(i + 1 + ".-");
            nombres[i] = in.nextLine();
            
        }
    }
}
