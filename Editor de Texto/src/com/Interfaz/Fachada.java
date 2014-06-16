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

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

//Clase para las fachadas del editor.
public class Fachada {
	
	//Método para que el editor tome la apariencia del sistema origen.
	public static void Sistema(){
	    try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    }catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	//Método para que el editor tome la apariencia del tema Nimbus.
	public static void Nimbus(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}
}
