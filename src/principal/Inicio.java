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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import sistemaDeProduccion.MaquinaDeInferencia;

import correccion.JazzySpellChecker;
import correccion.Util;

import normalizador.Normal;

public class Inicio {
	
	private static JFrame framePrincipal;
	private static JTextPane panelTextoMemoria;
	private static Normal normalizador;
	private static JazzySpellChecker corrector;
	private static MaquinaDeInferencia maquinaInferencia;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
       
		normalizador = new Normal();
		corrector = new JazzySpellChecker();
		maquinaInferencia = new MaquinaDeInferencia();
		
		framePrincipal = new JFrame("Emergencia");

		framePrincipal.setLayout(new BorderLayout());
		framePrincipal.setMinimumSize(new Dimension(700, 400));
		framePrincipal.setPreferredSize(new Dimension(700, 400));
		framePrincipal.setSize(new Dimension(700, 400));
		framePrincipal.setLayout(new BorderLayout());

		JPanel panelTop = new JPanel(new BorderLayout());
		panelTop.setMinimumSize(new Dimension(400, 150));
		panelTop.setMaximumSize(new Dimension(400, 150));
		panelTop.setPreferredSize(new Dimension(400, 150));
		panelTop.setSize(new Dimension(400, 150));
		panelTop.setBorder(new EmptyBorder(30, 30, 20, 30));
		framePrincipal.add(panelTop, BorderLayout.NORTH);
		
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
						
						normalizador.normalizar(ingreso);
						listaPalabras = Util.listaPalabras(ingreso, normalizador, corrector);
						
						// Por cada palabra buscada, agregar a MT
						maquinaInferencia.addPalabras(listaPalabras);
						
						// Mostrar la actualización de palabras encontradas
						panelTextoMemoria.setText(maquinaInferencia.palabrasEncontradas());
						
						// TODO Ejecutar la Maquina de Inferencia
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
		panelCenter.setMinimumSize(new Dimension(400, 100));
		panelCenter.setMaximumSize(new Dimension(400, 100));
		panelCenter.setPreferredSize(new Dimension(400, 100));
		panelCenter.setSize(new Dimension(400, 100));
		panelCenter.setBorder(new EmptyBorder(15, 30, 20, 30));
		framePrincipal.add(panelCenter, BorderLayout.CENTER);

		//JPanel panelMemoria = new JPanel(new BorderLayout());
		//panelCenter.add(panelMemoria, BorderLayout.NORTH);

		JLabel labelMemoria = new JLabel("Palabras reconocidas");
		panelCenter.add(labelMemoria, BorderLayout.NORTH);

		panelTextoMemoria = new JTextPane();
		panelTextoMemoria.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.LIGHT_GRAY, 2), new EmptyBorder(5, 5, 5, 5)));
		panelTextoMemoria.setEditable(false);
		panelTextoMemoria.setBackground(framePrincipal.getBackground());
		panelTextoMemoria.setForeground(Color.DARK_GRAY);
		panelTextoMemoria.setText("casa");
		panelCenter.add(panelTextoMemoria, BorderLayout.CENTER);
		maquinaInferencia.setPanelMemoria(panelTextoMemoria);

		JPanel panelBot = new JPanel(new BorderLayout());
		panelBot.setMinimumSize(new Dimension(300, 60));
		panelBot.setMaximumSize(new Dimension(300, 60));
		panelBot.setPreferredSize(new Dimension(300, 60));
		panelBot.setSize(new Dimension(300, 60));
		panelBot.setBorder(new EmptyBorder(10, 100, 20, 100));
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
}
