package string;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		String precio;
		double detalles, producto;
		producto = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto vale el producto?"));
		do {
			try {
				precio = JOptionPane.showInputDialog("¿Cuanto vale el producto?");
				detalles = Double.parseDouble(precio);
				if(precio.isEmpty()) {
					continue;
				}else if(detalles <= 0) {
					System.out.println("El precio no es mayor que $0.00");
				}else if(producto == detalles){
					break;
				}
				
			}catch(ArithmeticException ae) {
				System.out.println("El precio no es un número real valido");
			}
		}while (true);
		System.out.println("El total con IVA es de: "+ detalles * 1.16);
		
		
	}
}
