import java.util.Random;

public class SumaMatrices {

    public static void main(String[] args) {

        // Declaramos las matrices A y B
        int[][] A = new int[3][3];
        int[][] B = new int[3][3];

        // Generamos números aleatorios para las matrices A y B
        Random rand = new Random();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = rand.nextInt(100);
                B[i][j] = rand.nextInt(100);
            }
        }

        // Declaramos la matriz C
        int[][] C = new int[3][3];

        // Calculamos la suma de los elementos correspondientes de las matrices A y B
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // Imprimimos las matrices A, B y C
        System.out.println("Matriz A:");
        for (int[] row : A) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("Matriz B:");
        for (int[] row : B) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("Matriz C:");
        for (int[] row : C) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
