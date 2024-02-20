package segundoalrgoritmia;

import java.util.Scanner;

public class Exponentes {

    public static void main(String[] args) {
        int base, exponente, exponente1;
        double raiz, resultado, elevar;
        String repetir;

        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);

        repetir = "si";
        while (repetir.equalsIgnoreCase("si")) {
            System.out.println("Que quieres hacer:  \n1: multiplicación de exponentes " + "\n2: raiz cuadrada  "
                    + "\n3: Determinar si dado tres númneros: la suma de dos los dos primeros rsultan igual al tercero, de lo contrariodeterminar la suma de los tres números.  para cada opción identificar si la suma es para o impar \n4: salir");
            int opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Cuál es la base?");
                    base = in.nextInt();
                    System.out.println("Cual es el exponente 1");
                    exponente = in.nextInt();
                    System.out.println("Cual es el exponente 2");
                    exponente1 = in.nextInt();
                    resultado = Math.pow(base, exponente) * Math.pow(base, exponente1);
                    System.out.println("La suma de los exponentes con la misma base de: " + exponente + " y " + exponente1 + " con la base de: " + base + " es: " + resultado);
                    System.out.println("Quieres repetir?");
                    repetir = inR.nextLine();

                    break;
                case 2:
                    System.out.println("Cuál es el radicando o base?");
                    base = in.nextInt();
                    raiz = Math.sqrt(base);
                    elevar = Math.pow(raiz, 2);
                    System.out.println("La raiz cuadrada de " + base + " es: " + raiz + " y el cuadrado del número es: " + elevar);
                    System.out.println("Quieres repetir?");
                    repetir = inR.nextLine();

                    break;
                case 3:
                    System.out.println("Dame tres números");
                    int n1 = in.nextInt();
                    int n2 = in.nextInt();
                    int n3 = in.nextInt();
                    if (n1 + n2 == n3) {
                        System.out.println("La suma de los dos primeros es igual al tercero");
                    } else {
                        int sumaN = n1 + n2 + n3;
                        System.out.println("La suma de los tres números es: " + sumaN);
                    }
                    if ((n1 + n2 + n3) % 2 == 0) {
                        System.out.println("La suma es par");
                    } else {
                        System.out.println("La suma es impar");
                    }
                    System.out.println("Quieres repetir?");
                    repetir = inR.nextLine();
                    break;
                case 4:

                    System.out.println("Salir");
                    repetir = "no";
                    break;
                default:
                    System.out.println("La elección no es valida");

            }

        }

    }
}
