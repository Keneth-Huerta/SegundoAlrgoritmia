package excepciones_I;

import javax.swing.JOptionPane;

public class Comprueba_mail {

	public static void main(String[] args) {

		String mail = JOptionPane.showInputDialog("Introduce tu Email");
		try {
//
			examinaMail(mail);
		} catch (Exception e) {
//
			System.out.println("La dirección de email no es correcta");
			e.printStackTrace();
		}
	}

	static void examinaMail(String mail)throws LongitudMailErronea {

		int arroba = 0;
		boolean punto = false;

		if (mail.length() <= 3) {

//			ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException();
//			throw new ArrayIndexOutOfBoundsException();
			throw new LongitudMailErronea("El email no puede tener menos de tres caracteres");
		} else {

			for (int i = 0; i < mail.length(); i++) {

				if (mail.charAt(i) == '@') {
					arroba++;
				}
				if (mail.charAt(i) == '.') {
					punto = true;
				}
			}
			if (arroba == 1 && punto == true) {
				System.out.println("Es correcto");
			} else {
				System.out.println("No es correcto");
			}
		}
	}

}

class LongitudMailErronea extends Exception {

	public LongitudMailErronea() {

	}

	public LongitudMailErronea(String msjError) {
		super(msjError);
	}
}
