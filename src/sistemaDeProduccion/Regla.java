package sistemaDeProduccion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import principal.Inicio;

public class Regla implements Comparable{
	
	public ArrayList<String> palabras;
	public ArrayList<String> requiereReglas;
	public String nombre;
	public String accion;
	public int numero;
	public int tipo;
	
	public static final String GPS = "Activar GPS";
	public static final String LLAMAR_FAM = "Llamar a familiar";
	public static final String GRABAR = "Activar micrófono";

	public static final String GENERAR_AUDIO = "Generar audio";
	public static final String LLAMAR_911 = "Llamar al 911";
	public static final String ALARMA_VECINAL = "Activar alarma vecinal";
	
	public static final String LLAMAR_BOMB = "Llamar a los bomberos";
	
	public Regla(ArrayList<String> palabras, String nombre, String accion, int numero, int tipo, ArrayList<String> reglas){
		this.palabras=palabras;
		this.nombre=nombre;
		this.accion=accion;
		this.numero=numero;
		this.tipo=tipo;
		this.requiereReglas=reglas;
	}
	
	public boolean match(Set<String> palabrasEncontradas){
		int cantMatcheos=0;
		for(String palabra: palabras){
			if(palabrasEncontradas.contains(palabra)){
				cantMatcheos++;
			}
		}
		// Si la cantidad de matcheos coincide con la cantidad de palabras que tiene le regla
		return cantMatcheos >= palabras.size(); //>= por si hay palabras repetidas en la regla
	}
	
	public void ejecutar(){
		Inicio.ejecutarRegla(this);
		//System.out.println("Regla ejecutada: "+ toString());
	}
	public String toString(){
		String tipoString="";
		switch(tipo){
		case 1:
			tipoString="Hecho delictivo callejero";
			break;
		case 2:
			tipoString="Hecho delictivo comercio y hogar";
			break;
		case 3:
			tipoString="Violencia de genero";
			break;
		case 4:
			tipoString="Caso de emergencia";
			break;
		}
		
		return nombre+" - " + accion + " - "+tipoString;
	}
	
	@Override
	public int compareTo(Object arg0) {
		Regla reglaComparada = (Regla) arg0;
		return reglaComparada.palabras.size()-this.palabras.size();
	}
	
