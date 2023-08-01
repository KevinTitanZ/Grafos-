package grafos;

public class Vertice {
	String nombre;
	int numVertice;
	public Vertice(String x) {
		nombre = x;
		numVertice = -1;
	}

	public String nomVertice() {//DEVUELVE INDENTIFICADOR DEL VERTICE
		return nombre;
	}

	public boolean equals(Vertice n) {//TRUE, SI DOS VERTICES SON IGUALES 
		return nombre.equals(n.nombre);
	}
	public void asigVert (int n) {//ESTABLECE EL NUMERO DE VERTICES
		numVertice = n;
	}

	public String toString() { //CARACTERISTICAS DEL VERTICE
		return nombre + "("+ numVertice + ")";
	}






}
