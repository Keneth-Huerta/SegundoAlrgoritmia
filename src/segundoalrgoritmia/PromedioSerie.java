import java.util.Scanner;

public class PromedioSerie {

    public static void main(String[] args) {

        // Declarar variables
        int valorInicial, valorFinal, i, suma = 0;
        float promedio;

        // Solicitar los valores inicial y final
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el valor inicial: ");
        valorInicial = sc.nextInt();
        System.out.print("Ingrese el valor final: ");
        valorFinal = sc.nextInt();

        // Declarar el arreglo
        int[] serie = new int[valorFinal - valorInicial + 1];

        // Inicializar el arreglo
        for (i = 0; i < serie.length; i++) {
            serie[i] = valorInicial + i;
        }

        // Calcular la suma de la serie
        for (i = 0; i < serie.length; i++) {
            suma += serie[i];
        }

        // Calcular el promedio
        promedio = (float) suma / serie.length;

        // Mostrar el promedio
        System.out.println("El promedio de la serie es: " + promedio);
    }
}
