package rimas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class MainFrame extends JFrame {
    private JList<String> stateList;
    private JTextField capitalField;
    private JButton verifyButton;

    private String[] states;
    private String[] capitals;
    private ArrayList<Integer> randomIndices;

    public MainFrame() {
        super("Estados de México");
        initializeArrays();

        stateList = new JList<>(states);
        stateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stateList.setLayoutOrientation(JList.VERTICAL);
        stateList.setVisibleRowCount(-1);

        capitalField = new JTextField(15);
        capitalField.setEditable(false);

        verifyButton = new JButton("Verificar");
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifyCapital();
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(new JScrollPane(stateList));
        panel.add(capitalField);
        panel.add(verifyButton);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeArrays() {
        states = new String[]{"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas",
                "Chihuahua", "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco",
                "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro",
                "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala",
                "Veracruz", "Yucatán", "Zacatecas"};

        capitals = new String[]{"Aguascalientes", "Mexicali", "La Paz", "San Francisco de Campeche", "Tuxtla Gutiérrez",
                "Chihuahua", "Saltillo", "Colima", "Victoria de Durango", "Guanajuato", "Chilpancingo de los Bravo",
                "Pachuca de Soto", "Guadalajara", "Toluca de Lerdo", "Morelia", "Cuernavaca", "Tepic", "Monterrey",
                "Oaxaca de Juárez", "Puebla de Zaragoza", "Santiago de Querétaro", "Chetumal", "San Luis Potosí",
                "Culiacán Rosales", "Hermosillo", "Villahermosa", "Ciudad Victoria", "Tlaxcala de Xicohténcatl",
                "Xalapa-Enríquez", "Mérida", "Zacatecas"};

        randomIndices = new ArrayList<>();
        for (int i = 0; i < states.length; i++) {
            randomIndices.add(i);
        }
        Collections.shuffle(randomIndices);
    }

    private void verifyCapital() {
        int selectedIndex = stateList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedState = states[randomIndices.get(selectedIndex)];
            String enteredCapital = capitalField.getText().trim();
            String correctCapital = capitals[randomIndices.get(selectedIndex)];

            if (enteredCapital.equalsIgnoreCase(correctCapital)) {
                JOptionPane.showMessageDialog(this, "¡Correcto!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrecto. La capital de " + selectedState + " es " + correctCapital,
                        "Resultado", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un estado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}



class Utilidades {

    private static String[] estados = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas",
            "Chihuahua", "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco",
            "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro",
            "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala",
            "Veracruz", "Yucatán", "Zacatecas"};

    private static String[] capitales = {"Aguascalientes", "Mexicali", "La Paz", "San Francisco de Campeche", "Tuxtla Gutiérrez",
            "Chihuahua", "Saltillo", "Colima", "Victoria de Durango", "Guanajuato", "Chilpancingo de los Bravo",
            "Pachuca de Soto", "Guadalajara", "Toluca de Lerdo", "Morelia", "Cuernavaca", "Tepic", "Monterrey",
            "Oaxaca de Juárez", "Puebla de Zaragoza", "Santiago de Querétaro", "Chetumal", "San Luis Potosí",
            "Culiacán Rosales", "Hermosillo", "Villahermosa", "Ciudad Victoria", "Tlaxcala de Xicohténcatl",
            "Xalapa-Enríquez", "Mérida", "Zacatecas"};

    public static ArrayList<String> obtenerEstadosAleatorios() {
        ArrayList<String> estadosAleatorios = new ArrayList<>();
        ArrayList<Integer> indicesAleatorios = new ArrayList<>();
        for (int i = 0; i < estados.length; i++) {
            indicesAleatorios.add(i);
        }
        Collections.shuffle(indicesAleatorios);
        for (int i = 0; i < 15; i++) {
            estadosAleatorios.add(estados[indicesAleatorios.get(i)]);
        }
        return estadosAleatorios;
    }

    public static String obtenerCapital(String estado) {
        for (int i = 0; i < estados.length; i++) {
            if (estado.equalsIgnoreCase(estados[i])) {
                return capitales[i];
            }
        }
        return null;
    }
}