	public static ArrayList<Regla> inicializarReglas(){
		ArrayList<Regla> retorno = new ArrayList<Regla>();
		String accion;
		
		ArrayList<String> vacio= new ArrayList<String>();
		
		//Hechos delictivos Callejeros
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "robar")),"R1a",GPS, 1, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "robar")),"R1b",LLAMAR_FAM, 1, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "robar")),"R1c",GRABAR, 1, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "ladron")),"R2a",GPS, 2, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "ladron")),"R2b",LLAMAR_FAM, 2, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "ladron")),"R2c",GRABAR, 2, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("auxilio", "secuestrar")),"R3a",GPS, 3, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("auxilio", "secuestrar")),"R3b",LLAMAR_FAM, 3, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("auxilio", "secuestrar")),"R3c",GRABAR, 3, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "billetera")),"R4a",GPS, 4, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "billetera")),"R4b",LLAMAR_FAM, 4, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "billetera")),"R4c",GRABAR, 4, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "reloj")),"R5a",GPS, 5, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "reloj")),"R5b",LLAMAR_FAM, 5, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "reloj")),"R5c",GRABAR, 5, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "celular")),"R6a",GPS, 6, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "celular")),"R6b",LLAMAR_FAM, 6, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "celular")),"R6c",GRABAR, 6, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("llevar", "cartera")),"R7a",GPS, 7, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("llevar", "cartera")),"R7b",LLAMAR_FAM, 7, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("llevar", "cartera")),"R7c",GRABAR, 7, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "vehiculo")),"R8a",GPS, 8, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "vehiculo")),"R8b",LLAMAR_FAM, 8, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "vehiculo")),"R8c",GRABAR, 8, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "moto")),"R9a",GPS, 9, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "moto")),"R9b",LLAMAR_FAM, 9, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "moto")),"R9c",GRABAR, 9, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "bicicleta")),"R10a",GPS, 10, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "bicicleta")),"R10b",LLAMAR_FAM, 10, 1,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "bicicleta")),"R10c",GRABAR, 10, 1,vacio));
		
		//Hechos delictivos Comercio y hogar
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "toda", "dinero")),"R11a",GENERAR_AUDIO, 11, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "toda", "dinero")),"R11b",LLAMAR_911, 11, 2,new ArrayList<String>(Arrays.asList("R11a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "toda", "dinero")),"R11c",ALARMA_VECINAL, 11, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("abrir", "caja", "disparar")),"R12a",GENERAR_AUDIO, 12, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("abrir", "caja", "disparar")),"R12b",LLAMAR_911, 12, 2,new ArrayList<String>(Arrays.asList("R12a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("abrir", "caja", "disparar")),"R12c",ALARMA_VECINAL, 12, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "dinero")),"R13a",GENERAR_AUDIO, 13, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "dinero")),"R13b",LLAMAR_911, 13, 2,new ArrayList<String>(Arrays.asList("R13a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "dinero")),"R13c",ALARMA_VECINAL, 13, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("todos", "suelo")),"R14a",GENERAR_AUDIO, 14, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("todos", "suelo")),"R14b",LLAMAR_911, 14, 2,new ArrayList<String>(Arrays.asList("R14a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("todos", "suelo")),"R14c",ALARMA_VECINAL, 14, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("arriba", "manos")),"R15a",GENERAR_AUDIO, 15, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("arriba", "manos")),"R15b",LLAMAR_911, 15, 2,new ArrayList<String>(Arrays.asList("R15a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("arriba", "manos")),"R15c",ALARMA_VECINAL, 15, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "casa")),"R16a",GENERAR_AUDIO, 16, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "casa")),"R16b",LLAMAR_911, 16, 2,new ArrayList<String>(Arrays.asList("R16a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "casa")),"R16c",ALARMA_VECINAL, 16, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "negocio")),"R17a",GENERAR_AUDIO, 17, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "negocio")),"R17b",LLAMAR_911, 17, 2,new ArrayList<String>(Arrays.asList("R17a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "negocio")),"R17c",ALARMA_VECINAL, 17, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("hablar", "matar")),"R18a",GENERAR_AUDIO, 18, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("hablar", "matar")),"R18b",LLAMAR_911, 18, 2,new ArrayList<String>(Arrays.asList("R18a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("hablar", "matar")),"R18c",ALARMA_VECINAL, 18, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("tener", "arma")),"R19a",GENERAR_AUDIO, 19, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("tener", "arma")),"R19b",LLAMAR_911, 19, 2,new ArrayList<String>(Arrays.asList("R19a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("tener", "arma")),"R19c",ALARMA_VECINAL, 19, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "todo", "ser", "matar")),"R20a",GENERAR_AUDIO, 20, 2,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "todo", "ser", "matar")),"R20b",LLAMAR_911, 20, 2,new ArrayList<String>(Arrays.asList("R20a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "todo", "ser", "matar")),"R20c",ALARMA_VECINAL, 20, 2,vacio));
		
		//Violencia de genero
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ay", "no", "pegar")),"R21a",GRABAR, 21, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ay", "no", "pegar")),"R21b",LLAMAR_911, 21, 3,new ArrayList<String>(Arrays.asList("R21a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ay", "no", "pegar")),"R21c",LLAMAR_FAM, 21, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("no", "lastimar")),"R22a",GRABAR, 22, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("no", "lastimar")),"R22b",LLAMAR_911, 22, 3,new ArrayList<String>(Arrays.asList("R22a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("no", "lastimar")),"R22c",LLAMAR_FAM, 22, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("salir", "matar")),"R23a",GRABAR, 23, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("salir", "matar")),"R23b",LLAMAR_911, 23, 3,new ArrayList<String>(Arrays.asList("R23a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("salir", "matar")),"R23c",LLAMAR_FAM, 23, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dejar", "gritar", "meter", "disparar")),"R24a",GRABAR, 24, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dejar", "gritar", "meter", "disparar")),"R24b",LLAMAR_911, 24, 3,new ArrayList<String>(Arrays.asList("R24a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dejar", "gritar", "meter", "disparar")),"R24c",LLAMAR_FAM, 24, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "querer", "pegar")),"R25a",GRABAR, 25, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "querer", "pegar")),"R25b",LLAMAR_911, 25, 3,new ArrayList<String>(Arrays.asList("R25a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "querer", "pegar")),"R25c",LLAMAR_FAM, 25, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "prender", "fuego")),"R26a",GRABAR, 26, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "prender", "fuego")),"R26b",LLAMAR_911, 26, 3,new ArrayList<String>(Arrays.asList("R26a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "prender", "fuego")),"R26c",LLAMAR_FAM, 26, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "quemar", "acido")),"R27a",GRABAR, 27, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "quemar", "acido")),"R27b",LLAMAR_911, 27, 3,new ArrayList<String>(Arrays.asList("R27a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "quemar", "acido")),"R27c",LLAMAR_FAM, 27, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "querer", "matar")),"R28a",GRABAR, 28, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "querer", "matar")),"R28b",LLAMAR_911, 28, 3,new ArrayList<String>(Arrays.asList("R28a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "querer", "matar")),"R28c",LLAMAR_FAM, 28, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("estar", "loco", "ir", "lastimar")),"R29a",GRABAR, 29, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("estar", "loco", "ir", "lastimar")),"R29b",LLAMAR_911, 29, 3,new ArrayList<String>(Arrays.asList("R29a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("estar", "loco", "ir", "lastimar")),"R29c",LLAMAR_FAM, 29, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "tener", "arma")),"R30a",GRABAR, 30, 3,vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "tener", "arma")),"R30b",LLAMAR_911, 30, 3,new ArrayList<String>(Arrays.asList("R30a"))));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "tener", "arma")),"R30c",LLAMAR_FAM, 30, 3,vacio));
		
		//Casos emergencia
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("fuego", "ayudar")),"R31",LLAMAR_BOMB, 31, 4, vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("casa", "quemar")),"R32",LLAMAR_BOMB, 32, 4, vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "incendio")),"R33",LLAMAR_BOMB, 33, 4, vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "prender", "fuego")),"R34",LLAMAR_BOMB, 34, 4, vacio));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("cuidar", "terremoto")),"R35",LLAMAR_BOMB, 35, 4, vacio));
		
		
		return retorno;
	}
}
