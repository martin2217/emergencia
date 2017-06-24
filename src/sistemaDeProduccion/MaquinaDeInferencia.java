package sistemaDeProduccion;

public class MaquinaDeInferencia {
	
	private BaseDeConocimientos memoria;
	
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
		// ejecuta la regla (agregaría un alerta o accion final)
		
		// Devolvería algo si se ejecutó un alerta o accion final
	}
}
