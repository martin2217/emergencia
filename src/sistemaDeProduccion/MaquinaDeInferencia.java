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
		
		// Recorrer todas las reglas y ver si matchean
		// hay reglas?
			// si no hay, termina
		// si hay, resuelve el conflicto (elije una)
		// ejecuta la regla (agregar�a un alerta o accion final)
		
		// Devolver�a algo si se ejecut� un alerta o accion final
		
		
		panelMemoria.setText(memoria.stringPalabrasEncontradas());
	}
	
	public void addPalabras(ArrayList<String> palabras){
		memoria.addPalabras(palabras);
	}
	public void setPanelMemoria(JTextPane panelMemoria){
		this.panelMemoria=panelMemoria;
	}
}
