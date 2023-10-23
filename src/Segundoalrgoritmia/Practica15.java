package Segundoalrgoritmia;
import java.util.Scanner;
public class Practica15 {
    public static void main(String[] args) {
        int a=2,b=4,c=8, x=0;
        String repetir;
        Scanner in = new Scanner (System.in);
        Scanner inR = new Scanner (System.in);
        repetir="si";
        while (repetir.equalsIgnoreCase("si")){
        x=(a*b)+((a*a)+c);
        System.out.println(x+"=x=("+a+"*"+b+")+(("+a+"*"+a+")+"+c+")");
            System.out.println("Quieres repetir la acción si/no");
            repetir= inR.nextLine();
        
    }
    
}
}
