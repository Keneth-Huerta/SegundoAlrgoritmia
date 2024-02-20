package terceroalgoritmia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Calificacion extends JFrame implements ActionListener {

    private JTextField txtNombre;
    private JTextField[] txtCalificaciones;
    private JButton btnCalcular;

    public Calificacion() {
        super("Calificaciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 150);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        // Etiquetas
        JLabel lblNombre = new JLabel("Nombre:");
        add(lblNombre);
        JLabel lblCalificaciones = new JLabel("Calificaciones:");

        // Campos de texto
        txtNombre = new JTextField(22);
        add(txtNombre);
        add(lblCalificaciones);
        txtCalificaciones = new JTextField[3];
        for (int i = 0; i < txtCalificaciones.length; i++) {
            txtCalificaciones[i] = new JTextField(5);
            add(txtCalificaciones[i]);
        }

        // Botón
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            String nombre = txtNombre.getText();
            float[] calificaciones = new float[3];
            for (int i = 0; i < txtCalificaciones.length; i++) {
                calificaciones[i] = Float.parseFloat(txtCalificaciones[i].getText());
            }

            // Mostrar resumen
            JOptionPane.showMessageDialog(this, "Nombre: " + nombre + "\nCalificaciones: " + Arrays.toString(calificaciones));
        }
    }

    public static void main(String[] args) {
        new Calificacion();
    }
}
