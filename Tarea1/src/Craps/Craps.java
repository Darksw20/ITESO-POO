package Craps;

import javax.swing.JOptionPane;

public class Craps {

	public static void main(String[] args) {
		// Se inicializan los valores de eleccion y de los dados
		int eleccion = 0;
		int dado1 = (int)(Math.random()*6+1);
		int dado2 = (int)(Math.random()*6+1);
		int suma = 0;
		// Se hace un ciclo que decide si el jugador quiere seguir jugando 
		while(eleccion == 0) {
			suma = dado1 + dado2; // Se suman los dados
			//segun el resultado se escoje el JOptionPane adecuado
			switch(suma) {
				case 7:
				case 11:
					//el jugador Gana la apuesta y aparece un JOptionPane que se lo avise
					eleccion = JOptionPane.showConfirmDialog(null, "Lanzaste: "+ dado1 
							+", "+ dado2 +".\nGanas la apuesta.\n¿Deseas seguir jugando?", "Craps", JOptionPane.YES_NO_OPTION);				
					break;
				case 2:
				case 3:
				case 12:
					//el jugador Pierde la apuesta y aparece un JOptionPane que se lo avise
					eleccion = JOptionPane.showConfirmDialog(null, "Lanzaste: "+ dado1 
							+", "+ dado2 +".\nPierdes la apuesta.\n¿Deseas seguir jugando?", "Craps", JOptionPane.YES_NO_OPTION);
					break;
				default:
					//el jugador Gana un punto y aparece un JOptionPane que se lo avise
					eleccion = JOptionPane.showConfirmDialog(null, "Lanzaste: "+ dado1 
							+", "+ dado2 +".\nGanas un punto.\n¿Deseas seguir jugando?", "Craps", JOptionPane.YES_NO_OPTION);
					break;
			}
			//Se vuelven a tirar los dados para la siguiente ronda
			dado1 = (int)(Math.random()*6+1);
			dado2 = (int)(Math.random()*6+1);
			
		}
	}

}
