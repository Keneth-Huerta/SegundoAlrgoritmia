package segundoalrgoritmia;


public class FrecuenciaNumerosAleatorios {

    public static void main(String[] args) {
        // Crea un arreglo de 100 números aleatorios entre 1 y 10
        int[] numerosAleatorios = new int[100];
        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = (int) (Math.random() * 10) + 1;
        }

        // Inicializa un arreglo de 10 posiciones para almacenar las frecuencias
        int[] frecuencias = new int[10];

        // Recorre el arreglo de números aleatorios
        for (int numero : numerosAleatorios) {
            // Incrementa la frecuencia del número en el arreglo de frecuencias
            frecuencias[numero - 1]++;
        }

        // Imprime las frecuencias
        for (int i = 0; i < frecuencias.length; i++) {
            System.out.println("La frecuencia del número " + (i + 1) + " es " + frecuencias[i]);
        }
    }
}