package ejercicio2;
	
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainEj2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		Scene scene = createScene();
		
		primaryStage.setScene(scene);
		scene.getStylesheets().add("ejercicio2/estiloEj2.css");
		
		primaryStage.setTitle("Ej2");
		primaryStage.show();	   
	}
	
    public Scene createScene() {
    	
 
        GridPane gridPane = new GridPane();
        gridPane.setId("grid");
        
        final Label nombre = new Label("First Name");
        nombre.getStyleClass().add("etiqueta");
        
        TextField valor = new TextField("Valor fijo");
        valor.setId("valor");
        
        final Label descripcion = new Label("Description");
        descripcion.getStyleClass().add("etiqueta");
        
        Slider slider = new Slider(0,50,0);
        slider.setShowTickLabels(true);
        
        Button b1 = new Button("Submit");
        b1.getStyleClass().add("boton");
        
        Button b2 = new Button("Reset");
        b2.getStyleClass().add("boton");
       
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(nombre, 0, 0);
        gridPane.add(descripcion, 0, 1);
        gridPane.add(b1, 0, 2);
        gridPane.add(valor, 1, 0);
       
        gridPane.add(slider, 1, 1);
        
        gridPane.add(b2, 1, 2);

        
        return new Scene(gridPane, 500, 350);
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
