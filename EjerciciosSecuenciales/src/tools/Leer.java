package tools;

import java.io.*;

public class Leer {
	
	public static String dato() {
		String sdato= "";
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoEntrada = new BufferedReader(isr);
			sdato = flujoEntrada.readLine();
		}
		catch(IOException e) {
			System.err.println("Error: "+e.getMessage());
		}
		return sdato;
	}
	
	public static Short datoShort() {
		try {
			return Short.parseShort(dato());
		}
		catch (NumberFormatException e) {
			return Short.MIN_VALUE;
		}
	}
	
	public static int datoInt() {
		try {
			return Integer.parseInt(dato());
		}
		catch (NumberFormatException e) {
			return Integer.MIN_VALUE;
		}
	}
	
	public static long datoLong() {
		try {
			return Long.parseLong(dato());
		}
		catch (NumberFormatException e) {
			return Long.MIN_VALUE;
		}
	}
	
	public static float datoFloat() {
		try {
			return Float.parseFloat(dato());
		}
		catch (NumberFormatException e) {
			return Float.NaN;
		}
	}
	
	public static double datoDouble() {
		try {
			return Double.parseDouble(dato());
		}
		catch (NumberFormatException e) {
			return Double.NaN;
		}
	}
	
} // fin de la clase leer
