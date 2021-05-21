package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pantalla2.Controlador2;
import pantalla2.Persona;
import pantalla3.Controlador3;

public class Controlador {
	
	// Pantalla principal en la que se añade o quita contenido
	private BorderPane rootLayout;
	private Main mainApp;
  
    @FXML
    private void initialize() {
    }
    
    @FXML
    private void abrirPantalla2(ActionEvent event) {    	
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Controlador.class.getResource("/pantalla2/pantalla2.fxml"));
			AnchorPane pantalla2 = (AnchorPane) loader.load(); 
			
			Controlador2 cont = loader.getController();
			cont.setMainApp(mainApp);
			
			rootLayout.setCenter(pantalla2);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void cerrarPantalla(ActionEvent event) {    	
    	rootLayout.setCenter(null);	
    }

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
	
	@FXML
    private void abrirPantalla3(ActionEvent event) {    	
    	try {
			FXMLLoader loader3 = new FXMLLoader();
			loader3.setLocation(Controlador.class.getResource("/pantalla3/pantalla3.fxml"));
			AnchorPane pantalla3 = (AnchorPane) loader3.load();
			
			Controlador3 controlador = loader3.getController();
			controlador.setMainApp(mainApp);
			
			rootLayout.setCenter(pantalla3);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	@FXML
    private void abrirPantalla4(ActionEvent event) {    	
    	try {
			FXMLLoader loader4 = new FXMLLoader();
			loader4.setLocation(Controlador.class.getResource("/pantalla4/pantalla4.fxml"));
			AnchorPane pantalla4 = (AnchorPane) loader4.load();

			rootLayout.setCenter(pantalla4);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	public void setMainApp (Main mainApp) {
    	this.mainApp = mainApp;
    }
    
    
}
