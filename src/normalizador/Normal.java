package normalizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Normal {
	private static HashMap<String,String> verbos;
	private static HashMap<String,String> sinonimos;
	private List<String> noIncluir;
	
	public Normal() {
		verbos = new HashMap<String,String>();
	    sinonimos = new HashMap<String,String>();
	    noIncluir = new ArrayList<String>();
	    
	    cargarVerbos();
	    cargarSinonimos();
        cargarNoIncluir();
	}

	private void cargarVerbos() {
		verbos.clear();
		verbos.put("dame", "dar");
		verbos.put("llevame", "llevar");
		verbos.put("llevan", "llevar");
		verbos.put("roba", "robar");
		verbos.put("roban", "robar");
		verbos.put("robo", "robar");
		verbos.put("robó", "robar");
		verbos.put("abrí", "abrir");
		verbos.put("abrime", "abrir");
		verbos.put("hay", "haber");
		verbos.put("decís", "hablar");
		verbos.put("decí", "hablar");
		verbos.put("tiene", "tener");
		verbos.put("tienen", "tener");
		verbos.put("sos", "ser");
		verbos.put("son", "ser");
		verbos.put("pegues", "pegar");
		verbos.put("pega", "pegar");
		verbos.put("lastimes", "lastimar");
		verbos.put("lastimás", "lastimar");
		verbos.put("lastíma", "lastimar");
		verbos.put("salis", "salir");
		verbos.put("salen", "salir");
		verbos.put("salís", "salir");
		verbos.put("mato", "matar");
		verbos.put("matan", "matar");
		verbos.put("dejá", "dejar");
		verbos.put("dejen", "dejar");
		verbos.put("grita", "gritar");
		verbos.put("griten", "gritar");
		verbos.put("meto", "meter");
		verbos.put("quieren", "querer");
		verbos.put("quiere", "querer");
		verbos.put("voy", "ir");
		verbos.put("vamos", "ir");
		verbos.put("va", "ir");
		verbos.put("van", "ir");
		verbos.put("prendo", "prender");
		verbos.put("prendemos", "prender");
		verbos.put("prendió", "prender");
		verbos.put("prendieron", "prender");
		verbos.put("quemo", "quemar");
		verbos.put("quemamos", "quemar");
		verbos.put("quema", "quemar");
		verbos.put("quemó", "quemar");
		verbos.put("está", "estar");
		verbos.put("están", "estar");
		verbos.put("secuestra", "secuestrar");
		verbos.put("secuestran", "secuestrar");
		verbos.put("cuidado", "cuidar");
		verbos.put("ayudame", "ayudar");
		verbos.put("ayuda", "ayudar");
		verbos.put("ayudanos", "ayudar");
		verbos.put("ayudenme", "ayudar");
	}

	private void cargarSinonimos() {
		sinonimos.clear();
		sinonimos.put("plata", "dinero");
		sinonimos.put("guita", "dinero");
		sinonimos.put("bici", "bicicleta");
		sinonimos.put("auto", "vehiculo");
		sinonimos.put("camioneta", "vehiculo");
		sinonimos.put("asesinar", "matar");
		sinonimos.put("boleta", "matar");
		sinonimos.put("chorro", "ladron");
		sinonimos.put("empresa", "negocio");
		sinonimos.put("comercio", "negocio");
		sinonimos.put("chumbo", "disparar");
		sinonimos.put("celu", "celular");
		sinonimos.put("cuchillo", "arma");
		sinonimos.put("revolver", "arma");
		sinonimos.put("pistola", "arma");
	}

	private void cargarNoIncluir() {
		noIncluir.add("en");
		noIncluir.add("ante");
		noIncluir.add("con");
		noIncluir.add("contra");
		noIncluir.add("de");
		noIncluir.add("desde");
		noIncluir.add("hacia");
		noIncluir.add("hasta");
		noIncluir.add("para");
		noIncluir.add("por");
		noIncluir.add("sin");
		noIncluir.add("sobre");
		noIncluir.add("tras");
		noIncluir.add("un");
		noIncluir.add("me");
		noIncluir.add("te");
		noIncluir.add("la");
		noIncluir.add("las");
		noIncluir.add("el");
		noIncluir.add("los");
		noIncluir.add("se");
		noIncluir.add("si");
	}

	public List<String> normalizar(String frase) {
		List<String> fraseNormalizada = new ArrayList<String>();
		String delimitadores = "[ .,;?!¡¿\'\"\\[\\]]+";
		String[] palabrasSeparadas = frase.split(delimitadores);

		for (int i = 0; i < palabrasSeparadas.length; i++) {
			if (palabrasSeparadas[i].length() > 1) {
				// Si es un verbo conjugado
				if (verbos.containsKey(palabrasSeparadas[i].toLowerCase())) {
					fraseNormalizada.add(verbos.get(palabrasSeparadas[i]
							.toLowerCase()));
				}
				else {
					// Si es un sinonimo
					if (sinonimos.containsKey(palabrasSeparadas[i]
							.toLowerCase())) {
						fraseNormalizada.add(sinonimos.get(palabrasSeparadas[i]
								.toLowerCase()));
					}
					// Por defecto agrega la palabra en minuscula si no esta en
					// la lista de no incluir
					else {
						if (!noIncluir.contains(palabrasSeparadas[i]
								.toLowerCase())) {
							fraseNormalizada.add(palabrasSeparadas[i]
									.toLowerCase());
						}

					}
				}
			}

		}
		
		return fraseNormalizada;
	}
		
}
