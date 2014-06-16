/**
 * Desarrollado por: Jesús Enrique Ramos Cruz
 * Programa con fines acádemicos para el
 * entendimiento de ciertas características
 * del programa java y una utilización
 * variable del patrón MVC.
 * San José, Costa Rica, 2014.
 * Versión: 1.0
 * **/

package com.Controlador;

//Importaciones.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.Interfaz.JFontChooser;
import com.Interfaz.VentanaColorChooser;
import com.Interfaz.VentanaPrincipal;

public class Controller_Ventana_Principal implements ActionListener{
	//Atributos.
    private VentanaPrincipal view;
    private JTextArea areaTextoActual = new JTextArea();
    private JFileChooser fileChooser = new JFileChooser();
	private int seleccion;

    // Controlador para la ventana principal.
    public Controller_Ventana_Principal(VentanaPrincipal ventanaEdicion)
    {
        view = ventanaEdicion;
    }

    // Acciones predefinidas para el actionlistener.
	public void actionPerformed(ActionEvent eventoActual) {
		areaTextoActual= view.getTextArea();
		Object fuente= eventoActual.getSource();
		
		//Si se escogio salir del sistema.
		if(fuente== view.getItemSalir()){
			view.dispose();
		}
		//Si se escogio guardar el documento.
		if(fuente== view.getItemGuardar()){
			//Verificar que el editor no este en blanco.
			String Texto = areaTextoActual.getText();
	        if (Texto.matches("[[ ]*[\n]*[\t]]*")) {
	            JOptionPane.showMessageDialog(null,"No hay texto para guardar!", "Error", JOptionPane.ERROR_MESSAGE);
	        }else{
	        	//Crear el fichero, el filechooser para escoger la ruta de guardar.
				File fichero = fileChooser.getSelectedFile();
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Todos los archivos *.TXT", "txt","TXT"));
	            seleccion = fileChooser.showSaveDialog(null);
	            try{
	            	//Si el usuario elige guardar.
	                if (seleccion == JFileChooser.APPROVE_OPTION){
	                    fichero = fileChooser.getSelectedFile();
	                    String PATH = fichero.getAbsolutePath();
	                    PrintWriter printwriter = new PrintWriter(fichero);
	                    printwriter.print(areaTextoActual.getText());
	                    printwriter.close();
	                    
	                    //Se comprueba si a la hora de guardar obtuvo la extension y si no se la asignamos
	                    if(!(PATH.endsWith(".txt"))){
	                        File temp = new File(PATH+".txt");
	                        fichero.renameTo(temp);
	                    }
	                    // Mensaje exitoso.
	                    JOptionPane.showMessageDialog(null,"Guardado exitoso!", "Información", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }catch (Exception e){
	            	//Mensaje de error.
	                JOptionPane.showMessageDialog(null,"Error al guardar el archivo!", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } 
		}
		//Si se escogio un nuevo el documento.
		if(fuente== view.getItemNuevo()){
			// Se crea una nueva ventana.
			VentanaPrincipal nuevaVentana = new VentanaPrincipal();
			nuevaVentana.setVisible(true);
		}
		//Si se escogio abrir el documento.
		if(fuente== view.getItemAbrir()){
			//Se inician un nuevo filechooser y se inicializa un fichero.
			fileChooser.showOpenDialog(areaTextoActual);
			File fichero = fileChooser.getSelectedFile();

			if (seleccion == JFileChooser.APPROVE_OPTION)
			{		 	
				//Si el usuario desea abrir el archivo.
				BufferedReader reader;
				try {
					//Se crea un buffer de lectura.
					reader = new BufferedReader(new FileReader(fichero));
					try{	
						//Se inicializa un string para mantener el texto.
						String lineaTotal="";
						String linea = reader.readLine();
						//Se lee todo el texto del archivo y se guarda en la linea(string).
						while (linea != null)
						{
						   lineaTotal = lineaTotal + linea + System.getProperty("line.separator"); 
						   linea = reader.readLine();
						} 
						//Se introduce el texto del documento en el componente de la interfaz.
						areaTextoActual.setText(lineaTotal);
						reader.close();
					}catch(IOException event){
						event.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		//Si se escogio poner texto en Mayusculas.
		if(fuente== view.getItemMayusculas()){
			String textoactual = areaTextoActual.getText();
			areaTextoActual.setText(textoactual.toUpperCase());
		}
		//Si se escogio poner texto en minusculas.
		if(fuente== view.getItemMinusculas()){
			String textoactual = areaTextoActual.getText();
			areaTextoActual.setText(textoactual.toLowerCase());
		}
		//Si se escogio copiar el texto.
		if(fuente== view.getItemCopiar()){
			areaTextoActual.copy();
		}
		//Si se escogio cortar el texto.
		if(fuente== view.getItemCortar()){
			areaTextoActual.cut();
		}
		//Si se escogio pegar el texto.
		if(fuente== view.getItemPegar()){
			areaTextoActual.paste();
		}
		//Si se escogio seleccionar todo el texto en el documento.
		if(fuente== view.getItemSeleccionarTodo()){
			areaTextoActual.selectAll();
		}
		//Si se escogio cambiar la fuente del texto.
		if(fuente== view.getItemFuente()){
			JFontChooser fuenteNueva = new JFontChooser();
			fuenteNueva.showDialog(areaTextoActual);
			areaTextoActual.setFont(fuenteNueva.getSelectedFont());
		}
		//Si se escogio cambiar el color del texto.
		if(fuente== view.getItemColor()){
			VentanaColorChooser escogerColor = new VentanaColorChooser(areaTextoActual);
			escogerColor.setVisible(true);
		}
		//Si se escogio la ventana de Ayuda.
		if(fuente== view.getItemAyuda()){
			JOptionPane.showMessageDialog(null, "Esta es la Ayuda del \"Text Editor\":\r\n\r\n" +
					"Crear un documento nuevo -----> Ctrl+N\r\n" +
					"Abrir un documento -----------> Ctrl+A\r\n" +
					"Guardar un documento ---------> Ctrl+N\r\n" +
					"Salir del Editor -------------> Alt+F4\r\n\r\n" +
					"Tambi\u00E9n puedes convertir el texto en MAYUSCULAS\r\n" +
					"o en minusculas en el menu \"Edici\u00F3n\"\r\nadem\u00E1s " +
					"de copiar, cortar, pegar y\r\n" +
					"seleccionar todo.\r\n\r\n" +
					"Si quieres tambi\u00E9n puedes cambiar el color o\r\n" +
					"la fuente del texto en el menu \"Formato\".\r\n\r\n\u00A1Ojal\u00E1 \"TextEditor\" te sea provechoso.",
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
		//Si se escogio el Acerca de.
		if(fuente== view.getItemAcercaDe()){
			JOptionPane.showMessageDialog(null, "Text Editor\n\n" +
					                            "Programa Desarrollado con fines acádemicos por:\n\n" +
					                            "Jesús Enrique Ramos Cruz\n\n" +
					                            "Junio, 2014\n" +
					                            "Versión 1.0"
					                            , "Acerca de", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
