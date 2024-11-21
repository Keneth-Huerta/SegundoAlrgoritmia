
package servidorconvertor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidoor {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(8190
            );
            Socket sc = server.accept();
            InputStream in = sc.getInputStream();
            OutputStream out = sc.getOutputStream();
            Scanner scan = new Scanner(in);
            PrintWriter pw = new PrintWriter(out, true);
            pw.println("Bienvenidooo");
            int num1;
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                System.out.println("Cliente: " + s);

                if (s.contains("hexa")) {
                    String[] arr = s.split(" ");
                    num1 = Integer.parseInt(arr[1]);
                    pw.println(Hexa(num1));
                }
                if (s.contains("binario")) {
                    String[] arr = s.split(" ");
                    num1 = Integer.parseInt(arr[1]);
                    pw.println(Binario(num1));
                }
                if (s.trim().equalsIgnoreCase("Salir")) {
                    pw.println("Conexión finalizada");
                    break;
                }

            }

            sc.close();
            scan.close();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String Binario(int num) {

        String numBin = "";
        int resto = 0;
        while (num > 0) {
            resto = num % 2;
            numBin = resto + numBin;
            num = num / 2;
        }
        return numBin;

    }
public static String Hexa(int deci) {
      
        String numHexa = "";           
        String binarioNumero = "";     
        int resto = 0;                

       
        String hexa = "0123456789ABCDEF";

        if (deci == 0) {
            return "0";
        }

        while (deci > 0) {
            resto = deci % 16;             
            numHexa = hexa.charAt(resto) + numHexa; 
            deci /= 16;                   
        }

        return numHexa; 
    }

}
