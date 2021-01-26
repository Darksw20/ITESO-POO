package tests;

import tools.Leer;

public class TestLeer {

	public static void main(String[] args) {
		short datoShort = 0;
		int datoInt = 0;
		long datoLong = 0;
		float datoFloat = 0;
		double datoDouble = 0;
		
		System.out.print("Dame un número Short " );
		datoShort = Leer.datoShort();
		System.out.print("Dame un número Entero " );
		datoInt = Leer.datoInt();
		System.out.print("Dame un número Long " );
		datoLong = Leer.datoLong();
		System.out.print("Dame un número Float " );
		datoFloat = Leer.datoFloat();
		System.out.print("Dame un número Double " );
		datoDouble = Leer.datoDouble();
		
		// imprimimos todo
		
		System.out.println("Dato short :" + datoShort);
		System.out.println("Dato int :" + datoInt);
		System.out.println("Dato long :" + datoLong);
		System.out.println("Dato float :" + datoFloat);
		System.out.println("Dato double :" + datoDouble);

	}

}
