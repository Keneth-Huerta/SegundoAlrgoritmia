package graficos;

public class FocoEventos {

	public static void main(String[] args) {

		MarcoCambioEstado mimarco = new MarcoCambioEstado(null, 300, 300, 600, 450, "eoc");
		mimarco.setVisible(true);
	}

}

//class MarcoCambioEstado extends JFrame {
//
//	public MarcoCambioEstado(String title, int x, int y, int width, int height, String sdco) {
//
//		if (sdco.equalsIgnoreCase("eoc")) {
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		}
//
//		setVisible(true);
//		setBounds(x, y, width, height);
//		setTitle(title);
//		setIconImage(new Logo().image());
//
//		add(new LaminaMarcoCambioEstado());
//	}
//}
//
//class LaminaMarcoCambioEstado extends JPanel {
//
//	JTextField cuadro1;
//	JTextField cuadro2;
//
//	public void paintComponent(Graphics g) {
//
//		super.paintComponent(g);
//		setLayout(null);
//
//		cuadro1 = new JTextField();
//		cuadro2 = new JTextField();
//
//		cuadro1.setBounds(120, 10, 150, 20);
//		cuadro2.setBounds(120, 50, 150, 20);
//		add(cuadro1);
//		add(cuadro2);
//		LanzaFocos elFoco = new LanzaFocos();
//
//		cuadro1.addFocusListener(elFoco);
//	}
//
//	private class LanzaFocos implements FocusListener {
//
//		public void focusGained(FocusEvent e) {
//
//		}
//
//		public void focusLost(FocusEvent e) {
//
//			String email = cuadro1.getText();
//			System.out.println(email);
//			boolean comprobacion = false;
//			for (int i = 0; i < email.length(); i++) {
//				if (email.charAt(i) == '@') {
//					comprobacion = true;
//				}
//
//			}
//			if (comprobacion) {
//				System.out.println("Correcto");
//			} else {
//				System.out.println("Incorrecto");
//			}
//		}
//
//	}
//}