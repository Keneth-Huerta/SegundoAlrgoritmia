package terceroalgoritmia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Encriptador extends JFrame implements ActionListener {

    private JTextField txtFraseOriginal;
    private JTextField txtFraseEncriptada;
    private JButton btnEncriptar;

    public Encriptador() {
        super("Encriptador de frases");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        // Etiquetas
        JLabel lblFraseOriginal = new JLabel("Frase original:");
        add(lblFraseOriginal);
        JLabel lblFraseEncriptada = new JLabel("Frase encriptada:");

        // Campos de texto
        txtFraseOriginal = new JTextField(20);
        add(txtFraseOriginal);
        add(lblFraseEncriptada);
        txtFraseEncriptada = new JTextField(20);
        txtFraseEncriptada.setEditable(false);
        add(txtFraseEncriptada);

        // Botón
        btnEncriptar = new JButton("Encriptar");
        btnEncriptar.addActionListener(this);
        add(btnEncriptar);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEncriptar) {
            String fraseOriginal = txtFraseOriginal.getText();
            String fraseEncriptada = "";
            for (char c : fraseOriginal.toCharArray()) {
            	fraseEncriptada += (char) ((c +8) % 26 + 'a');
            }
            txtFraseEncriptada.setText(fraseEncriptada);
        }
    }

    public static void main(String[] args) {
        new Encriptador();
    }
}
