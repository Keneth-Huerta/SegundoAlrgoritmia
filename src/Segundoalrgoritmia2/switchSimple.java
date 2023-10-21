package Segundoalrgoritmia2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class switchSimple {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);

        String repetir = "si";
        while (repetir.equalsIgnoreCase("si")) {

            System.out.println("Dame el número correspondiente al dÃ­a de la semana");
            int dia = in.nextInt();

            switch (dia) {
                case 1:

                    System.out.println("Domingo");
                    break;
                case 2:

                    System.out.println("Lunes");
                    break;
                case 3:

                    System.out.println("Martes");
                    break;
                case 4:

                    System.out.println("Miercoles");
                    break;
                case 5:

                    System.out.println("Jueves");
                    break;
                case 6:

                    System.out.println("Viernes");
                    break;
                case 7:

                    System.out.println("Sabado");
                    break;
                default:
                    System.out.println("El día de la semana no existe");
            }
            System.out.println("Deseas ingresar otro día");
            repetir = inR.nextLine();
        }
    }
}
