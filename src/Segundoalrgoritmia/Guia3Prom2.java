package Segundoalrgoritmia;
import java.util.Scanner;
public class Guia3Prom2 {
    public static void main(String[] args) {
            Scanner in = new Scanner (System.in);
    int [] aleatoreo = new int[50], num = new int[50], pares= new int[50] ;
    int acumulador=0, contador=0;
    System.out.println("El arreglo aleatoreo es:");
     for (int i = 0; i < 50; i++) {
             num [i] = (int)(Math.random()*(99-0));
             aleatoreo[i] = num[i];
             System.out.print(aleatoreo[i]+"-");
             if(aleatoreo[i]%2==0){
                 contador++;
                 pares[i]=aleatoreo[i];  
             }
        }
     System.out.println("");
        for (int i = 0; i < 50-1; i++) {
                acumulador=acumulador+aleatoreo[i];   
}    
        System.out.println("la suma de los numeros pares es:"+acumulador);
}
}



