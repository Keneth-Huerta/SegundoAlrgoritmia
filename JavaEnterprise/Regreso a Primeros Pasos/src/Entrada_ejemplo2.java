import javax.swing.JOptionPane;

public class Entrada_ejemplo2 {

	public static void main(String[] args) {

		String Nombre_usuario=JOptionPane.showInputDialog("introduce tu nombre, por favor");
		
		String edad =JOptionPane.showInputDialog("Dame tu edad");
		
		int edad_usuario=Integer.parseInt(edad);
		
		System.out.println("Hola"+Nombre_usuario+". El año que viene tendrás "+(edad_usuario+1)+" años");
	}

}