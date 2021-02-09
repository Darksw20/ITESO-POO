package ejercicio2;

import javax.swing.JOptionPane;

public class Pentagonales {

	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un entero n", null, JOptionPane.QUESTION_MESSAGE));
		JOptionPane.showMessageDialog(null, "El numero pentagonal es: " + getPentagonalNumber(n), null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	static int getPentagonalNumber(int a) {
		return a*(((3*a)-1)/2);
	}

}
