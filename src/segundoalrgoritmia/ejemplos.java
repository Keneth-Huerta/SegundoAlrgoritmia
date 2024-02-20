package segundoalrgoritmia;

public class ejemplos {

    public static void main(String[] args) {

        String tabla[][] = new String[4][4];

        tabla[0][0] = "s0";
        tabla[0][1] = "s1";
        tabla[0][2] = "s2";
        tabla[0][3] = "s3";

        for (int i = 1; i < tabla.length; i++) {

            for (int j = 0; j < tabla.length; j++) {

                tabla[i][j] = Integer.toString(j) + " ";
            }
        }
        for (int i = 0; i < tabla.length; i++) {

            for (int j = 0; j < tabla.length; j++) {

                System.out.print(tabla[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
