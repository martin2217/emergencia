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
		
		retorno.add(new Regla(new ArrayList<String>(Arrays.asList("matar", "comer")),
				"R1", 1));
		
		return retorno;
	}
}
