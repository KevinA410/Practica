package practica;

import java.util.Scanner;

public class Warshall {
	private static int n;
	private static int[][] warshall;
	private static Scanner leer = new Scanner(System.in);
	
	public static int funcionwar(int i, int j, int k) {
		if(warshall[i][j] == 1 || (warshall[j][k] == 1 && warshall[k][j] == 1)) return 1;
		else return 0;
	}
	
	public static void main(String[] args) {
		System.out.print("Ingrese n (tamaño de la matriz n x n): ");
		n = leer.nextInt();
		int dato = 0;
		warshall = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("Inserte la componente W(" + i + ")(" + j + "): ");
				dato = leer.nextInt();
				warshall[i][j] = dato;
			}
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					warshall[i][j] = funcionwar(i, j, k);
				}	
			}
		}
	}
}
