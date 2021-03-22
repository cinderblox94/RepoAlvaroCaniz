package application;
import java.net.URL;
	import java.util.ResourceBundle;
	import javafx.fxml.FXML;
	import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;

public class Controlador {
	
	
	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ToggleGroup Gender;

	    @FXML
	    private ChoiceBox<Object> locationCombo;

	    @FXML
	    void initialize() {
	        assert Gender != null : "fx:id=\"Gender\" was not injected: check your FXML file 'MainLayouts.fxml'.";
	        assert locationCombo != null : "fx:id=\"locationCombo\" was not injected: check your FXML file 'MainLayouts.fxml'.";
	        
	        
	        locationCombo.getItems().addAll("New York","Orlando",new Separator(),"London","Manchester");
	    }
	}

