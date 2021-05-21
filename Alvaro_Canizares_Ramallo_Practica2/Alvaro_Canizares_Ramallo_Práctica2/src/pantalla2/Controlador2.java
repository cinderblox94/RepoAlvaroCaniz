package pantalla2;

import application.Main;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener.Change;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controlador2 {
	private Main mainApp;
	private ObservableList<Persona> data = null;
	private final static int MAXIMO = 10;
    @FXML
    private TableView<Persona> tabla;
    
    @FXML
    private TableColumn<Persona, String> nombre;

    @FXML
    private TableColumn<Persona, String> apellido;

    @FXML
    private TableColumn<Persona, String> mail;
    
    @FXML
    private TableColumn<Persona, Integer> edad;
    
    @FXML
    private static ProgressBar progreso;
    
    @FXML
    private void initialize() {   
         
        nombre.setCellValueFactory(new PropertyValueFactory<Persona,String>("nombre"));
        apellido.setCellValueFactory(new PropertyValueFactory<Persona,String>("apellido"));
        mail.setCellValueFactory(new PropertyValueFactory<Persona,String>("mail"));
        edad.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("edad"));
        
        
      
               
    }
    
    
    public void cargar() {
    	data = mainApp.data;
    }

	public void setMainApp (Main mainApp) {
    	this.mainApp = mainApp;
    	cargar();
    	tabla.setItems(data); 
    	data.addListener(new ListChangeListener<Persona>() {

    		@Override
    		public void onChanged(Change<? extends Persona> c) {
    			progreso.setProgress(mainApp.data.size()/MAXIMO);
    			
    		}
        	  
          });
    	
    }
	
	
    
}
