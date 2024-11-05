package main;

import javax.swing.JFrame;

public class Window {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		Lienzo l=new  Lienzo();
		f.add(l);
		//f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
