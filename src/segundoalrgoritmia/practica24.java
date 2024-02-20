/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Segundoalrgoritmia;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class practica24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero = 0;
        System.out.println("Escribe un numero");
        numero = leer.nextInt();
        if (numero >= 1 && numero <= 12)  {
            switch (numero)  {
                case 1:
                    System.out.println("ENERO");
                    break;
                    case 2:
                        System.out.println("FEBRERO");
                        break;
                        
                        default:
                            System.out.println("EL NUMERO INTRODUCIDO NO EXISTE");
            }
        }
    }
    
}
