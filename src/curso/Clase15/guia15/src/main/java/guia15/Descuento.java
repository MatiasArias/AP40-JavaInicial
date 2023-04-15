package guia15;

import lombok.Data;

@Data //generamos setters y getters automáticamente

public class Descuento {
	
	private char tipo; //el tipo de descuento se guarda como un carácter
	private float cantidad;
	private int tope;

}
