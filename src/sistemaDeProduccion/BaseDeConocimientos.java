package sistemaDeProduccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseDeConocimientos {
	
	// Memoria de trabajo
	private Set<String> palabrasEncontradas;
	private Set<Regla> reglasActivadas;
	
	// Memoria de producciones
	private HashMap<String, String> palabrasAEncontrar;
	private ArrayList<Regla> reglas;
	// TODO inicializar con las palabras de las reglas
	
	public BaseDeConocimientos(){
		inicializar();
		palabrasEncontradas = new LinkedHashSet<String>();
		reglasActivadas = new LinkedHashSet<Regla>();
		
	}
	
	private void inicializar(){
		// TODO Palabras a matchear - COMPLETAR
		palabrasAEncontrar= new LinkedHashMap<String, String>();
		reglas=Regla.inicializarReglas();
	}
	public void reiniciar(){
		//palabrasAEncontrar= new LinkedHashMap<String, String>();
		palabrasEncontradas = new LinkedHashSet<String>();
		reglasActivadas = new LinkedHashSet<Regla>();
	}
	
	// Si existe palabra a matchear, la agrega a las palabras encontradas
	public void addPalabra(String palabra){
		String aux = palabrasAEncontrar.get(palabra);
		if(aux != null){
			palabrasEncontradas.add(aux); // mató/mato, agregaría matar
		}
	}
	public void addPalabras(ArrayList<String> palabras){
		for(String palabra: palabras){
			addPalabra(palabra);
		}
	}
	public String stringPalabrasEncontradas(){
		String retorno="";
		for(String palabra: palabrasEncontradas){
			retorno+=palabra+" ";
		}
		return retorno;
	}
}
