package Segundoalrgoritmia;

import java.util.Scanner;

public class Binario {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int numero, residuo, exp = 0;
        int[] binario = new int[32];

        System.out.print("Ingrese un número decimal: ");
        numero = obj.nextInt();

        while (numero != 0) {
            residuo = numero % 2;
            binario[exp] = residuo;
            exp++;
            numero /= 2;
        }

        System.out.print("El número binario es: ");
        for (int i = exp - 1; i >= 0; i--) {
            System.out.print(binario[i]);
        }
        System.out.println(""
                + "");
    }
}