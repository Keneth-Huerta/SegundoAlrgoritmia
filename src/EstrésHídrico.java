
import java.util.Scanner;

public class EstrésHídrico {

    public static void main(String[] args) {
        // Declarar los arreglos
        String[] estados = {"Tlaxcala", "Ciudad de México", "Estado de México", "Aguascalientes", "Querétaro"};
        double[] estrésHídrico = {0.0, 0.17, 0.77, 0.18, 0.98};

        // Inicializar el contador
        int contador = 0;

        // Mostrar el menú
        System.out.println("Riesgo de Inundación fluvial");
        System.out.println("1.- Rango bajo");
        System.out.println("2.- Rango medio bajo");
        System.out.println("3.- Rango medio alto");
        System.out.println("4.- Riesgo alto");
        System.out.println("5.- Riesgo extremadamente alto");
        System.out.println("Seleccione una opción");

        // Leer la opción del usuario
        Scanner scanner = new Scanner(System.in);
        int opción = scanner.nextInt();

        // Ordenar los datos
        ordenar(estrésHídrico);

        // Mostrar los datos
        for (int i = 0; i < estrésHídrico.length; i++) {
            if (estrésHídrico[i] <= rango(opción)) {
                contador++;
                System.out.println(estados[i] + " - " + estrésHídrico[i]);
            }
        }

        // Mostrar el total de estados
        System.out.println("En México hay " + contador + " estados en riesgo " + rango(opción) + " de inundación fluvial");
    }

    // Método para ordenar los datos con el método de la burbuja
    public static void ordenar(double[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    double temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    // Método para calcular el rango de estrés hídrico
    public static double rango(int opción) {
        switch (opción) {
            case 1:
                return 0.0;
            case 2:
                return 0.25;
            case 3:
                return 0.50;
            case 4:
                return 0.75;
            case 5:
                return 1.0;
            default:
                return -1.0;
        }
    }
}
