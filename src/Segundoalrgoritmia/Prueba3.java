
package Segundoalrgoritmia;
import java.util.Scanner;
public class Prueba3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, fact=1;
        System.out.println("Que número quieres que saque el factorial");
        num=in.nextInt();
        for(int i=0; i<=num ;i++){
            
            fact=fact*num;
            num=num-1;
            System.out.println("Los factoriales son: "+fact);
        }
            System.out.println("Los factoriales son: "+fact);
        
    }
}
