package pantalla3;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import pantalla2.Data;
import pantalla2.Persona;

public class Controlador3 {
	private ObservableList<Persona> nuevoData = null;
	private String nombre;
	private boolean encontrado = false;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoApellido;

    @FXML
    private TextField campoMail;

    @FXML
    private TextField campoEdad;
	private Main mainApp;

    @FXML
    void buscar(ActionEvent event) {
    	nuevoData = mainApp.data;
    	nombre = campoNombre.getText();
    	encontrado = false;
    	
    	for (Persona persona : nuevoData) {
    		System.out.println(persona.toString());
			if(persona.getNombre().equals(nombre)) {
				campoApellido.setText(persona.getApellido());
				campoMail.setText(persona.getMail());
				campoEdad.setText(persona.getEdad().toString());
				encontrado = true;
			}
		}
    	if(!encontrado) {
    		noExiste();
    	}
    	System.out.println("----------------");
    	
    }
	@FXML
    void aniadir(ActionEvent event) {
    	nuevoData = mainApp.data;
    	boolean error = false;
    	
    	
    	
    	
    	String nombre = campoNombre.getText();
    	    	
    	String apellido = campoApellido.getText();
    	String mail = campoMail.getText();
    	int edad = Integer.valueOf(campoEdad.getText());
    	Persona persona = new Persona(nombre,apellido,mail,edad);
    	
    	nuevoData.add(persona);
    	System.out.println(nuevoData);
    	mainApp.data = nuevoData;
    	if(!error) {
    		informar(3);//añadido
    	}else {
    		informar(4);//NO añadido
    	}

    }

	protected void errorMayusc() {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setTitle("ERROR");
		errorAlert.setContentText("Error, no se admiten mayúsculas");
		errorAlert.showAndWait();
		
	}
	@FXML
    void modificar(ActionEvent event) {
    	encontrado = false;
    	if(validado()) {
	    	for (Persona persona : nuevoData) {
				if(persona.getNombre().equals(nombre)) {
					persona.setNombre(campoNombre.getText());
					persona.setApellido(campoApellido.getText());
					persona.setMail(campoMail.getText());
					persona.setEdad(Integer.valueOf(campoEdad.getText()));
					encontrado = true;
				}
			}
	    	if(!encontrado) {
	    		noExiste();
	    	}else {
	    		mainApp.data = nuevoData;
	    		informar(2);//modificar
	    	}
    	}
    }
    
    @FXML
    void borrar(ActionEvent event) {
    	int indice = -1;
    	boolean borrado = true;
    	if(validado()) {
    		//busco el nombre en el Observable list y guardo el índice
			for (int i = 0; i < nuevoData.size(); i++) {
				if(nuevoData.get(i).getNombre().equals(nombre)) {
					indice = i;
				}
			}
		}
    	
    	if(indice == -1) {
    		noExiste();
    		borrado = false;
    	}else{
    		if(borrado = confirmar(indice)) {
    			nuevoData.remove(indice);
    		}
	    }
    	
    	if(borrado) {
    		informar(0);
    	}else {
    		informar(1);
    	}
    }

    private boolean confirmar(int indice) {
    	boolean decision = false;
    	Alert confirmacion = new Alert(AlertType.CONFIRMATION);
		Persona persona = nuevoData.get(indice);
		confirmacion.setTitle("Confirmación para eliminar");
		confirmacion.setHeaderText("Confirmación");
		confirmacion.setContentText("¿Está seguro de eliminar a "+ persona.toString() +"?");
		
		confirmacion.getDialogPane().addEventFilter(KeyEvent.KEY_PRESSED, (event) -> {
			KeyCode code = event.getCode();
    		if ((code == KeyCode.ENTER) || (code == KeyCode.ESCAPE)) {
    			event.consume();
    		}
		});
		Optional<ButtonType> result = confirmacion.showAndWait();
		if(result.get() == ButtonType.OK) {
			decision = true;
		}
		return decision;
	}

	private boolean validado() {
		boolean validado = true;
			if(nuevoData == null) {
				validado = false;
				
				Alert errorAlert = new Alert(AlertType.ERROR);
	    		errorAlert.setTitle("ERROR");
	    		errorAlert.setContentText("BUSQUE PRIMERO A LA PERSONA");
	    		errorAlert.showAndWait();
			}
		return validado;
	}
	
	private void informar(int eleccion) {
		String accion = "";
		
		switch (eleccion) {
			case 0:
				accion = " Eliminada ";
			break;
			case 1:
				accion = " No eliminada ";
			break;
			case 2:
				accion = " Modificada ";
			break;
			case 3:
				accion = " Añadida ";
			break;
			case 4:
				accion = " No Añadida ";
			break;
			
		default:
			break;
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Información");
		alert.setHeaderText(accion+"esa persona");
		alert.getDialogPane().addEventFilter(KeyEvent.KEY_PRESSED, (event) -> {
			KeyCode code = event.getCode();
    		if ((code == KeyCode.ENTER) || (code == KeyCode.ESCAPE)) {
    			event.consume();
    		}
		});

		alert.showAndWait();
	}
	
	private void noExiste() {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setTitle("ERROR");
		errorAlert.setContentText("NO EXISTE ESA PERSONA");
		errorAlert.getDialogPane().addEventFilter(KeyEvent.KEY_PRESSED, (event) -> {
			KeyCode code = event.getCode();
    		if ((code == KeyCode.ENTER) || (code == KeyCode.ESCAPE)) {
    			event.consume();
    		}
		});
		errorAlert.showAndWait();
	}
   

	@FXML
    void initialize() {
		campoNombre.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
				int numberCode = (int) event.getCharacter().charAt(0);
	    		if ((numberCode < 90) || (numberCode > 122)) {
	    			event.consume();
	    			errorMayusc();
	    		}else{
	    			
	    		}
			}
    	});
		
		
		campoApellido.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
				int numberCode = (int) event.getCharacter().charAt(0);
	    		if ((numberCode < 90) || (numberCode > 122)) {
	    			event.consume();
	    			errorMayusc();
	    		}else{
	    			
	    		}
			}
    	});
		campoMail.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
				int numberCode = (int) event.getCharacter().charAt(0);
	    		if ((numberCode < 90) || (numberCode > 122)) {
	    			event.consume();
	    			errorMayusc();
	    		}else{
	    			
	    		}
			}
    	});
		campoEdad.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
				int numberCode = (int) event.getCharacter().charAt(0);
	    		if ((numberCode < 48) || (numberCode > 59)) {
	    			event.consume();

	    			Alert errorAlert = new Alert(AlertType.ERROR);
	    			errorAlert.setTitle("ERROR");
	    			errorAlert.setContentText("Error, solo se admiten números");
	    			errorAlert.showAndWait();
	    		}else{
	    			
	    		}
			}
    	});
    	
    }

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
    
}
