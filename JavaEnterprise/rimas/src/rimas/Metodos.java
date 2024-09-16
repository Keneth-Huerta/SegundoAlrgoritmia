package rimas;

import java.util.ArrayList;
import java.util.Random;

public class Metodos {

    public String[] getEstados() {

        ArrayList<Integer> nums = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < estados.length; i++) {
            int rands;
            do {
                rands = rand.nextInt(estados.length);
            } while (nums.contains(rands));
            nums.add(rands);
        }
        int[] alea = new int[estados.length];
        for (int i = 0; i < nums.size(); i++) {

            alea[i] = nums.get(i);

        }
        String[] temp = estados;
        for (int i = 0; i < temp.length; i++) {
            estados[i] = temp[alea[i]];

        }

        return estados;
    }

    private String[] estados = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas",
        "Chihuahua", "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco",
        "México", "Michoacán"};

    private String[] capitales = {"Aguascalientes", "Mexicali", "La Paz", "San Francisco de Campeche", "Tuxtla Gutiérrez",
        "Chihuahua", "Saltillo", "Colima", "Victoria de Durango", "Guanajuato", "Chilpancingo de los Bravo",
        "Pachuca de Soto", "Guadalajara", "Toluca de Lerdo", "Morelia"};
}
