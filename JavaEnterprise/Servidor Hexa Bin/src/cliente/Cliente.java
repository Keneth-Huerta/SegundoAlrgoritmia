
package cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8190); 
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            Scanner scan = new Scanner(in);
            PrintWriter pw = new PrintWriter(out, true);
            pw.println("oliss");

            Scanner kb = new Scanner(System.in);
             while (true) {
                if (scan.hasNextLine()) {
                    String mensaje = scan.nextLine();
                    System.out.println("Servidor: " + mensaje);
                    if (mensaje.contains("Conexión finalizada"))
                        break;
                }
              
                String u = kb.nextLine();
                pw.println(u); 
                if (u.trim().equalsIgnoreCase("Salir")) 
                    break;
            }
            socket.close();
            scan.close();
            pw.close();
            kb.close();
        } catch (IOException ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
    }
}

    

