package pantalla4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class Controlador4 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TreeView<String> tree;
    
    @FXML
    void initialize() {
    	TreeItem<String> raiz = new TreeItem<String>("Guía");
    	raiz.setExpanded(true);
    	//inicio
    	TreeItem<String> inicio = new TreeItem<String>("Inicio");
    		inicio.getChildren().add(new TreeItem<String>("Abrir"));
    		inicio.getChildren().add(new TreeItem<String>("\tMuestra los datos en la tabla"));
    		inicio.getChildren().add(new TreeItem<String>("Cerrar"));	
    		inicio.getChildren().add(new TreeItem<String>("\tCierra la ventana actual"));
    	raiz.getChildren().add(inicio);
    	inicio.setExpanded(true);
    		
    	//Modificar
    	TreeItem<String> modificar = new TreeItem<String>("Modificar");
	    	modificar.getChildren().add(new TreeItem<String>("Buscar"));
			modificar.getChildren().add(new TreeItem<String>("\tBusca y completa el resto de datos"));
    		modificar.getChildren().add(new TreeItem<String>("Modificar"));
    		modificar.getChildren().add(new TreeItem<String>("\tPermite actualizar la BBDD"));
    		modificar.getChildren().add(new TreeItem<String>("Borrar"));
    		modificar.getChildren().add(new TreeItem<String>("\tElimina la persona de la BBDD"));
    	raiz.getChildren().add(modificar);	
    	modificar.setExpanded(true);
    	//Ayuda
    	TreeItem<String> ayuda = new TreeItem<String>("Ayuda");
    		ayuda.getChildren().add(new TreeItem<String>("Guia"));
    		ayuda.getChildren().add(new TreeItem<String>("\tComenta las opciones disponibles"));
    	raiz.getChildren().add(ayuda);
    	ayuda.setExpanded(true);
    	
    	tree.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				tree.setCursor(Cursor.CROSSHAIR);
			}
    	});
    	tree.setRoot(raiz);
    	
    }
}
