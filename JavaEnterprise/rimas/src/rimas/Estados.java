package rimas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Estados {

    public static void main(String[] args) {
        EstadosMarco mimarco=new EstadosMarco();
        mimarco.setVisible(true);

    }
}

class EstadosMarco extends JFrame {

    public EstadosMarco() {

        setLocationRelativeTo(null);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Estados de la republica y sus capitales");

        LaminaEstados milamina = new LaminaEstados();
        add(milamina);
    }

}

class LaminaEstados extends JPanel {

    public LaminaEstados() {

        Metodos met = new Metodos();

        JLabel lb1 = new JLabel("Estados y sus capitales");
        JLabel lb2 = new JLabel("Capitales");
        JList<String> list = new JList<>(met.getEstados());
        JScrollPane scro=new JScrollPane(list);
        JButton bt1=new JButton("Verificar");
        
        add(lb1);
        add(scro);
        add(lb2);
        add(bt1);
    }

}
