package Segundoalrgoritmia;

import java.util.Random;
import java.util.Scanner;

public class DescuentoSupermercado {

    public static void main(String[] args) {
        // Declaramos las variables
        int importeCompra, numeroAleatorio;
        String colorPelota, repetir = "si";
        double descuento;
        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);
        while (repetir.equalsIgnoreCase("si")) {
            // Leemos el importe de la compra
            System.out.println("Ingrese el importe de la compra: ");
            importeCompra = in.nextInt();
            // Generamos cuatro números aleatorios
            Random random = new Random();
            numeroAleatorio = random.nextInt(4) + 1;
            // Asignamos el color de la pelota a partir del número aleatorio
            switch (numeroAleatorio) {
                case 1:
                    colorPelota = "verde";
                    break;
                case 2:
                    colorPelota = "amarilla";
                    break;
                case 3:
                    colorPelota = "negra";
                    break;
                default:
                    colorPelota = "blanca";
                    break;
            }
            // Calculamos el descuento
            if (colorPelota.equalsIgnoreCase("verde")) {
                descuento = importeCompra * 0.2;
            } else if (colorPelota.equalsIgnoreCase("amarilla")) {
                descuento = importeCompra * 0.25;
            } else if (colorPelota.equalsIgnoreCase("negra")) {
                descuento = importeCompra * 0.3;
            } else {
                descuento = 0;
            }
            // Calculamos el monto a pagar
            double montoPagar = importeCompra - descuento;
            // Imprimimos el resultado
            System.out.println("El importe de la compra es: " + importeCompra);
            System.out.println("El color de la pelota es: " + colorPelota);
            System.out.println("El descuento es: " + descuento);
            System.out.println("El monto a pagar es: " + montoPagar);
            System.out.println("Quieres repetir la acción si/no");
            repetir = inR.nextLine();
        }
    }
}
