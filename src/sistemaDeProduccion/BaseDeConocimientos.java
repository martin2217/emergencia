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
	private HashMap<String, String> palabras;
	private ArrayList<Regla> reglas;
	// TODO inicializar con las palabras de las reglas
	
	public BaseDeConocimientos(){
		inicializar();
		palabrasEncontradas = new LinkedHashSet<String>();
		reglasActivadas = new LinkedHashSet<Regla>();
		
	}
	
	private void inicializar(){
		palabras= new LinkedHashMap<String, String>();
		reglas=Regla.inicializarReglas();
	}
	public void reiniciar(){
		palabras= new LinkedHashMap<String, String>();
		palabrasEncontradas = new LinkedHashSet<String>();
	}
}
