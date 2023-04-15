package guia14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class ej01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//paso mis argumentos
		args=new String[2];
		args[0]="src/guia14/Archivo.txt";
		args[1]="[0-9][0-9]-[0-9]{8}-[0-9]\\|[a-z]+@[a-z]+(\\.[a-z]+)+\\|.*";
		
		//guardo mis argumentos
		String rutaArchivo=args[0];
		String expresionRegular=args[1];
		
		int numeroDeLinea=0; //variable para contar que línea analizamos
		boolean correspondeExpresionRegular; //booleano para determinar si pertenece o no a la expresión
		
		Path archivo = Paths.get(rutaArchivo); //tomamos el archivo
		
		//tomamos el patrón de la expresión regular dada
		final Pattern compararExpresionRegular = Pattern.compile(expresionRegular);
		
		try {
			for(String linea:Files.readAllLines(archivo)) {
				numeroDeLinea++; //contamos la línea
				//con el patrón tomamos el "Matcher" de la línea y verificamos si encuentra la expresión regular
				correspondeExpresionRegular=compararExpresionRegular.matcher(linea).matches();
				
				//imprimimos el resultado
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("Línea "+numeroDeLinea+" ["+linea+"]");
				System.out.println(correspondeExpresionRegular);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
