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
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")) {

            System.out.println("Que persona vamos a buscar? ");
            String nombre = in.nextLine();
            boolean verd = false;
            for (int i = 0; i < promedios.length; i++) {

                if (nombre.equalsIgnoreCase(alumnos[i])) {
                    System.out.println("El promedio de " + alumnos[i] + " es: " + promedios[i]);
                    verd = true;
                }

            }
            if (verd == false) {
                System.out.println("la persona no existe");
            }
            System.out.println("Quieres repetir?");
            Scanner inRR = new Scanner(System.in);
            repetir = inRR.nextLine();

        }
    }
}
