package sistemaDeProduccion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import principal.Inicio;

public class Regla implements Comparable{
	
	public ArrayList<String> palabras;
	public String nombre;
	public int numero;
	public int tipo;
	
	public Regla(ArrayList<String> palabras, String nombre, int numero, int tipo){
		this.palabras=palabras;
		this.nombre=nombre;
		this.numero=numero;
		this.tipo=tipo;
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
			tipoString="hecho delictivo callejero";
			break;
		case 2:
			tipoString="hecho delictivo comercio y hogar";
			break;
		case 3:
			tipoString="violencia de genero";
			break;
		case 4:
			tipoString="caso de emergencia";
			break;
		}
		
		return nombre+" - "+tipoString;
	}
	
	@Override
	public int compareTo(Object arg0) {
		Regla reglaComparada = (Regla) arg0;
		return reglaComparada.palabras.size()-this.palabras.size();
	}
	
	public static ArrayList<Regla> inicializarReglas(){
		ArrayList<Regla> retorno = new ArrayList<Regla>();
		String accion;
		
		//Hechos delictivos Callejeros
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "robar")),"R1", 1, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "ladron")),"R2", 2, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("auxilio", "secuestrar")),"R3", 3, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "billetera")),"R4", 4, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "reloj")),"R5", 5, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "celular")),"R6", 6, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("llevar", "cartera")),"R7", 7, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "vehiculo")),"R8", 8, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "moto")),"R9", 9, 1));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("robar", "bicicleta")),"R10", 10, 1));
		
		//Hechos delictivos Comercio y hogar
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "toda", "dinero")),"R11", 11, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("abrir", "caja", "disparar")),"R12", 12, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "dinero")),"R13", 13, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("todos", "suelo")),"R14", 14, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("arriba", "manos")),"R15", 15, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "casa")),"R16", 16, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "ladron", "negocio")),"R17", 17, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("hablar", "matar")),"R18", 18, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("tener", "arma")),"R19", 19, 2));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dar", "todo", "ser", "matar")),"R20", 20, 2));
		
		//Violencia de genero
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ay", "no", "pegar")),"R21", 21, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("no", "lastimar")),"R22", 22, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("salir", "matar")),"R23", 23, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("dejar", "gritar", "meter", "disparar")),"R24", 24, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("socorro", "querer", "pegar")),"R25", 25, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "prender", "fuego")),"R26", 26, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ir", "quemar", "acido")),"R27", 27, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "querer", "matar")),"R28", 28, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("estar", "loco", "ir", "lastimar")),"R29", 29, 3));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("ayudar", "tener", "arma")),"R30", 30, 3));
		
		//Casos emergencia
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("fuego", "ayudar")),"R31", 31, 4));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("casa", "quemar")),"R32", 32, 4));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("haber", "incendio")),"R33", 33, 4));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("prender", "fuego")),"R34", 34, 4));
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("cuidar", "terremoto")),"R35", 35, 4));
		
		
		return retorno;
	}
}
