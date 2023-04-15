package guia15;

import lombok.Data;

@Data

public class Oferta {
	
	private Producto producto;
	private Descuento descuento;
	//utilizamos la clase "String" ya que las fechas pueden generar errores al serializar!
	private String fechaDesde;
	private String fechaHasta;

}
