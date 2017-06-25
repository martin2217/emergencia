package correccion;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JEditorPane;

import com.inet.jortho.SpellChecker;
import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.WordIterator;



public class Z_prueba extends JApplet {
    @Override
    public void start() {
 
        JEditorPane text = new JEditorPane();
        text.setText( "This is a simppler textt with spellingg errors." );
        add( text );
        
        
        // Load the configuration and dictionaries from the current working directory and use the current locale or the first language as default 
    	//SpellChecker.registerDictionaries( null, null );
    	// Load the configuration and dictionaries from the sub directory "dict"
    	/*try {
			SpellChecker.registerDictionaries( new URL( "file", null, "resources" ), null );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
        //FILE LOCATION OF DICTIONARY
        String userDictionaryPath = "/dictionary/";

        //SET DICTIONARY PROVIDER FROM DICTIONARY PATH
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath));

        //REGISTER DICTIONARY
        SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "es");
		

        SpellChecker.enableAutoSpell(text, true);
        
        //SpellChecker.registerDictionaries( null, null);//this.getClass().getResource("/dictionary"),"es" );                
        SpellChecker.register( text );
        

        SpellChecker.enableAutoSpell(text, true);
        
        WordIterator iterador;
        /*try {
			iterador = new WordIterator(text, "comida casa cassa");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        String aux= "cassa";
        String aux2 = aux;
    }
}

	