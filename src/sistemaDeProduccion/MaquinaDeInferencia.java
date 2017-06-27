package sistemaDeProduccion;

import java.util.ArrayList;
import java.util.List;

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
	
	public void ejecutar(){
		
		ArrayList<Regla> reglasQueCoinciden; // Matchean
		Regla reglaAEjecutar;
		
		// Recorre para todas las reglas que matchean
		// 		si no hay mas, termina
		while((reglasQueCoinciden = match()).size() > 0){
			
			// si hay, resuelve el conflicto (elije una)
			reglaAEjecutar = resolverConflicto(reglasQueCoinciden);

			// ejecuta la regla (agregaría un alerta o accion final)
			reglaAEjecutar.ejecutar();
			
			// Agrega la regla como ejecutada y la acción realizada
			memoria.reglasActivadas.add(reglaAEjecutar);
			memoria.accionesRealizadas.add(reglaAEjecutar.accion);
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
				reglasQueCoinciden.add(regla);
			}
		}
		return reglasQueCoinciden;
	}
	
	private Regla resolverConflicto(ArrayList<Regla> reglas){
		// TODO resolver bien el conflicto
		// Ahora toma la primera en la lista
		return reglas.get(0);
	}
}
