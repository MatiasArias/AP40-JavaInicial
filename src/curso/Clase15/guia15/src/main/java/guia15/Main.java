package guia15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

//para poder serializar a XML me informé mediante la siguiente página
//https://github.com/FasterXML/jackson-dataformat-xml
//en el archivo "pom.xml" se pueden visualizar las dependencias necesarias!

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		args=new String[2];
		args[0]="src/main/resources/Archivo.csv";
		//args[1]="JSON";
		args[1]="XML";
		//podemos cambiar para ver los diferentes resultados
		
		Path archivo = Paths.get(args[0]);
		
		try {
			
			//variable para ir imprimiendo los resultados
			String resultado="";
			
			if(args[1].equalsIgnoreCase("JSON")) {
				//en caso de elegir archivos JSON
				for(String linea:Files.readAllLines(archivo)) {
					//para cada línea del archivo
					Oferta oferta = crearOferta(linea); //creo un objeto de tipo "Oferta"
					resultado=convertirJson(oferta); //lo convierto
					System.out.println(resultado);
				}
			}else if(args[1].equalsIgnoreCase("XML")) {
				//si queremos que sean archivos XML
				for(String linea:Files.readAllLines(archivo)) {
					//realizo los mismo que con JSON
					Oferta oferta = crearOferta(linea);
					resultado=convertirXml(oferta); //sólo que ahora utilizo el método correspondiente
					System.out.println(resultado);
				}
			}else {
				//en caso de que no se ingrese correctamente el archivo requerido
				resultado="NO SE HA ESPECIFICADO CORRECTAMENTE EL FORMATO A CONVERTIR!";
				System.out.println(resultado);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static String convertirXml(Oferta oferta) {
		String Xml="";
		
		//en vez de usar el constructor "ObjectMapper()" tenemos que usar "XmlMapper()"
		ObjectMapper mapeoXml = new XmlMapper();
		try {
			//convertimos a texto XML
			Xml = mapeoXml.writeValueAsString(oferta);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Xml;
	}
	
	private static String convertirJson(Oferta oferta) {
		String Json="";
		
		//aquí utilizamos el constructor "ObjectMapper()", ya que es JSON por defecto
		ObjectMapper mapeoJson = new ObjectMapper();
		try {
			Json = mapeoJson.writeValueAsString(oferta);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Json;
	}
	
	//método para convertir una línea en un objeto de tipo "Oferta"
	private static Oferta crearOferta(String linea) {
		String[] datos = linea.split(","); //un archivo ".csv" separa los datos mediante las comas (",")
		
		//guardamos los datos en su variable correspondiente
		String nombreProd = datos[0];
		String cantPesoProd = datos[1];
		String tipoPesoProd = datos[2];
		int precioProd = Integer.parseInt(datos[3]);
		char tipoDesc = (char) datos[4].charAt(0); //"%" descuento porcentual y "$" descuento fijo
		float cantDesc = Float.parseFloat(datos[5]);
		int topeDesc = Integer.parseInt(datos[6]);
		String desde = datos[7];
		String hasta = datos[8];
		//las fechas las guardamos convenientemente como texto
		//si intentamos guardarlas como "LocalDate" nos dará un error al querer mapear (serializar)
		
		//creo mi producto con sus variables de instancia correspondientes
		Producto producto = new Producto();
		producto.setNombre(nombreProd);
		//el peso se guarda por cantidad y unidad utilizada
		producto.setPeso(new String[]{cantPesoProd, tipoPesoProd});
		producto.setPrecio(precioProd);
		
		//creo mi descuento
		Descuento descuento = new Descuento();
		descuento.setTipo(tipoDesc);
		descuento.setCantidad(cantDesc);
		descuento.setTope(topeDesc);
		
		//finalmente creo la oferta
		Oferta oferta = new Oferta();
		oferta.setProducto(producto);
		oferta.setDescuento(descuento);
		oferta.setFechaDesde(desde);
		oferta.setFechaHasta(hasta);
		
		return oferta;
	}

}
