package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import sistemaDeProduccion.MaquinaDeInferencia;
import sistemaDeProduccion.Regla;

import correccion.JazzySpellChecker;
import correccion.Util;

import normalizador.Normal;

public class Inicio {
	
	private static JFrame framePrincipal;
	private static JTextPane panelTextoMemoria;
	private static Normal normalizador;
	private static JazzySpellChecker corrector;
	private static MaquinaDeInferencia maquinaInferencia;
	
	private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());
	final static JTextArea log = new JTextArea(14,20);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
       
		normalizador = new Normal();
		corrector = new JazzySpellChecker();
		maquinaInferencia = new MaquinaDeInferencia();
		
		framePrincipal = new JFrame("Emergencia");

		framePrincipal.setLayout(new BorderLayout());
		framePrincipal.setMinimumSize(new Dimension(800, 400));
		framePrincipal.setPreferredSize(new Dimension(800, 400));
		framePrincipal.setSize(new Dimension(800, 400));
		framePrincipal.setLayout(new BorderLayout());
		
		JPanel panelPadre = new JPanel(new BorderLayout());
		panelPadre.setMinimumSize(new Dimension(800, 300));
		panelPadre.setMaximumSize(new Dimension(800, 300));
		panelPadre.setPreferredSize(new Dimension(800, 300));
		panelPadre.setSize(new Dimension(800, 300));
		framePrincipal.add(panelPadre, BorderLayout.NORTH);
		
		JPanel panelIzquierdo = new JPanel(new BorderLayout());
		panelIzquierdo.setMinimumSize(new Dimension(400, 150));
		panelIzquierdo.setMaximumSize(new Dimension(400, 150));
		panelIzquierdo.setPreferredSize(new Dimension(400, 150));
		panelIzquierdo.setSize(new Dimension(400, 150));
		panelPadre.add(panelIzquierdo, BorderLayout.WEST);
		
		// Logger
		JPanel panelDerecho = new JPanel(new BorderLayout());
		panelDerecho.setMinimumSize(new Dimension(350, 150));
		panelDerecho.setMaximumSize(new Dimension(350, 150));
		panelDerecho.setPreferredSize(new Dimension(350, 150));
		panelDerecho.setSize(new Dimension(350, 150));
		panelDerecho.setBorder(new EmptyBorder(30, 0, 20, 30));
		panelPadre.add(panelDerecho, BorderLayout.EAST);
		
		// Logger
        final JScrollPane scroll = new JScrollPane(log);
        panelDerecho.add(scroll);
        log.setBorder(new EmptyBorder(5, 5, 10, 5));
        log.setWrapStyleWord(true);
        log.setLineWrap(true);
        log.setEditable(false);
        
        JLabel labelLog = new JLabel("Log");
		panelDerecho.add(labelLog, BorderLayout.NORTH);
        
		
		JPanel panelTop = new JPanel(new BorderLayout());
		panelTop.setMinimumSize(new Dimension(400, 150));
		panelTop.setMaximumSize(new Dimension(400, 150));
		panelTop.setPreferredSize(new Dimension(400, 150));
		panelTop.setSize(new Dimension(400, 150));
		panelTop.setBorder(new EmptyBorder(30, 30, 20, 30));
		panelIzquierdo.add(panelTop, BorderLayout.NORTH);
		
		final JTextPane ingresoTexto = new JTextPane();
		ingresoTexto.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.LIGHT_GRAY, 2), new EmptyBorder(5, 5, 5, 5)));
		ingresoTexto.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// Tomar el texto y enviarlo a ser reconocido
					String ingreso= ingresoTexto.getText().trim();
					ArrayList<String> listaPalabras;
					if(!ingreso.equals("")){
						      
						// Revisar correctitud
						// Pasar el string a lista de palabras
						// Normalizar las palabras (plurales a singular, infinitivo)
						// Por cada palabra, buscarla en el HashMap, y sacar el valor
						// Agregar a la memoria de palabras reconocidas (MT)
						// Ejecutar la maquina de inferencia
						
						
						// Limpieza del texto
						ingresoTexto.setText("");
						
						//normalizador.normalizar(ingreso);
						listaPalabras = Util.listaPalabras(ingreso, normalizador, corrector);
						
						// Por cada palabra buscada, agregar a MT
						maquinaInferencia.addPalabras(listaPalabras);
						
						// Mostrar la actualización de palabras encontradas
						panelTextoMemoria.setText(maquinaInferencia.palabrasEncontradas());
						
						// Ejecutar la Maquina de Inferencia
						maquinaInferencia.ejecutar();
					}
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		panelTop.add(ingresoTexto);

		JLabel labelIngreso = new JLabel("Ingrese el texto");
		panelTop.add(labelIngreso, BorderLayout.NORTH);

		JPanel panelCenter = new JPanel(new BorderLayout());
		panelCenter.setMinimumSize(new Dimension(400, 150));
		panelCenter.setMaximumSize(new Dimension(400, 150));
		panelCenter.setPreferredSize(new Dimension(400, 150));
		panelCenter.setSize(new Dimension(400, 150));
		panelCenter.setBorder(new EmptyBorder(15, 30, 20, 30));
		panelIzquierdo.add(panelCenter, BorderLayout.SOUTH);

		//JPanel panelMemoria = new JPanel(new BorderLayout());
		//panelCenter.add(panelMemoria, BorderLayout.NORTH);

		JLabel labelMemoria = new JLabel("Palabras claves reconocidas");
		panelCenter.add(labelMemoria, BorderLayout.NORTH);

		panelTextoMemoria = new JTextPane();
		panelTextoMemoria.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.LIGHT_GRAY, 2), new EmptyBorder(5, 5, 5, 5)));
		panelTextoMemoria.setEditable(false);
		panelTextoMemoria.setBackground(framePrincipal.getBackground());
		panelTextoMemoria.setForeground(Color.DARK_GRAY);
		panelTextoMemoria.setText("");
		panelCenter.add(panelTextoMemoria, BorderLayout.CENTER);
		maquinaInferencia.setPanelMemoria(panelTextoMemoria);

		JPanel panelBot = new JPanel(new BorderLayout());
		panelBot.setMinimumSize(new Dimension(300, 60));
		panelBot.setMaximumSize(new Dimension(300, 60));
		panelBot.setPreferredSize(new Dimension(300, 60));
		panelBot.setSize(new Dimension(300, 60));
		panelBot.setBorder(new EmptyBorder(10, 200, 20, 200));
		framePrincipal.add(panelBot, BorderLayout.SOUTH);

		JButton btnEjecutar = new JButton("Reiniciar");
		btnEjecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Limpiar memoria y areas de texto
				maquinaInferencia.reiniciar();
				panelTextoMemoria.setText("");
				ingresoTexto.setText("");
			}
		});

		panelBot.add(btnEjecutar, BorderLayout.CENTER);

		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.pack();
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setVisible(true);
	}
	
	public static void ejecutarRegla(Regla regla){
		log("Regla ejecutada: "+ regla.toString());
	}
	
	public static void log(String cadena){
		String aux = log.getText();
		aux = aux+cadena+" .-\n";
		log.setText(aux);
		}
	
}
