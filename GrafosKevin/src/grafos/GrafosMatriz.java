package grafos;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class GrafosMatriz {
	//ATRIBUTO
	int numVerts;
	static int MaxVerts = 20;
	Vertice [] verts;
	int [][] matAd;

	public GrafosMatriz() {
		this(MaxVerts);	
	}
	public GrafosMatriz(int mx) {

		matAd = new int [mx][mx];
		verts = new Vertice [mx];
		for(int i = 0; i < mx; i++)
			for(int j=0; j< mx; j++)
				matAd[i][j] = 0;
		numVerts = 0;
	}

	//Agregar un numero vertices al grafo

	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom) >=0;
		if (!esta) {
			Vertice v = new Vertice(nom);

			v.asigVert(numVerts);
			verts[numVerts++] = v;

		}
	}
	//OBTENER EL INDICE DE UN VERTICE EN EL ARREGLO "VERTS" SEGN SI NOMBRE
	public int numVertice(String vs){
		Vertice v = new Vertice(vs);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;){
			encontrado = verts[i].equals(v);
			if (!encontrado) i++ ; 
		}
		return (i < numVerts) ? i : -1 ;
	}
	//AGREGAR UNA NUEVA ARISTA ENTRE DOS VERTICES POR SU NOMBRE
	public void nuevoArco(String a, String b)throws Exception{
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		matAd[va][vb] = 1;
	}
	//AGREGAR UNA NUEVA ARISTA ENTRE DOS VERTICES POR SU NOMBRE 
	public void nuevoArco(int va, int vb)throws Exception{
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		matAd[va][vb] = 1;
	}
	//VERIFICAR SI DOS VERTICES POR SU NOMBRE SON ADYACENTES
	public boolean adyacente(String a, String b)throws Exception{
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		return matAd[va][vb] == 1;
	}
	//VERIFICAR SI DOS VERTCIES POR SU INDICE SON ADYANCENTES
	public boolean adyacente(int va, int vb)throws Exception{
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		return matAd[va][vb] == 1;
	}
	public void VerticesInsertar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("INGRESE EL NÚMERO DE VÉRTICES - MAXIMO 20-> ");
		int numVerticesIngresar = scanner.nextInt();
		/*Solicita al usuario ingresar el número de vértices que desea agregar, con un límite máximo de 20.
		Si el número ingresado es inválido (menor o igual a 0 o mayor que 20), solicita que se ingrese nuevamente.*/
		while (numVerticesIngresar > MaxVerts || numVerticesIngresar <= 0) {
			System.out.println("SE A COLOCARDO UNA RESPUESTA INCORRECTA:");
			numVerticesIngresar = scanner.nextInt();
		}

		for (int i = 0; i < numVerticesIngresar; i++) {
			System.out.println(" " + (i + 1) + ": ");
			String nombreVertice = scanner.next();
			nuevoVertice(nombreVertice);
		}

		System.out.println("SI DESEA INGRESAR MÁS VERTICE INGRESE 1 EN CASO CONTRARIO COLOQUE 0");
		int opcion = scanner.nextInt();

		while (opcion == 1) {
			System.out.println("INGRESE COMO DESEE LLAMAR AL VÉRTICE-> ");
			String nombreVertice = scanner.next();
			nuevoVertice(nombreVertice);

			System.out.println("SI DESEA INGRESAR MÁS VERTICE INGRESE 1 EN CASO CONTRARIO COLOQUE 0");
			opcion = scanner.nextInt();
		}

		System.out.println("Ingrese la información de adyacencia entre los vértices:");
		for (int i = 0; i < numVerts; i++) {
			for (int j = 0; j < numVerts; j++) {
				if (i != j) {
					System.out.println("¿El vértice " + verts[i].nombre + " es adyacente al vértice " + verts[j].nombre + "? SI DESEA INGRESAR MÁS VERTICE INGRESE 1 EN CASO CONTRARIO COLOQUE 0");
					int esAdyacente = scanner.nextInt();
					if (esAdyacente == 1) {
						try {
							nuevoArco(i, j);
						} catch (Exception e) {
							System.out.println("Error al agregar el arco: " + e.getMessage());
						}
					}
				}
			}
		}
	}

	public void imprimirGrafo() {
		System.out.println("LA INFORMACION RECOPILADA-> ");

		// Mostrar lista de vértices
		for (int i = 0; i < numVerts; i++) {
			System.out.println("Vértice " + verts[i].nombre);
		}
		// Mostrar aristas adyacentes para cada vértice
		for (int i = 0; i < numVerts; i++) {
			System.out.print("Vértice " + verts[i].nombre + " es adyacente a: ");
			for (int j = 0; j < numVerts; j++) {
				try {
					if (adyacente(i, j)) {
						System.out.print(verts[j].nombre + " ");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println();
		}
	}

}
