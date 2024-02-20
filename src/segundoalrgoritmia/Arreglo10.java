package Segundoalrgoritmia;
import java.util.Scanner;
public class Arreglo10 {
    public static void main(String[] args) {
        // Declaramos el arreglo
        int[] arreglo = new int[10];

        // Ingresamos los números al arreglo
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            arreglo[i] = sc.nextInt();
        }

        // Imprimimos los números del arreglo
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }
}