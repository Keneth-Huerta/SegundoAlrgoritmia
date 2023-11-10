
package Segundoalrgoritmia;
import java.util.Scanner;
public class Papelerialuisito {
    public static void main(String[] args) {
        int la, go, cua, cla, cgo, ccua, mt;
        Scanner in = new Scanner (System.in);
        System.out.print("Cuantos lapices compraste");
        la = in.nextInt();
        System.out.print("Cuantas gomas compraste");
        go = in.nextInt();
        System.out.print("Cuantos cuadernos compraste");
        cua = in.nextInt();
        cla = la*10;
        cgo = go*16;
        ccua = cua*30;
        mt = cla + cgo + ccua;
        if (mt >100){
            double tb = mt * 0.95;
            System.out.print("Si se aplica descuento y el total a pagar es:  " + tb);
        }
        else {
            System.out.print("No se aplica descuento y el total a pagar es:" + mt);
        }
    }
    
}
