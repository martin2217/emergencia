package sistemaDeProduccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseDeConocimientos {
	
	// Memoria de trabajo
	public Set<String> palabrasEncontradas;
	public Set<Regla> reglasActivadas;
	
	// Memoria de producciones
	public HashMap<String, String> palabrasAEncontrar;
	public ArrayList<Regla> reglas;
	
	
	public BaseDeConocimientos(){
		inicializar();
		palabrasEncontradas = new LinkedHashSet<String>();
		reglasActivadas = new LinkedHashSet<Regla>();
		
	}
	
	private void inicializar(){
		// TODO Palabras a matchear - COMPLETAR
		palabrasAEncontrar= new LinkedHashMap<String, String>();
		reglas=Regla.inicializarReglas();
		Collections.sort(reglas);
		cargarPalabrasAEncontrar();
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
			palabrasEncontradas.add(aux); // mat�/mato, agregar�a matar
		}
	}
	public void addPalabras(ArrayList<String> palabras){
		for(String palabra: palabras){
			addPalabra(palabra);
		}
	}
	public String stringPalabrasEncontradas(){
		String retorno="";
		boolean ingreso=false;
		for(String palabra: palabrasEncontradas){
			ingreso=true;
			retorno+=palabra+" - ";
		}
		if (ingreso)
			retorno=retorno.substring(0, retorno.length()-3);
		return retorno;
	}
	
	private void cargarPalabrasAEncontrar(){
		palabrasAEncontrar.put("dame", "dar");
		palabrasAEncontrar.put("dar", "dar");
		palabrasAEncontrar.put("llevame", "llevar");
		palabrasAEncontrar.put("llevan", "llevar");
		palabrasAEncontrar.put("llevar", "llevar");
		palabrasAEncontrar.put("roba", "robar");
		palabrasAEncontrar.put("roban", "robar");
		palabrasAEncontrar.put("robo", "robar");
		palabrasAEncontrar.put("rob�", "robar");
		palabrasAEncontrar.put("robar", "robar");
		palabrasAEncontrar.put("robando", "robar");
		palabrasAEncontrar.put("robamos", "robar");
		palabrasAEncontrar.put("abr�", "abrir");
		palabrasAEncontrar.put("abrime", "abrir");
		palabrasAEncontrar.put("abrir", "abrir");
		palabrasAEncontrar.put("hay", "haber");
		palabrasAEncontrar.put("haber", "haber");
		palabrasAEncontrar.put("dec�s", "hablar");
		palabrasAEncontrar.put("dec�", "hablar");
		palabrasAEncontrar.put("hablar", "hablar");
		palabrasAEncontrar.put("tiene", "tener");
		palabrasAEncontrar.put("tienen", "tener");
		palabrasAEncontrar.put("tener", "tener");
		palabrasAEncontrar.put("sos", "ser");
		palabrasAEncontrar.put("ser", "ser");
		palabrasAEncontrar.put("pegues", "pegar");
		palabrasAEncontrar.put("pega", "pegar");
		palabrasAEncontrar.put("pegar", "pegar");
		palabrasAEncontrar.put("lastimes", "lastimar");
		palabrasAEncontrar.put("lastim�s", "lastimar");
		palabrasAEncontrar.put("last�ma", "lastimar");
		palabrasAEncontrar.put("lastimar", "lastimar");
		palabrasAEncontrar.put("salis", "salir");
		palabrasAEncontrar.put("salen", "salir");
		palabrasAEncontrar.put("sal�s", "salir");
		palabrasAEncontrar.put("salir", "salir");
		palabrasAEncontrar.put("mato", "matar");
		palabrasAEncontrar.put("matan", "matar");
		palabrasAEncontrar.put("matar", "matar");
		palabrasAEncontrar.put("dej�", "dejar");
		palabrasAEncontrar.put("dejen", "dejar");
		palabrasAEncontrar.put("dejar", "dejar");
		palabrasAEncontrar.put("grita", "gritar");
		palabrasAEncontrar.put("griten", "gritar");
		palabrasAEncontrar.put("gritar", "gritar");
		palabrasAEncontrar.put("meto", "meter");
		palabrasAEncontrar.put("meter", "meter");
		palabrasAEncontrar.put("quieren", "querer");
		palabrasAEncontrar.put("quiere", "querer");
		palabrasAEncontrar.put("querer", "querer");
		palabrasAEncontrar.put("voy", "ir");
		palabrasAEncontrar.put("vamos", "ir");
		palabrasAEncontrar.put("va", "ir");
		palabrasAEncontrar.put("van", "ir");
		palabrasAEncontrar.put("ir", "ir");
		palabrasAEncontrar.put("prendo", "prender");
		palabrasAEncontrar.put("prendemos", "prender");
		palabrasAEncontrar.put("prendi�", "prender");
		palabrasAEncontrar.put("prendieron", "prender");
		palabrasAEncontrar.put("prender", "prender");
		palabrasAEncontrar.put("quemo", "quemar");
		palabrasAEncontrar.put("quemamos", "quemar");
		palabrasAEncontrar.put("quema", "quemar");
		palabrasAEncontrar.put("quem�", "quemar");
		palabrasAEncontrar.put("quemar", "quemar");
		palabrasAEncontrar.put("est�", "estar");
		palabrasAEncontrar.put("est�n", "estar");
		palabrasAEncontrar.put("estar", "estar");
		palabrasAEncontrar.put("secuestra", "secuestrar");
		palabrasAEncontrar.put("secuestran", "secuestrar");
		palabrasAEncontrar.put("secuestrar", "secuestrar");
		palabrasAEncontrar.put("cuidado", "cuidar");
		palabrasAEncontrar.put("cuidar", "cuidar");
		palabrasAEncontrar.put("ayudame", "ayudar");
		palabrasAEncontrar.put("ayuda", "ayudar");
		palabrasAEncontrar.put("ayudanos", "ayudar");
		palabrasAEncontrar.put("ayudenme", "ayudar");
		palabrasAEncontrar.put("ayudar", "ayudar");
		palabrasAEncontrar.put("plata", "dinero");
		palabrasAEncontrar.put("guita", "dinero");
		palabrasAEncontrar.put("dinero", "dinero");
		palabrasAEncontrar.put("bici", "bicicleta");
		palabrasAEncontrar.put("bicicleta", "bicicleta");
		palabrasAEncontrar.put("auto", "vehiculo");
		palabrasAEncontrar.put("camioneta", "vehiculo");
		palabrasAEncontrar.put("vehiculo", "vehiculo");
		palabrasAEncontrar.put("asesinar", "matar");
		palabrasAEncontrar.put("boleta", "matar");
		palabrasAEncontrar.put("matar", "matar");
		palabrasAEncontrar.put("chorro", "ladron");
		palabrasAEncontrar.put("ladron", "ladron");
		palabrasAEncontrar.put("empresa", "negocio");
		palabrasAEncontrar.put("comercio", "negocio");
		palabrasAEncontrar.put("negocio", "negocio");
		palabrasAEncontrar.put("chumbo", "disparar");
		palabrasAEncontrar.put("disparar", "disparar");
		palabrasAEncontrar.put("celu", "celular");
		palabrasAEncontrar.put("celular", "celular");
		palabrasAEncontrar.put("cuchillo", "arma");
		palabrasAEncontrar.put("revolver", "arma");
		palabrasAEncontrar.put("pistola", "arma");
		palabrasAEncontrar.put("arma", "arma");
		palabrasAEncontrar.put("socorro", "socorro");
		palabrasAEncontrar.put("auxilio", "auxilio");
		palabrasAEncontrar.put("billetera", "billetera");
		palabrasAEncontrar.put("reloj", "reloj");
		palabrasAEncontrar.put("cartera", "cartera");
		palabrasAEncontrar.put("todo", "todo");
		palabrasAEncontrar.put("caja", "caja");
		palabrasAEncontrar.put("todos", "todos");
		palabrasAEncontrar.put("suelo", "suelo");
		palabrasAEncontrar.put("arriba", "arriba");
		palabrasAEncontrar.put("manos", "manos");
		palabrasAEncontrar.put("casa", "casa");
		palabrasAEncontrar.put("ay", "ay");
		palabrasAEncontrar.put("no", "no");
		palabrasAEncontrar.put("fuego", "fuego");
		palabrasAEncontrar.put("acido", "acido");
		palabrasAEncontrar.put("ayuda", "ayuda");
		palabrasAEncontrar.put("loco", "loco");
		palabrasAEncontrar.put("incendio", "incendio");
		palabrasAEncontrar.put("terremoto", "terremoto");
		palabrasAEncontrar.put("tiro", "disparo");
		palabrasAEncontrar.put("disparo", "disparo");
	}
	
}
