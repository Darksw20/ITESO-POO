package ejercicio1;

import java.util.Random;

public class Matrices {

	static int[] FillArr(int b) {
		Random rand = new Random();
		int[] c = new int[b];
		
		for(int i=0;i<b;i++) {
			c[i] = rand.nextInt(100);
		}
		
		return c;
	}
	static int[] AddArr(int[] a, int[] b) {
		int[] c = new int[a.length];
		
		for(int i = 0;i < a.length;i++) {
			c[i] = a[i] + b[i];
		}
		
		return c;
	}
	
	static void PrintArr(int[] array) {
		System.out.print("[");
		for(int i=0;i<20;i++) {
			System.out.print(array[i]+",");
		}
		System.out.print("]\n");
	}
	
	public static void main(String[] args) {
		int slots = 20;
		int[] a = FillArr(slots);
		int[] b = FillArr(slots);
		
		int[] c = new int[slots];
		
		c = AddArr(a,b);
		
		PrintArr(a);
		PrintArr(b);
		PrintArr(c);

	}

}
