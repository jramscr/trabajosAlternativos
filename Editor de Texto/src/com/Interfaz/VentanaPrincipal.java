/**
 * Desarrollado por: Jesús Enrique Ramos Cruz
 * Programa con fines acádemicos para el
 * entendimiento de ciertas características
 * del programa java y una utilización
 * variable del patrón MVC.
 * San José, Costa Rica, 2014.
 * Versión: 1.0
 * **/

package com.Interfaz;

//Importaciones
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import com.Controlador.Controller_Ventana_Principal;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {
	//Atributos.
	private static final long serialVersionUID = 1L;
	private JPanel panelContenedor;
	private JMenuBar barraDeMenu;
	private JScrollPane Scroll;
	private JTextArea textArea;
	private JMenu menuArchivo;
	private JMenu menuEdicion;
	private JMenu menuFormato;
	private JMenu menuAyuda;
	private JMenuItem itemAyuda;
	private JMenuItem itemAcercaDe;
	private JMenuItem itemFuente;
	private JMenuItem itemColor;
	private JMenuItem itemCopiar;
	private JMenuItem itemCortar;
	private JMenuItem itemPegar;
	private JMenuItem itemSeleccionarTodo;
	private JMenuItem itemNuevo;
	private JMenuItem itemAbrir;
	private JMenuItem itemGuardar;
	private JMenuItem itemSalir;
	private JSeparator separador_0;
	private JMenuItem itemMayusculas;
	private JMenuItem itemMinusculas;
	private JSeparator separador_1;
	private JSeparator separador_3;
	private Controller_Ventana_Principal controlador;

	//Levanta la ventana principal "Editor de Texto"
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal EditordeTexto = new VentanaPrincipal();
					EditordeTexto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructor que levanta la ventana principal, el controlador e indexa(integra) el paquete de acciones.
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/com/Recursos/logo_TextEditor.png")));
		elementosVentana();
		controlador= new Controller_Ventana_Principal(this);
        integrarEventos();
	}

	//Construcción de los elementos de la clase para la ventana a mostrar.
	public void elementosVentana(){
		setTitle("TextEditor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Fachada.Nimbus();
		
		barraDeMenu = new JMenuBar();
		setJMenuBar(barraDeMenu);
		
		menuArchivo = new JMenu("Archivo");
		barraDeMenu.add(menuArchivo);
		
		itemNuevo = new JMenuItem("Nuevo");
		itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuArchivo.add(itemNuevo);
		
		itemAbrir = new JMenuItem("Abrir");
		itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuArchivo.add(itemAbrir);
		
		itemGuardar = new JMenuItem("Guardar");
		itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		menuArchivo.add(itemGuardar);
		
		separador_3 = new JSeparator();
		menuArchivo.add(separador_3);
		
		itemSalir = new JMenuItem("Salir");
		itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		menuArchivo.add(itemSalir);
		
		menuEdicion = new JMenu("Edici\u00F3n");
		barraDeMenu.add(menuEdicion);
		
		itemMayusculas = new JMenuItem("May\u00FAsculas");
		itemMayusculas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		menuEdicion.add(itemMayusculas);
		
		itemMinusculas = new JMenuItem("Min\u00FAsculas");
		itemMinusculas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.SHIFT_MASK));
		menuEdicion.add(itemMinusculas);
		
		separador_1 = new JSeparator();
		menuEdicion.add(separador_1);
		
		itemCopiar = new JMenuItem("Copiar");
		itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		menuEdicion.add(itemCopiar);
		
		itemCortar = new JMenuItem("Cortar");
		itemCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		menuEdicion.add(itemCortar);
		
		itemPegar = new JMenuItem("Pegar");
		itemPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		menuEdicion.add(itemPegar);
		
		separador_0 = new JSeparator();
		menuEdicion.add(separador_0);
		
		itemSeleccionarTodo = new JMenuItem("Seleccionar todo");
		itemSeleccionarTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuEdicion.add(itemSeleccionarTodo);
		
		menuFormato = new JMenu("Formato");
		barraDeMenu.add(menuFormato);
		
		itemFuente = new JMenuItem("Fuente");
		menuFormato.add(itemFuente);
		
		itemColor = new JMenuItem("Color");
		menuFormato.add(itemColor);
		
		menuAyuda = new JMenu("Ayuda");
		barraDeMenu.add(menuAyuda);
		
		itemAyuda = new JMenuItem("Ayuda");
		menuAyuda.add(itemAyuda);
		
		itemAcercaDe = new JMenuItem("Acerca de...");
		menuAyuda.add(itemAcercaDe);
		panelContenedor = new JPanel();
		panelContenedor.setBackground(Color.WHITE);
		panelContenedor.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(panelContenedor);
		panelContenedor.setLayout(new BorderLayout(0, 0));
		
		Scroll = new JScrollPane();
		panelContenedor.add(Scroll);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		Scroll.setViewportView(textArea);
		
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

	//Se le integran los eventos concurrentes de cada componente a la vista.
	private void integrarEventos() {
		itemAbrir.addActionListener(controlador);
		itemAcercaDe.addActionListener(controlador);
		itemAyuda.addActionListener(controlador);
		itemColor.addActionListener(controlador);
		itemCopiar.addActionListener(controlador);
		itemCortar.addActionListener(controlador);
		itemFuente.addActionListener(controlador);
		itemGuardar.addActionListener(controlador);
		itemMayusculas.addActionListener(controlador);
		itemMinusculas.addActionListener(controlador);
		itemNuevo.addActionListener(controlador);
		itemPegar.addActionListener(controlador);
		itemSalir.addActionListener(controlador);
		itemSeleccionarTodo.addActionListener(controlador);
	}
	
	//Métodos getter's y setter's.
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JMenuItem getItemAyuda() {
		return itemAyuda;
	}

	public void setItemAyuda(JMenuItem itemAyuda) {
		this.itemAyuda = itemAyuda;
	}

	public JMenuItem getItemAcercaDe() {
		return itemAcercaDe;
	}

	public void setItemAcercaDe(JMenuItem itemAcercaDe) {
		this.itemAcercaDe = itemAcercaDe;
	}

	public JMenuItem getItemFuente() {
		return itemFuente;
	}

	public void setItemFuente(JMenuItem itemFuente) {
		this.itemFuente = itemFuente;
	}

	public JMenuItem getItemColor() {
		return itemColor;
	}

	public void setItemColor(JMenuItem itemColor) {
		this.itemColor = itemColor;
	}

	public JMenuItem getItemCopiar() {
		return itemCopiar;
	}

	public void setItemCopiar(JMenuItem itemCopiar) {
		this.itemCopiar = itemCopiar;
	}

	public JMenuItem getItemCortar() {
		return itemCortar;
	}

	public void setItemCortar(JMenuItem itemCortar) {
		this.itemCortar = itemCortar;
	}

	public JMenuItem getItemPegar() {
		return itemPegar;
	}

	public void setItemPegar(JMenuItem itemPegar) {
		this.itemPegar = itemPegar;
	}

	public JMenuItem getItemSeleccionarTodo() {
		return itemSeleccionarTodo;
	}

	public void setItemSeleccionarTodo(JMenuItem itemSeleccionarTodo) {
		this.itemSeleccionarTodo = itemSeleccionarTodo;
	}

	public JMenuItem getItemNuevo() {
		return itemNuevo;
	}

	public void setItemNuevo(JMenuItem itemNuevo) {
		this.itemNuevo = itemNuevo;
	}

	public JMenuItem getItemAbrir() {
		return itemAbrir;
	}

	public void setItemAbrir(JMenuItem itemAbrir) {
		this.itemAbrir = itemAbrir;
	}

	public JMenuItem getItemGuardar() {
		return itemGuardar;
	}

	public void setItemGuardar(JMenuItem itemGuardar) {
		this.itemGuardar = itemGuardar;
	}

	public JMenuItem getItemSalir() {
		return itemSalir;
	}

	public void setItemSalir(JMenuItem itemSalir) {
		this.itemSalir = itemSalir;
	}

	public JMenuItem getItemMayusculas() {
		return itemMayusculas;
	}

	public void setItemMayusculas(JMenuItem itemMayusculas) {
		this.itemMayusculas = itemMayusculas;
	}

	public JMenuItem getItemMinusculas() {
		return itemMinusculas;
	}

	public void setItemMinusculas(JMenuItem itemMinusculas) {
		this.itemMinusculas = itemMinusculas;
	}
}
