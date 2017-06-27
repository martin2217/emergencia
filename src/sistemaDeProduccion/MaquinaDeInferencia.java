package sistemaDeProduccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JTextPane;

public class MaquinaDeInferencia {
	
	private BaseDeConocimientos memoria;
	public JTextPane panelMemoria;
	
	public MaquinaDeInferencia(){
		memoria= new BaseDeConocimientos();
	}
	public void reiniciar(){
		memoria.reiniciar();
	}
	
	public void ejecutar(int formaResolucion){
		
		ArrayList<Regla> reglasQueCoinciden; // Matchean
		Regla reglaAEjecutar;
		
		// Recorre para todas las reglas que matchean
		// 		si no hay mas, termina
		while((reglasQueCoinciden = match()).size() > 0){
			
			// si hay, resuelve el conflicto (elije una)
			reglaAEjecutar = resolverConflicto(reglasQueCoinciden, formaResolucion);

			// ejecuta la regla (agregaría un alerta o accion final)
			reglaAEjecutar.ejecutar();
			
			// Agrega la regla como ejecutada --------y la acción realizada
			memoria.reglasActivadas.add(reglaAEjecutar);
		}
		//NO panelMemoria.setText(memoria.stringPalabrasEncontradas());
	}
	
	public void addPalabras(ArrayList<String> palabras){
		memoria.addPalabras(palabras);
	}
	public void setPanelMemoria(JTextPane panelMemoria){
		this.panelMemoria=panelMemoria;
	}
	public String palabrasEncontradas(){
		return memoria.stringPalabrasEncontradas();
	}
	
	// Recorrer todas las reglas y ver si matchean
	private ArrayList<Regla> match(){
		ArrayList<Regla> reglasQueCoinciden = new ArrayList<Regla>();
		for(Regla regla: memoria.reglas){
			// La regla matchea y todavía no fue activada
			if(regla.match(memoria.palabrasEncontradas)
					&& !memoria.reglasActivadas.contains(regla)){
				int i=0;
				for(String reg: regla.requiereReglas){
					if(memoria.reglasActivadas.contains(encontrarReglaPorString(reg))){
						i++;
					}
				}
				if(i==regla.requiereReglas.size())
					reglasQueCoinciden.add(regla);
			}
		}
		return reglasQueCoinciden;
	}
	
	private Regla resolverConflicto(ArrayList<Regla> reglas, int formaResolucion){
		switch (formaResolucion){
		case 1: // Normal, Prioridad -> Orden
			return reglas.get(0);
		case 2: // Aleatorio
			Random rand = new Random();
		    int randomNum = rand.nextInt(reglas.size());
		    return reglas.get(randomNum);
		}
		return reglas.get(0); //default
	}
	
	private Regla encontrarReglaPorString(String reglaString){
		Regla retorno = null;
		for(Regla regla: memoria.reglas){
			if(regla.nombre.equals(reglaString)){
				return regla;
			}
		}
		return retorno;
	}
}
