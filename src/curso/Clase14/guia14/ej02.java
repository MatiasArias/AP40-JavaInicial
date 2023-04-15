package guia14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ej02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		args=new String[2];
		args[0]="src/guia14/Archivo.txt";
		//modificamos la expresión regular para que tenga grupos! esto se hace con los paréntesis
		args[1]="([0-9][0-9])-([0-9]{8})-([0-9])\\|([a-z]+)@([a-z]+)((\\.[a-z]+)+)\\|([a-z]|[A-Z]|[0-9]| |[á-ú]|[Á-Ú])*";
		
		String rutaArchivo=args[0];
		String expresionRegular=args[1];
		
		int numeroDeLinea=0;
		boolean correspondeExpresionRegular;
		
		Path archivo = Paths.get(rutaArchivo);
		
		final Pattern compararExpresionRegular = Pattern.compile(expresionRegular);
		//esta variable nos permitirá obtener los grupos obtenidos por cada línea
		Matcher gruposDeCadaLinea;
		
		try {
			for(String linea:Files.readAllLines(archivo)) {
				numeroDeLinea++;
				//actualizamos el valor del objeto de clase "Matcher"
				gruposDeCadaLinea=compararExpresionRegular.matcher(linea);
				//verificamos si encontramos la expresión regular en nuestra línea
				correspondeExpresionRegular=gruposDeCadaLinea.matches();
				
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("Línea "+numeroDeLinea+" ["+linea+"]");
				System.out.println(correspondeExpresionRegular);
				
				//en caso de encontrar la expresión regular, imprimiremos los grupos encontrados
				if(correspondeExpresionRegular) {
					System.out.println(""); //salto de línea para dar formato
					for(int i=1;i<=gruposDeCadaLinea.groupCount();i++) {
						//empezamos desde el grupo 1, ya que el grupo 0 es toda la expresión completa
						//y vamos hasta la cantidad de grupos que haya en la expresión
						//"groupCount()" nos devuelve esta cantidad de grupos
						System.out.println("Grupo "+i+" ["+gruposDeCadaLinea.group(i)+"]");
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
