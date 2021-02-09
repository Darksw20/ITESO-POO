package ejercicio2;

public class Main {

	public static void main(String[] args) {
		int x = 4;
		int[] V = new int[] {0,1,2,3,4,5,6,7,8,9};
		int[] v1 = new int[V.length] ;
		int[] v2 = new int[V.length];

		for(int i=0,j=0;i<10;i++) {
			if(V[i]>x) {
				v1[j] = V[i];				
			}
		}
		for(int i=0,j=0;i<10;i++) {
			if(V[i]%2!=0) {
				v1[j] = V[i];				
			}
		}
		for(int i=0;i<10;i++) {
			System.out.println("V1["+i+"]:"+v1[i]);
		}
		for(int i=0;i<10;i++) {
			System.out.println("V2["+i+"]:"+v2[i]);
		}
		
	}

}
