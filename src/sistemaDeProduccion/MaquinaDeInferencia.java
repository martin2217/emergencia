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
		// ejecuta la regla (agregar�a un alerta o accion final)
		
		// Devolver�a algo si se ejecut� un alerta o accion final
	}
}
