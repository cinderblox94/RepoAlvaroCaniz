package ch.makery.address.view;

import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.address.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorNew {
	private Person persona;
	private Stage stage;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellido;

    @FXML
    private TextField calle;

    @FXML
    private TextField ciudad;

    @FXML
    private TextField codigo;

    @FXML
    private TextField cumpleanios;

    @FXML
    void cancel(ActionEvent event) {
    	stage.close();
    }

    @FXML
    void ok(ActionEvent event) {
    	if(validado()) {
	    	persona.setFirstName(nombre.getText());
	    	persona.setLastName(apellido.getText());
	    	persona.setStreet(calle.getText());
	    	persona.setPostalCode(Integer.parseInt(codigo.getText()));
	    	persona.setCity(ciudad.getText());
	    	persona.setBirthday(DateUtil.parse(cumpleanios.getText()));
    	}
    	stage.close();
    }

    @FXML
    void initialize() {
       
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}

	public void setPerson(Person persona) {
		this.persona = persona;
		nombre.setText(persona.getFirstName());
		apellido.setText(persona.getLastName());
		calle.setText(persona.getStreet());
		codigo.setText(Integer.toString(persona.getPostalCode()));
		ciudad.setText(persona.getCity());
		cumpleanios.setText(DateUtil.format(persona.getBirthday()));
		
		
		
	}
	public boolean validado() {
		String error = "";
		
		if (nombre.getText() == null || nombre.getText().length() == 0) {
            error += "El campo first name está vacío\n"; 
        }
        if (apellido.getText() == null || apellido.getText().length() == 0) {
            error += "El campo last name está vacío\n"; 
        }
        if (calle.getText() == null || calle.getText().length() == 0) {
            error += "El campo street está vacío\n"; 
        }

        if (codigo.getText() == null || codigo.getText().length() == 0) {
            error += "El campo postal code está vacío\n"; 
        }

        if (ciudad.getText() == null || ciudad.getText().length() == 0) {
            error += "El campo city está vacío\n"; 
        }

        if (cumpleanios.getText() == null || cumpleanios.getText().length() == 0) {
            error += "El campo birthday está vacío\n";
        }

        if (error.contentEquals("")) {
            return true;
        } else {
    		Alert alerta = new Alert(AlertType.ERROR);
        	
    		alerta.setTitle("Hay campos incorrectos");
    		alerta.setHeaderText("Por favor, rellena correctamente los campos");
    		alerta.setContentText(error);
    		
    		alerta.showAndWait();
            return false;
        }
		
	}
	

	
}

