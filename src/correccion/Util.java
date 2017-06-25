package correccion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import normalizador.Normal;

public class Util {
	
	private static Normal normalizador;
	private static JazzySpellChecker corrector;

	public static String corregir1(String cadena,
			Normal normalizador, JazzySpellChecker corrector) {
		
		String aux = cadena;

		// Eliminación de acentos - Previamente hecho
		//aux = reemplazarAcentos(aux);

		// TODO Agregar - normalizacion (plurales a singular, infinitivos)
		// normalizar -> corregir -> separar ( corregir 1 )
		// +
		// corregir -> normalizar -> separar ( corregir 2 )
		// en un set ingresar todas las palabras de ambos caminos..

		// Corrección ortográfica
		aux = corrector.getCorrectedText(aux);
		
		return aux;
	}
	
	// No usado
	public static String corregir2(String cadena,
			Normal normalizador, JazzySpellChecker corrector) {
		
		String aux = cadena;
		
		// Corrección ortográfica
		aux = corrector.getCorrectedText(aux);
		
		// Normalizacion
		//aux = normalizador.fraseNormalizada(aux);
		
		return aux;
	}
	
	public static ArrayList<String> listaPalabras(String cadena,
			Normal normalizador, JazzySpellChecker corrector){
		
		Set<String> aux = new LinkedHashSet<String>();
		String cadenaAux = reemplazarAcentos(cadena);
		cadenaAux= cadenaAux.toLowerCase();
		
		List<String> aux0 =normalizador.normalizar(corregir1(cadenaAux, normalizador, corrector));
		List<String> aux1 =separarPalabras(corregir1(cadenaAux, normalizador, corrector));
		List<String> aux2 =normalizador.normalizar(cadenaAux);
		
		aux.addAll(aux1);
		aux.addAll(aux2);
		
		return new ArrayList<String>(aux);
	}
	
	public static String reemplazarAcentos(String cadena){
		String aux=cadena;
		aux=aux.replace("á", "a");
		aux=aux.replace("é", "e");
		aux=aux.replace("í", "i");
		aux=aux.replace("ó", "o");
		aux=aux.replace("ú", "u");
		aux=aux.replace("Á", "A");
		aux=aux.replace("É", "E");
		aux=aux.replace("Í", "I");
		aux=aux.replace("Ó", "O");
		aux=aux.replace("Ú", "U");
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
