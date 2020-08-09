package practica;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class Graph {
	private int v;
	private LinkedList<Integer>[] adj;
	
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void agregarArista(int v, int w) {
		adj[v].add(w);
	}
	
	public void topologicalSort() {
		Stack<Integer> pila = new Stack<>();
		boolean visitado[] = new boolean[v];
		
		for (int i = 0; i < v; i++) {
			if(visitado[i] == false) {
				ordenarTopologicoUtil(i, visitado, pila);
			}
		}
		
		while(pila.isEmpty() == false) {
			System.out.println(pila.pop() + " ");
		}
	}
	
	public void ordenarTopologicoUtil(int v, boolean visitado[],Stack<Integer> pila) {
		visitado[v] = true;
		Integer i;
		Iterator<Integer> it = adj[v].iterator();
		
		while(it.hasNext()) {
			i = it.next();
			if(!visitado[i]) {
				ordenarTopologicoUtil(i, visitado, pila);
			}
		}
		pila.push(v);
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		
		g.agregarArista(5, 2);
		g.agregarArista(5, 0);
		g.agregarArista(4, 0);
		g.agregarArista(4, 1);
		g.agregarArista(2, 3);
		g.agregarArista(3, 1);
		
		System.out.println("El orden topologico es: \n");
		g.topologicalSort();
	}
}
