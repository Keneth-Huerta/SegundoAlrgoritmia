package segundoalrgoritmia;

import java.util.Scanner;

public class MatrizMuestra {
    public static void main(String[] args) {
        int fila, columna;
        Scanner lee = new Scanner(System.in);
        System.out.println("Numero de filas");
        fila = lee.nextInt();
        columna = fila;
        int matriz[][] = new int[fila][columna];
        for (int f = 0; f < fila; f++) {
            for (int c = 0; c < columna; c++) {
                matriz[f][c] = (int) (Math.random() * (100 - 10 + 1) + 10);
            }
        }
        System.out.println("Los numeros almacenados en la matriz son: ");
        for (int f = 0; f < fila; f++) {
            for (int c = 0; c < columna; c++) {
                System.out.print("[" + f + ", " + c + "]" + "= " + matriz[f][c] + " ");
            }
            System.out.println("");
        }
    }
}