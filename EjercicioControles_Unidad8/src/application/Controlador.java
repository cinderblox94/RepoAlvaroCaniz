package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxListCell;

public class Controlador {
	
	
	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ToggleGroup Gender;
	    
	    @FXML
	    private ListView<Object> lista;

	    @FXML
	    private ChoiceBox <Object> locationCombo;
	 
	    public static final ObservableList<Object> indeterminado = FXCollections.observableArrayList();
	    public static final ObservableList<Object> contenido = FXCollections.observableArrayList();
	    
	    @FXML
	    void initialize() {
	        locationCombo.getItems().addAll("New York","Orlando",new Separator(),"London","Manchester");
	        
	        lista = new ListView<Object>(indeterminado);
	        contenido.addAll("Objects","Classes","Functions","Variables","Compiler","Debugger","Projects","Beans","Libraries","Modules");
	        
	        for(int i=0; i<=10; i++) {
	        	indeterminado.add("Indeterminate (pick a choice)");
	        }
	        lista.setItems(indeterminado);
	        lista.setCellFactory(ComboBoxListCell.forListView(contenido));
	    
	    }
	}

