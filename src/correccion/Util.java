package correccion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Util {

	public static String corregir1(String cadena) {
		String aux = cadena;

		// Eliminación de acentos
		aux = reemplazarAcentos(aux);

		// TODO Agregar - normalizacion (plurales a singular, infinitivos)
		// normalizar -> corregir -> separar ( corregir 1 )
		// +
		// corregir -> normalizar -> separar ( corregir 2 )
		// en un set ingresar todas las palabras de ambos caminos..

		// Corrección ortográfica
		JazzySpellChecker corrector = new JazzySpellChecker();
		aux = corrector.getCorrectedText(aux);
		
		return aux;
	}
	
	public static ArrayList<String> listaPalabras(String cadena){
		Set<String> aux = new LinkedHashSet<String>();
		
		aux.addAll(separarPalabras(corregir1(cadena)));
		//aux.addAll(separarPalabras(corregir2(cadena)));
		
		
		return new ArrayList<String>(aux);
	}
	
	public static String reemplazarAcentos(String cadena){
		String aux=cadena;
		aux=aux.replace("á", "a");
		aux=aux.replace("é", "e");
		aux=aux.replace("í", "i");
		aux=aux.replace("ó", "o");
		aux=aux.replace("ú", "u");
		return aux;
	}

	public static ArrayList<String> separarPalabras(String cadena) {
		ArrayList<String> retorno = new ArrayList<String>();

		final String[] palabras = cadena.split("\\s");
		for (String palabra : palabras) {
			retorno.add(palabra);
		}

		return retorno;
	}

}
