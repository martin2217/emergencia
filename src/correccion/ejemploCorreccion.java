package correccion;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

import com.inet.jortho.SpellChecker;

public class ejemploCorreccion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String cadena1= "te voy a matarr!!! habia una vez un pequeñoo";
		String cadena2= "dame todaa la plataa, me esta pegandoo!";
		String cadena3= "me quiere robarr!";
		JazzySpellChecker corrector = new JazzySpellChecker();
		
		cadena1= corrector.getCorrectedText(cadena1);
		cadena2= corrector.getCorrectedText(cadena2);
		cadena3= corrector.getCorrectedText(cadena3);
		
		
		System.out.println ("Cadenas ya corregidas: " + cadena1 +
				", "+cadena2+ ", "+ cadena3);
	}

}
