package ch.makery.address.view;



import ch.makery.address.Main;
import ch.makery.address.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Referencia a la aplicación principal
    private Main mainApp;    
    
    /**
     * Método para inicializar el controlador que se llama cuando se carga el FXML
     */
    @FXML
    private void initialize() {
    	// Se inicializan las columnas firstName y lastName
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	
    	
        detallePersona(null);
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> detallePersona(newValue)); 
    }

    

	private void detallePersona(Person persona) {
		if(persona != null) {
			firstNameLabel.setText(persona.getFirstName());
            lastNameLabel.setText(persona.getLastName());
            streetLabel.setText(persona.getStreet());
            postalCodeLabel.setText(Integer.toString(persona.getPostalCode()));
            cityLabel.setText(persona.getCity());
            birthdayLabel.setText(DateUtil.format(persona.getBirthday()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
		
	}



	/**
     * Referencia a la aplicación principal
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(this.mainApp.getPersonData());
        
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
    @FXML
    void dialogo(ActionEvent event) {
    	Person persona = new Person();
    	mainApp.abrirNuevo(persona);
    	mainApp.getPersonData().add(persona);
    }
 
    
    @FXML
   private  void dialogo2(ActionEvent event) {
    	Person persona = personTable.getSelectionModel().getSelectedItem();
    	if(persona != null) {
    		mainApp.abrirEditar(persona);
    		detallePersona(persona);
    	}else {
    		Alert error = new Alert(AlertType.ERROR);
    		
    		error.setTitle("Error al editar persona");
    		error.setHeaderText("No se ha seleccionado ninguna fila");
    		error.setContentText("Por favor, selecciona una persona en la tabla");
    		error.showAndWait();
    	}
    }
    
    @FXML
    void dialogo3(ActionEvent event) {
    	int indice = personTable.getSelectionModel().getSelectedIndex();
    	
    	if(indice >= 0) {
    		Alert confirmacion = new Alert(AlertType.CONFIRMATION);
    		
    		confirmacion.setTitle("Confirmación para eliminar");
    		confirmacion.setHeaderText("Confirmación");
    		confirmacion.setContentText("¿Está seguro de eliminar la fila actual?");
    		
    		confirmacion.showAndWait().ifPresent(response -> {
    			if(response == ButtonType.OK) {
    				personTable.getItems().remove(indice);
    			}
    		});
    		
    	}else {
    		Alert error = new Alert(AlertType.ERROR);
    		
    		error.setTitle("Error al eliminar");
    		error.setHeaderText("Se ha producido un error");
    		error.setContentText("No se puede eliminar porque no ha seleccionado una fila");
    		error.showAndWait();
    	}
    }
}