package curso.Clase1.practico;

public class Ejercicio1 {
	// 1. Vamos a practicar operaciones básicas con números
	public static void main(String[] args) {
		// Punto a. Utilizando la sentencia while, imprima todos los números entre 2 variables “a”
		//y “b”. Su código puede arrancar (por ejemplo)
		imprimirConsigna(1);
		int numeroInicio=23;
		int numeroFin=34;
		int salida = numeroInicio;
		while(salida<=numeroFin) {
			System.out.println(salida);
			salida=salida+1;
		}
		
		// Punto b. A lo anterior, solo muestre los números pares
		imprimirConsigna(2);
		salida = numeroInicio;
		while(salida<=numeroFin) {
			if(salida%2==0) {
				System.out.println(salida);	
			}
			salida=salida+1;
		}
		
		//Punto c. A lo anterior, con una variable extra, elija si se deben mostrar los números
		//pares o impares
		imprimirConsigna(3);
		salida=numeroInicio;
		boolean mostrarPares = true;
		while(salida<=numeroFin) {
			if(salida%2==0 && mostrarPares) {
				System.out.println(salida);
			}else {
				if(!(salida%2==0) && !mostrarPares) {
					System.out.println(salida);
				}
			}

			salida=salida+1;
		}
		
		//Punto d. Utilizando la sentencia for, hacer lo mismo que en (b) pero invirtiendo el orden
		imprimirConsigna(4);
		for(salida=numeroFin;salida>numeroInicio;salida--) {
			if(salida%2==0) {
				System.out.println(salida);	
			}
		}
	}
	
	private static void imprimirConsigna(int numeroConsigna) {
        System.out.println("\n**********");
        System.out.println("CONSIGNA " + numeroConsigna);
        System.out.println("**********\n");
    }
}
