package segundoalrgoritmia;
import java.util.Scanner;
public class AleatoreoUsuario {
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int x, contador1=0, contador2=0, num1, num2;
         System.out.println("Cual es el numero inical del rango");
         num1= in.nextInt();
         System.out.println("Cual es el numero final del rango");
         num2= in.nextInt();
        for (int i = 0; i < 10; i++) {
            x= (int) (Math.random()*(num2+num1));
            if(x%7==0){
            System.out.println(""+x);
                contador1++;
        }else{
            }
            }
                System.out.println("Ningun numero es divicible entre 7");
                System.out.println("el numero de terminos divicibles entre 7 es "+contador1++);
            }
    }



