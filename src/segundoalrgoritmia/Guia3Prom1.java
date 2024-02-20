package Segundoalrgoritmia;
import java.util.Scanner;
public class Guia3Prom1 {
    public static void main(String[] args) {
        Scanner in= new Scanner (System.in);
        int [] aleatoreo = new int[20] ,  num = new int[20] ;
        int [] aux = new int[20];
        System.out.println("El arreglo aleatoreo es:");
        for (int i = 0; i < 20; i++) {
             num [i] = (int)(Math.random()*(99-0));
             aleatoreo[i] = num[i];
             System.out.print(aleatoreo[i]+"-");
        }
        System.out.println("");
        for (int i = 0; i < 20-1; i++) {
            for (int j = 0; j < 20-1; j++) {
               if(aleatoreo[j]>aleatoreo[j+1]){
                   aux [j]= aleatoreo [j];
                   aleatoreo[j]=aleatoreo[j+1];
                   aleatoreo[j+1]=aux[j];
                } 
            }
        }
         System.out.println("Y el arreglo ordenado es: ");
         for (int i = 0; i < 20; i++) {
            System.out.print(aleatoreo[i]+"-");   
    }  
}
} 
