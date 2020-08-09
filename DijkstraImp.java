package practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import practica.Dijkstra;

public class DijkstraImp {
	
	public static void main(String[] args) {
		int num = 0;
		System.out.println("\tAlgoritmo de Dijkstra");
		System.out.println("Numero de nodos que tiene el grafo a resolver: ");
		
		do {
			try {
				InputStreamReader l1 = new InputStreamReader(System.in);
				BufferedReader l2 = new BufferedReader(l1);
				num = Integer.valueOf(l2.readLine()).intValue();
			}catch(IOException e) {
				System.out.println("Error: " + e);
				System.out.println("Ingresa el numero de nodos que tiene el grafo a resolver: ");
			}catch(NumberFormatException e2) {
				System.out.println("Error: " + e2);
				System.out.println("Ingresa el numero de nodos que tiene el grafo a resolver: ");
			}
			
			if(num < 3 || num > 26) {
				System.out.println("El numero de nodos debe estar entre 3 y 26 ");
			}
		}while(num < 3 || num > 26);
		Dijkstra obj = new Dijkstra(num);
	}
}
