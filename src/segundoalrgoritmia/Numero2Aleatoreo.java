package segundoalrgoritmia;
import java.util.Scanner;
public class Numero2Aleatoreo {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int num1, num2, operacion, result;
        for (int i = 0; i <=10; i++) {
            num1= (int)(Math.random()*(99-0));
            num2= (int)(Math.random()*(99-0));
            System.out.println("Los numeros aleatoreos son: ");
            System.out.println(""+num1);
            System.out.println(""+num2);
            System.out.println("Que opción deceas realizar");
            System.out.println("Suma=1, Resta=2, Producto=3");
            operacion= in.nextInt();
            switch(operacion){
                case 1:
               result=num1+num2;
            System.out.println("El resultado de la suma es: "+result);
            if(result==result){
                System.out.println("Felicitaciones");
            }else{
                System.out.println("Respuesta incorrecta y la corecta es:"+ result);
            }
            break;
                case 2:
                    result=num1-num2;
            System.out.println("El resultado de la resta es: "+result);
            if(result==result){
                System.out.println("Felicitaciones");
            }else{
                System.out.println("Respuesta incorrecta y la corecta es:"+ result);
            }
            break;
                case 3:
                    result=num1*num2;
            System.out.println("El resultado de lamultiplicación es: "+result);
            if(result==result){
                System.out.println("Felicitaciones");
            }else{
                System.out.println("Respuesta incorrecta y la corecta es:"+ result);
            }
            break;
                default:
                    System.out.println("No existe esa respuesta");
        }
        }  
    }
}

