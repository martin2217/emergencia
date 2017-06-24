package sistemaDeProduccion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseDeConocimientos {
	
	// Memoria de trabajo
	private Set<String> palabrasEncontradas;
	//private reglasActivadas;
	
	// Memoria de producciones
	private HashMap<String, String> palabras;
	// TODO inicializar con las palabras de las reglas
	
	public BaseDeConocimientos(){
		inicializar();
		palabrasEncontradas = new LinkedHashSet<String>();
		//reglasActivadas = new
		
	}
	
	private void inicializar(){
		palabras= new LinkedHashMap<String, String>();
	}
	public void reiniciar(){
		
	}
}
