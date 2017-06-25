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

		// Eliminaci�n de acentos - Previamente hecho
		//aux = reemplazarAcentos(aux);

		// TODO Agregar - normalizacion (plurales a singular, infinitivos)
		// normalizar -> corregir -> separar ( corregir 1 )
		// +
		// corregir -> normalizar -> separar ( corregir 2 )
		// en un set ingresar todas las palabras de ambos caminos..

		// Correcci�n ortogr�fica
		aux = corrector.getCorrectedText(aux);
		
		return aux;
	}
	
	// No usado
	public static String corregir2(String cadena,
			Normal normalizador, JazzySpellChecker corrector) {
		
		String aux = cadena;
		
		// Correcci�n ortogr�fica
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
		aux=aux.replace("�", "a");
		aux=aux.replace("�", "e");
		aux=aux.replace("�", "i");
		aux=aux.replace("�", "o");
		aux=aux.replace("�", "u");
		aux=aux.replace("�", "A");
		aux=aux.replace("�", "E");
		aux=aux.replace("�", "I");
		aux=aux.replace("�", "O");
		aux=aux.replace("�", "U");
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
