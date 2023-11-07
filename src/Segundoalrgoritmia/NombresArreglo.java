package Segundoalrgoritmia;

import java.util.Scanner;

public class NombresArreglo {

    public static void main(String[] args) {
        String[] alumnos = new String[5];
        float[] promedios = new float[5];
        float promedio = 0;
        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1 + ".-");
            alumnos[i] = in.nextLine();
            System.out.print("promedio: ");
            promedios[i] = inR.nextFloat();

        }
        for (int i = 0; i < 5; i++) {
            promedio += promedios[i];
        }
        promedio /= promedios.length;
        System.out.println("\nel promedio es: " + promedio);
    }
}
