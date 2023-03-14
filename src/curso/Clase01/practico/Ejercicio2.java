package curso.Clase1.practico;

public class Ejercicio2 {
	/*Dado el siguiente texto, vamos a atacar el siguiente problema: “determinar si una
	persona pertenece al segmento de ingresos altos”. Del i al iii, la idea es hacerlo en
	papel y lápiz y sólo implementar el cuarto*/
	public static void main(String[] args) {
		//Punto d
		/* Datos de entrada:
			- Ingresos mensuales totatles >= $489.083
			- 3 o mas vehiculos con una antiguedad menor a 5 añis
			- Tener 3 o más inmuebles
			- Poseer una embaracion, una aeronave de lujo o ser titular de activos societarios que
			demuestren capacidad economica plena
		*/
		
		double ingresosMensuales = 100;
		int cantidadVehiculos = 2;
		int cantidadInmuebles = 2;
		boolean embarcacion = true;
		boolean aeronave = false;
		boolean activosSocietarios =false;
		//Queda a su consideracion como armen esta condicion:
		//Pueden unificar todo desde un principio o incluirlo en el condicional directamente
		boolean capacidadEconomicaPlena = embarcacion || aeronave || activosSocietarios;
		
		if((ingresosMensuales>=489083)||(cantidadVehiculos>=3)||(cantidadInmuebles>=3)||capacidadEconomicaPlena) {
			System.out.println("Pertenece al segmento de ingresos altos");
		}else{
			System.out.println("No pertenece al segmento de ingresos altos");		
		}
	}
	
}
