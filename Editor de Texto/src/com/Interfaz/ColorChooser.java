/************************************************************
 * Tomado de la red con fines acádemicos. 
 * 
 * Clase utilizada con fines acádemicos por Jesús Ramos Cruz.
 ************************************************************/

package com.Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ColorChooser extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private static JColorChooser escogedorColor;
	private JLabel encabezado;
	public static Color colorNuevo;

	public ColorChooser() {
		super();
		setBackground(Color.WHITE);
		Fachada.Nimbus();
		//Inicializar el encabezado.
		encabezado = new JLabel("Escoger un color de Texto", JLabel.CENTER);
		encabezado.setForeground(Color.BLUE);
		encabezado.setBackground(Color.WHITE);
		encabezado.setOpaque(true);
		encabezado.setFont(new Font("SansSerif", Font.BOLD, 24));
		encabezado.setPreferredSize(new Dimension(100, 65));

		JPanel bannerPanel = new JPanel(new BorderLayout());
		bannerPanel.add(encabezado, BorderLayout.CENTER);

		//Inicializar el escogedor de texto.
		escogedorColor = new JColorChooser(encabezado.getForeground());
		escogedorColor.setBackground(Color.WHITE);
		escogedorColor.getSelectionModel().addChangeListener(this);
		escogedorColor.setBorder(BorderFactory.createTitledBorder("Escoger un color del texto"));

		add(escogedorColor, BorderLayout.CENTER);
		setSize(656, 366);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		colorNuevo = escogedorColor.getColor();
		encabezado.setForeground(colorNuevo);

	}
	
	public Color getColorNuevo() {
		return colorNuevo;
	}

	public void setColorNuevo(Color colorNuevo) {
		ColorChooser.colorNuevo = colorNuevo;
	}
}