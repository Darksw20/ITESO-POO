package ejercicio1;

public class Main {

	public static void main(String[] args) {
		int[][] a = new int[][] {{1,2},{3,4},{5,6},{7,8},{9,10}};
		int[][] b = new int[][] {{10,9},{8,7},{6,5},{4,3},{2,1}};
		for(int i=0;i<5;i++) {
			for(int j=0;j<2;j++) {
				System.out.println("El resultado de la suma de A["+i+"]["+j+"] y B["+i+"]["+j+"] es: "+ (a[i][j]+b[i][j]));							
			}
		}
	}

}
