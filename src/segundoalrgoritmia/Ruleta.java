package Segundoalrgoritmia;
public class Ruleta {
    public static void main(String[] args) {
        int x, contador1=0, contador2=0;
        for (int i = 0; i < 10; i++) {
            x= (int) (Math.random()*(38+1));
            System.out.println(""+x);
            if(x==0){
                break;}
            else if(x%2==0){
                contador1++;
            }else{
                contador2++;
        }
            }
                System.out.println("el numero de pares es "+contador1++);
                System.out.println("el numero de impares es "+contador2++);
            }
    }

