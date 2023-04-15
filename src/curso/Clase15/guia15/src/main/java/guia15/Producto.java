package guia15;

import lombok.Data;

@Data

public class Producto {
	
	private String nombre;
	private String[] peso; //guardamos la cantidad y la unidad del peso mediante texto
	//luego si queremos convertimos ese texto a un entero, por ejemplo
	private int precio;

}
