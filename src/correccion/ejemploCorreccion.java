package correccion;

import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

import normalizador.Normal;

import com.inet.jortho.SpellChecker;

public class ejemploCorreccion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String cadena1= "te vóy a matarr!!! había una vez un pequeñoo";
		String cadena2= "dame todaa la plataa, me esta pegandoo!";
		String cadena3= "me quiere robarr!";
		JazzySpellChecker corrector = new JazzySpellChecker();
		Normal normalizador = new Normal();
		
		ArrayList<String> aux2 = Util.listaPalabras(cadena1, normalizador, corrector);
		ArrayList<String> aux3 = Util.listaPalabras(cadena2, normalizador, corrector);
		
		java.util.ArrayList<String> aux;
		aux=Util.separarPalabras(cadena1);
		aux=Util.separarPalabras(cadena2);
		aux=Util.separarPalabras(cadena3);

		cadena1=Util.corregir1(cadena1, normalizador, corrector);
		cadena1= corrector.getCorrectedText(cadena1);
		cadena2= corrector.getCorrectedText(cadena2);
		cadena3= corrector.getCorrectedText(cadena3);

		aux=Util.separarPalabras(cadena1);
		aux=Util.separarPalabras(cadena2);
		aux=Util.separarPalabras(cadena3);
		
		System.out.println ("Cadenas ya corregidas: " + aux2 +
				", "+aux3+ ", "+ cadena3);
		
		
	}

}
