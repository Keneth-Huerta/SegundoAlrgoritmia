package accionporelclima;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author adam2
 */
public class libros extends javax.swing.JFrame {

	/**
	 * Creates new form libros
	 */
	public libros() {
		initComponents();
		setLocationRelativeTo(null);
		String[] libros = { "Ulises", "Odisea", "Nieve en las montañas" };
		String[] AUTORES = { "James Joyce", "Homero", "Maria Luisa" };
		jr1.setText(libros[0]);
		jr2.setText(libros[1]);
		jr3.setText(libros[2]);
		jr4.setText(AUTORES[0]);
		jr5.setText(AUTORES[1]);
		jr6.setText(AUTORES[2]);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")

	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		grupo1 = new javax.swing.ButtonGroup();
		grupo2 = new javax.swing.ButtonGroup();
		jlb1 = new javax.swing.JLabel();
		jr1 = new javax.swing.JRadioButton();
		jr4 = new javax.swing.JRadioButton();
		jr2 = new javax.swing.JRadioButton();
		jr5 = new javax.swing.JRadioButton();
		jr3 = new javax.swing.JRadioButton();
		jr6 = new javax.swing.JRadioButton();
		jb1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jlb1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jlb1.setOpaque(true);

		grupo1.add(jr1);
		jr1.setText("jRadioButton1");
		jr1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jr1ActionPerformed(evt);
			}
		});

		grupo2.add(jr4);
		jr4.setText("jRadioButton2");
		jr4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jr4ActionPerformed(evt);
			}
		});

		grupo1.add(jr2);
		jr2.setText("jRadioButton3");
		jr2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jr2ActionPerformed(evt);
			}
		});

		grupo2.add(jr5);
		jr5.setText("jRadioButton4");
		jr5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jr5ActionPerformed(evt);
			}
		});

		grupo1.add(jr3);
		jr3.setText("jRadioButton5");
		jr3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jr3ActionPerformed(evt);
			}
		});

		grupo2.add(jr6);
		jr6.setText("jRadioButton6");
		jr6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jr6ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(44, 44, 44)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup().addComponent(jr3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jr6))
						.addGroup(layout.createSequentialGroup().addComponent(jr2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jr5))
						.addGroup(layout.createSequentialGroup().addComponent(jr1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jr4))
						.addComponent(jlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 310,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jb1).addGap(157, 157, 157)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(19, 19, 19)
				.addComponent(jlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(33, 33, 33)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jr1)
						.addComponent(jr4))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jr2)
						.addComponent(jr5))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jr3)
						.addComponent(jr6))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
				.addComponent(jb1).addGap(60, 60, 60)));

		pack();
	}// </editor-fold>

	public boolean num;
	public int CONTAR;
	public boolean num2, num3, num4, num5, num6, si1 = false, si2 = false, si3 = false;

	private void jr1ActionPerformed(java.awt.event.ActionEvent evt) {
		num = jr1.isSelected();
		num2 = jr2.isSelected();
		num3 = jr3.isSelected();
		num4 = jr4.isSelected();
		num5 = jr5.isSelected();
		num6 = jr6.isSelected();
		if (num && num2) {
			jlb1.setText("felicidades");
			jlb1.setBackground(Color.green);
			si1 = true;
			if (si1 && si2 && si3) {
				JOptionPane.showMessageDialog(rootPane, "INCORECTOS es: " + CONTAR);
			}
		} else {
			jlb1.setText("Intenta de nuevo");
			jlb1.setBackground(Color.red);
			CONTAR++;

		}

	}

	private void jr2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		num = jr1.isSelected();
		num2 = jr2.isSelected();
		num3 = jr3.isSelected();
		num4 = jr4.isSelected();
		num5 = jr5.isSelected();
		num6 = jr6.isSelected();
		if (num3 && num5) {
			jlb1.setText("felicidades");
			jlb1.setBackground(Color.green);
			si2 = true;
			if (si1 && si2 && si3) {
				JOptionPane.showMessageDialog(rootPane, "INCORECTOS es: " + CONTAR);
			}
		} else {
			jlb1.setText("Intenta de nuevo");
			jlb1.setBackground(Color.red);
			CONTAR++;

		}
	}

	private void jr3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		num = jr1.isSelected();
		num2 = jr2.isSelected();
		num3 = jr3.isSelected();
		num4 = jr4.isSelected();
		num5 = jr5.isSelected();
		num6 = jr6.isSelected();
		if (num5 && num6) {
			jlb1.setText("felicidades");
			jlb1.setBackground(Color.green);
			si3 = true;
			if (si1 && si2 && si3) {
				JOptionPane.showMessageDialog(rootPane, "INCORECTOS es: " + CONTAR);
			}
		} else {
			jlb1.setText("Intenta de nuevo");
			jlb1.setBackground(Color.red);
			CONTAR++;

		}
	}

	private void jr4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		num = jr1.isSelected();
		num2 = jr2.isSelected();
		num3 = jr3.isSelected();
		num4 = jr4.isSelected();
		num5 = jr5.isSelected();
		num6 = jr6.isSelected();
		if (num && num2) {
			jlb1.setText("felicidades");
			jlb1.setBackground(Color.green);
			si1 = true;
			if (si1 && si2 && si3) {
				JOptionPane.showMessageDialog(rootPane, "INCORECTOS es: " + CONTAR);
			}
		} else {
			jlb1.setText("Intenta de nuevo");
			jlb1.setBackground(Color.red);
			CONTAR++;

		}
	}

	private void jr5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		num = jr1.isSelected();
		num2 = jr2.isSelected();
		num3 = jr3.isSelected();
		num4 = jr4.isSelected();
		num5 = jr5.isSelected();
		num6 = jr6.isSelected();
		if (num3 && num4) {
			jlb1.setText("felicidades");
			jlb1.setBackground(Color.green);
			si2 = true;
			if (si1 && si2 && si3) {
				JOptionPane.showMessageDialog(rootPane, "INCORECTOS es: " + CONTAR);
			}
		} else {
			jlb1.setText("Intenta de nuevo");
			jlb1.setBackground(Color.red);
			CONTAR++;

		}
	}

	private void jr6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		num = jr1.isSelected();
		num2 = jr2.isSelected();
		num3 = jr3.isSelected();
		num4 = jr4.isSelected();
		num5 = jr5.isSelected();
		num6 = jr6.isSelected();
		if (num5 && num6) {
			jlb1.setText("felicidades");
			jlb1.setBackground(Color.green);
			si3 = true;
			if (si1 && si2 && si3) {
				JOptionPane.showMessageDialog(rootPane, "INCORECTOS es: " + CONTAR);
			}
		} else {
			jlb1.setText("Intenta de nuevo");
			jlb1.setBackground(Color.red);
			CONTAR++;

		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new libros().setVisible(true);

			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup grupo1;
	private javax.swing.ButtonGroup grupo2;
	private javax.swing.JButton jb1;
	private javax.swing.JLabel jlb1;
	private javax.swing.JRadioButton jr1;
	private javax.swing.JRadioButton jr2;
	private javax.swing.JRadioButton jr3;
	private javax.swing.JRadioButton jr4;
	private javax.swing.JRadioButton jr5;
	private javax.swing.JRadioButton jr6;
	// End of variables declaration
}