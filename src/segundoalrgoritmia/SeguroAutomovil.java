package segundoalrgoritmia;

import java.util.Scanner;

public class SeguroAutomovil {

    public static void main(String[] args) {
        // Declaramos las variables
        String modelo, color, categoriaEdad, categoriaExperiencia, repetir = "si";
        int edad, experiencia;
        double precioBase, precioFinal;

        Scanner in = new Scanner(System.in);
        Scanner inR = new Scanner(System.in);
        Scanner inRI = new Scanner(System.in);

        while (repetir.equals("si")) {
            // Leemos los datos del usuario
            System.out.println(
                    "Ingrese el modelo del automóvil: \nHonda Civic \nNissan Sentra \nKia Forte."
            );

            modelo = inRI.nextLine();
            // Calculamos el precio base del seguro
            if (modelo.equals("Honda Civic")
                    || modelo.equals("Nissan Sentra")
                    || modelo.equals("Kia Forte")) {
                switch (modelo) {
                    case "Honda Civic":
                        System.out.println(
                                "Ingrese el color del automóvil: \nRojo \nBlanco"
                        );
                        color = in.nextLine();
                        if (color.equalsIgnoreCase("Rojo")) {
                            precioBase = 20796;
                        } else {
                            precioBase = 15000;
                        }
                        break;
                    case "Nissan Sentra":
                        System.out.println(
                                "Ingrese el color del automóvil: \nRojo \nBlanco"
                        );
                        color = in.nextLine();
                        if (color.equalsIgnoreCase("Rojo")) {
                            precioBase = 15000;
                        } else {
                            precioBase = 10000;
                        }
                        break;
                    case "Kia Forte":
                        System.out.println(
                                "Ingrese el color del automóvil: \nRojo \nBlanco"
                        );
                        color = in.nextLine();
                        if (color.equalsIgnoreCase("Rojo")) {
                            precioBase = 15194;
                        } else {
                            precioBase = 13000;
                        }
                        break;
                    default:
                        System.out.println("Modelo no válido");
                        precioBase = 0;
                        break;
                }
                // seguimos leyendo los datos del usuario
                System.out.println("Ingrese la edad del conductor: ");
                edad = in.nextInt();
                System.out.println("Ingrese la experiencia del conductor (en años): ");
                experiencia = in.nextInt();

                // Calculamos la categoría de edad del conductor
                if (edad < 20 && edad > 18) {
                    categoriaEdad = "Menos de 20";
                } else if (edad < 30) {
                    categoriaEdad = "Entre 20 y 30";
                } else if (edad < 65) {
                    categoriaEdad = "Entre 31 y 65";
                } else {
                    categoriaEdad = "Mayor de 65";
                }

                // Calculamos el incremento del precio por la edad del conductor
                switch (categoriaEdad) {
                    case "Menos de 20":
                        precioFinal = precioBase * 1.25;
                        break;
                    case "Entre 20 y 30":
                        precioFinal = precioBase * 1.1;
                        break;
                    case "Mayor de 65":
                        precioFinal = precioBase * 1.15;
                        break;
                    default:
                        precioFinal = precioBase;
                }

                // Calculamos la categoría de experiencia del conductor
                if (experiencia < 2) {
                    categoriaExperiencia = "Menos de 2 años";
                } else {
                    categoriaExperiencia = "Más de 2 años";
                }

                // Calculamos el incremento del precio por la experiencia del conductor
                if (categoriaExperiencia.equals("Menos de 2 años")) {
                    precioFinal += precioBase * .15;
                }

                // Imprimimos el resultado
                System.out.println("El precio base del seguro es: $" + precioBase);
                System.out.println("El precio final del seguro es: $" + precioFinal);
            } else {
                System.out.println("Modelo no valido");
            }
            System.out.println("Quires repetir? si/no");
            repetir = inR.nextLine();
        }
    }
}
