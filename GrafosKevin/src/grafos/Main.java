package grafos;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		GrafosMatriz grafos = new GrafosMatriz();
		Scanner leer = new Scanner(System.in);
		int opciones;
		do {
			System.out.println("-----------------------------------------");
			System.out.println("------BIENVENIDO A MI PROGRAMA------");
			System.out.println("1- INGRESAR DE MANERA DINAMICA LOS GRAFOS");
			System.out.println("2- EJERCICO REALIZADO EN CLASE");
			System.out.println("3- SALIR");
			System.out.println("-----------------------------------------");
			opciones = leer.nextInt();
			switch(opciones) {
			case 1:
				grafos.VerticesInsertar();
				grafos.imprimirGrafo();
				break;

			case 2:

				System.out.println("-*------*-");
				grafos.nuevoVertice("A");
				grafos.nuevoVertice("B");
				grafos.nuevoVertice("C");
				grafos.nuevoVertice("D");
				try {
					grafos.nuevoArco("A", "B");
					grafos.nuevoArco("C", "D");
				}catch (Exception e) {
					e.printStackTrace();
				}

				try {
					System.out.println("No es adyacente" + grafos.adyacente("A", "B"));
					System.out.println("Si es adyacente" + grafos.adyacente("A", "B"));
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;

			case 3:
				System.exit(opciones);
				break;

			default:
				System.out.println("SE A INGRESADO UNA OPCION INCORRECTA");
			}

		}while(opciones !=3);



	}


}


