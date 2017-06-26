package sistemaDeProduccion;

import java.util.ArrayList;
import java.util.Arrays;

public class Regla {
	
	public ArrayList<String> palabras;
	public String nombre;
	public int numero;
	
	public Regla(ArrayList<String> palabras, String nombre, int numero){
		this.palabras=palabras;
		this.nombre=nombre;
		this.numero=numero;
	}
	
	public boolean Match(){
		return false;
	}
	public void Ejecutar(){
		
	}
	
	public static ArrayList<Regla> inicializarReglas(){
		ArrayList<Regla> retorno = new ArrayList<Regla>();
		//Hechos delictivos Callejeros
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "robar")),"R1", 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "ladron")),"R2", 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("auxilio", "secuestrar")),"R3", 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "billetera")),"R4", 4));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "reloj")),"R5", 5));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "celular")),"R6", 6));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("llevar", "cartera")),"R7", 7));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "vehiculo")),"R8", 8));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "moto")),"R9", 9));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "bicicleta")),"R10", 10));
		
		//Hechos delictivos Comercio y hogar
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "toda", "dinero")),"R11", 11));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("abrir", "caja", "disparar")),"R12", 12));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "dinero")),"R13", 13));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("todos", "suelo")),"R14", 14));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("arriba", "manos")),"R15", 15));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "casa")),"R16", 16));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "negocio")),"R17", 17));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("hablar", "matar")),"R18", 18));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("tener", "arma")),"R19", 19));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "todo", "ser", "matar")),"R20", 20));
		
		//Violencia de genero
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ay", "no", "pegar")),"R21", 21));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("no", "lastimar")),"R22", 22));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("salir", "matar")),"R23", 23));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dejar", "gritar", "meter", "disparar")),"R24", 24));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "querer", "pegar")),"R25", 25));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "prender", "fuego")),"R26", 26));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "quemar", "acido")),"R27", 27));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "querer", "matar")),"R28", 28));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("estar", "loco", "ir", "lastimar")),"R29", 29));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "tener", "arma")),"R30", 30));
		
		//Casos emergencia
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("fuego", "ayudar")),"R31", 31));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("casa", "quemar")),"R32", 32));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "incendio")),"R33", 33));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("prender", "fuego")),"R34", 34));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("cuidar", "terremoto")),"R35", 35));
		
		
		return retorno;
	}
}
