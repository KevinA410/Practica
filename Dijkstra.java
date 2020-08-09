package practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dijkstra {
	private int[][] matrizAdy;
	private int nNodos;
	private ArrayList<String> conj_s = new ArrayList<>();
	private ArrayList<String> conjComp_s = new ArrayList<>();
	private ArrayList<String> caminos = new ArrayList<>();
	private String tmp;
	private InputStreamReader l1;
	private BufferedReader l2;
	
	public int min(int dest) {
		int min = -1, nod = 0, nodOrig = -1, aux;
		
		for (int i = 0; i < conj_s.size(); i++) {
			nod = Integer.valueOf((String) conj_s.get(i)).intValue();
			if(matrizAdy[nod][nod] != -1 && matrizAdy[nod][dest] != -1) {
				aux = matrizAdy[nod][nod] + matrizAdy[nod][dest];
			}else {
				aux = -1;
			}
			
			if((aux < min && aux != -1) || min == -1) {
				min = aux;
				nodOrig = nod;
			}
		}
		
		if(min != -1) {
			matrizAdy[dest][dest] = min;
			caminos.set(dest, "" + (char) (nodOrig + 65));
		}
		return min;
	}
	
	public void resuelve(int aux) {
		int nodCambio = 0, minimo, nod;
		for (int i = 0; i < nNodos; i++) {
			minimo = -1;
			for (int j = 0; j < conjComp_s.size(); j++) {
				nod = Integer.valueOf((String) conjComp_s.get(j)).intValue();
				aux = min(nod);
				
				if(minimo == -1 || (aux < minimo && aux != -1)) {
					minimo = aux;
					nodCambio = j;
				}
			}
			if(minimo != -1) {
				conj_s.add((String) conjComp_s.get(nodCambio));
			}
		}
	}
	
	public void imprimeCamino(String cam, int nod, int o) {
		System.out.println("\nCaminos: ");
		if(cam.charAt(0) == '*') {
			System.out.print("No hay camino de:" + (char) (o + 65) + "a: " + cam.charAt(cam.length()-1) + "!\n");
		}else {
			for (int i = 0; i < cam.length(); i++) {
				System.out.println("" + cam.charAt(i) + (i == cam.length() -1 ? "" : "->"));
			}
			System.out.println("costo: " + matrizAdy[nod][nod] + "\n");
		}
	}
	
	public Dijkstra(int numNodos) {
		matrizAdy = new int[numNodos][numNodos];
		int aux = 0;
		l1 = new InputStreamReader(System.in);
		l2 = new BufferedReader(l1);
		nNodos = numNodos;
		cargaDesdeTeclado();
		do {
			try {
				System.out.print("Cual es el nodo de origen: ");
				aux = ((int) l2.readLine().toUpperCase().charAt(0)) - 65;
				
			}catch(Exception e) {
				System.out.print("Error: " + e);
				aux = -1;
			}
		}while(aux < 0 || aux > nNodos - 1);
		matrizAdy[aux][aux] = 0;
		resuelve(aux);
	}
}
