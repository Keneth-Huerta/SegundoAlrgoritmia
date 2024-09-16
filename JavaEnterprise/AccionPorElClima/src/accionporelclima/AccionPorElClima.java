package accionporelclima;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccionPorElClima extends JFrame implements ActionListener {
    
    // Componentes de la interfaz gráfica
    private JLabel lblTransporte, lblEnergia, lblAlimentacion;
    private JComboBox<String> cmbTransporte;
    private JRadioButton rbBajoConsumo, rbMedioConsumo, rbAltoConsumo;
    private JCheckBox chkVegetariano, chkVegano;
    private JButton btnCalcular, btnRecomendaciones;
    private JTextArea txtAreaInforme;
    
    // Constructor
    public AccionPorElClima() {
        // Configuración de la ventana
        setTitle("Calculadora de Huella de Carbono");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        
        // Inicialización de componentes
        lblTransporte = new JLabel("Uso de transporte:");
        cmbTransporte = new JComboBox<>(new String[]{"Coche", "Autobús", "Bicicleta"});
        lblEnergia = new JLabel("Consumo de energía:");
        rbBajoConsumo = new JRadioButton("Bajo");
        rbMedioConsumo = new JRadioButton("Medio");
        rbAltoConsumo = new JRadioButton("Alto");
        lblAlimentacion = new JLabel("Patrón alimenticio:");
        chkVegetariano = new JCheckBox("Vegetariano");
        chkVegano = new JCheckBox("Vegano");
        btnCalcular = new JButton("Calcular Huella de Carbono");
        btnRecomendaciones = new JButton("Ver Recomendaciones");
        txtAreaInforme = new JTextArea();
        
        // Agrupación de botones de consumo de energía
        ButtonGroup bgConsumo = new ButtonGroup();
        bgConsumo.add(rbBajoConsumo);
        bgConsumo.add(rbMedioConsumo);
        bgConsumo.add(rbAltoConsumo);
        
        // Asignación de escuchadores de eventos
        btnCalcular.addActionListener(this);
        btnRecomendaciones.addActionListener(this);
        
        // Adición de componentes a la ventana
        add(lblTransporte);
        add(cmbTransporte);
        add(lblEnergia);
        add(rbBajoConsumo);
        add(new JLabel());
        add(rbMedioConsumo);
        add(new JLabel());
        add(rbAltoConsumo);
        add(lblAlimentacion);
        add(chkVegetariano);
        add(new JLabel());
        add(chkVegano);
        add(btnCalcular);
        add(btnRecomendaciones);
        add(new JScrollPane(txtAreaInforme));
        
        // Mostrar la ventana
        setVisible(true);
    }
    
    // Método principal
    public static void main(String[] args) {
        new AccionPorElClima();
    }
    
    // Método para manejar eventos de los botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            // Lógica para calcular la huella de carbono
            // y mostrar el informe en txtAreaInforme
            txtAreaInforme.setText("Informe de Huella de Carbono:\n\n");
            txtAreaInforme.append("Transporte: " + cmbTransporte.getSelectedItem() + "\n");
            txtAreaInforme.append("Consumo de energía: ");
            if (rbBajoConsumo.isSelected())
                txtAreaInforme.append("Bajo\n");
            else if (rbMedioConsumo.isSelected())
                txtAreaInforme.append("Medio\n");
            else if (rbAltoConsumo.isSelected())
                txtAreaInforme.append("Alto\n");
            txtAreaInforme.append("Patrón alimenticio: ");
            if (chkVegetariano.isSelected())
                txtAreaInforme.append("Vegetariano ");
            if (chkVegano.isSelected())
                txtAreaInforme.append("Vegano");
        } else if (e.getSource() == btnRecomendaciones) {
            // Lógica para mostrar las recomendaciones
            JOptionPane.showMessageDialog(this, "Aquí irían las recomendaciones para reducir la huella de carbono.");
        }
    }
}
