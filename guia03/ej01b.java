
public class ej01b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arrayNumeros1 = new int[] {60,87,14};
		int[] arrayOrdenado1 = ordenarNumerosBurbuja(true,arrayNumeros1);
		System.out.println(imprimirArray(arrayOrdenado1));
		//System.out.println(arrayOrdenado1);
		
		int[] arrayNumeros2 = {45,12,37};
		int[] arrayOrdenado2 = ordenarNumerosBurbuja(false,arrayNumeros2);
		System.out.println(imprimirArray(arrayOrdenado2));
		//System.out.println(arrayOrdenado2);
		
	}
	
	// Dados 3 números y un orden (ascendente o decreciente) que ordene los
	// mismos y los retorne en un vector de 3
	static int[] ordenarNumerosBurbuja(boolean ascendente, int[] numeros) {
		int cantidadDeNumeros=numeros.length; //obtenemos la longitud del vector de los números
		if(ascendente) { //orden ascendente
			for(int i=0;i<cantidadDeNumeros;i++) { //tope del recorrido
				for(int j=0;j<(cantidadDeNumeros-1);j++) { //recorremos los números del vector
					//en este caso es (cantidadDeNumeros-1) ya que iremos accediendo al número siguiente,
					//por lo cual, restamos 1 para no superar la dimension del vector
					if(numeros[j]>numeros[j+1]) { //evaluamos si el número siguiente es mayor
						int numeroMayor = numeros[j]; //usamos una variable auxiliar para guardar el número mayor
						numeros[j]=numeros[j+1]; //sustituimos el menor por el mayor
						numeros[j+1]=numeroMayor; //ponemos el mayor delante
					}
				}
			}
		}else { //orden descendente
			for(int i=0;i<cantidadDeNumeros;i++) { //tope del recorrido
				for(int j=0;j<(cantidadDeNumeros-1);j++) { //recorremos los números del vector
					//en este caso es (cantidadDeNumeros-1) ya que iremos accediendo al número siguiente,
					//por lo cual, restamos 1 para no superar la dimension del vector
					if(numeros[j]<numeros[j+1]) { //evaluamos si el número siguiente es menor
						int numeroMenor = numeros[j]; //usamos una variable auxiliar para guardar el número menor
						numeros[j]=numeros[j+1]; //sustituimos el mayor por el menor
						numeros[j+1]=numeroMenor; //ponemos el menor delante
					}
				}
			}
		}
		return numeros;
	}
	
	//método para ver el contenido del array
	static String imprimirArray(int[] array) { //formato: {int, int, int}
		String texto="{"; //agregamos la llave inicial
		for(int i=0;i<array.length;i++) { //recorremos nuestros números
			texto=texto+array[i]; //agregamos esos números al String
			if(i!=(array.length-1)) { //en caso de que no sea el último número
				texto=texto+", "; //debemos agregar una coma seguida de un espacio
			}
		}
		texto+="}"; //agregamos la llave final
		return texto; //devolvemos el String
	}
	
}
