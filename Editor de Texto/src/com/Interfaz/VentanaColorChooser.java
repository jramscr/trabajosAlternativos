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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;


public class VentanaColorChooser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Contenedor;
	private JButton botonCancelar;
	private JButton botonEscoger;
	private JPanel panelBotones;
	private JPanel panelColores;

	public VentanaColorChooser(final JTextArea areaTexto) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaColorChooser.class.getResource("/com/Recursos/logo_TextEditor.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 517);
		Contenedor = new JPanel();
		Contenedor.setBackground(Color.WHITE);
		Contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		Contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(Contenedor);
		Fachada.Nimbus();
		
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.WHITE);
		panelBotones.setBorder(new EmptyBorder(1, 5, 1, 5));
		Contenedor.add(panelBotones, BorderLayout.SOUTH);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		botonEscoger = new JButton("Escoger");
		botonEscoger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color nuevoColor = ColorChooser.colorNuevo;
				areaTexto.setForeground(nuevoColor);
				dispose();
			}
		});
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBotones.add(botonCancelar);
		panelBotones.add(botonEscoger);
		
		panelColores = new ColorChooser();
		Contenedor.add(panelColores, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
	}

}
