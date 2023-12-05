package Segundoalrgoritmia;

public class DosDimensiones {
    public static void main(String[] args) {
        int filas, columnas;
        String libros[][] = {
                { "Ana Karenina", "Cien Afos de Soledad", "Orgullo y Prejuicio", "Mujercitas",
                        "El diablo de los numeros" },
                { "Leon Toltoi", "Gabriel Garcia Marquez", "Jane Austen", "Louisa May Alcott", "Hans Magnus" }, };
        System.out.println("Titulo " + "\t \t" + "Autor");
        for (filas = 0; filas < 2; filas++) {
            System.out.println("");
            for (columnas = 0; columnas < 5; columnas++) {
                System.out.print(libros[filas][columnas] + "\t");
            }
            System.out.println("");

        }
    }
}