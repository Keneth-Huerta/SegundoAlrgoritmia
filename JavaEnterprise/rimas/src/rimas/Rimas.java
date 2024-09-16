package rimas;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Rimas {

    public int[] rand() {
        Random rand = new Random();
        int[] nums = new int[13];
       int generados = 0; // Contador de números generados

        while (generados < nums.length) {
            int numeroAleatorio = rand.nextInt(14 - 1 + 1) + 1;
            boolean encontrado = false;

            for (int i = 0; i < generados; i++) {
                if (nums[i] == numeroAleatorio) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                nums[generados] = numeroAleatorio;
                generados++;
            }
        }
            
        
        
        return nums;
    }

    public void verificar(String text, JTextField jTextField1) {
        boolean si = true;
        if (jTextField1.getText().equalsIgnoreCase(text)) {

            JOptionPane.showMessageDialog(null, "Tu respuesta es correcta");

        } else {

            JOptionPane.showMessageDialog(null, "Tu respuesta es incorrecta");

        }
    }

}
