package eventosValidar;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainValidar extends Application {
	private VBox rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainValidar.class.getResource("EventosValidar.fxml"));
			rootLayout = (VBox) loader.load();
			
			
			Scene scene = new Scene(rootLayout);
						
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejemplo sobre eventos");
			primaryStage.show();
			
			abrirDialogo(primaryStage, scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void abrirDialogo(Stage primaryStage, Scene scene) {
		
		TextInputDialog textDialog = new TextInputDialog();
    	textDialog.initModality(Modality.WINDOW_MODAL);
    	textDialog.initOwner(primaryStage);
    	textDialog.setTitle("Ejemplo de diálogo");
    	textDialog.setHeaderText("Diálogo para introducir un texto");
    
    	// Filtro Enter y Esc
    	textDialog.getDialogPane().addEventFilter(KeyEvent.KEY_PRESSED, (event) -> {
    		KeyCode code = event.getCode();
    		if ((code == KeyCode.ENTER) || (code == KeyCode.ESCAPE)) {
    			event.consume();
    		}
    	});
     	
    	textDialog.getEditor().setText("");
    	
    	
    	// Filtro mayusc
    	textDialog.getEditor().addEventHandler(KeyEvent.KEY_TYPED, ((event) -> {
    		int numberCode = (int) event.getCharacter().charAt(0);
    		
    		if ((numberCode < 65) || (numberCode > 90)) {
    			event.consume();
    		}    			    		
    	}));
		
		Button bMostrar = (Button) scene.lookup("#bMostrar");
		TextField input = (TextField) scene.lookup("#input");
		
		
		bMostrar.setOnAction((event)->{						    	
	    	textDialog.showAndWait().ifPresent(response -> {
	    		input.setText(response);
    		});
		});
		
    	textDialog.setOnHidden((event) -> {
            input.requestFocus();            
        });
    	
		input.setOnMouseEntered((event) -> {
			input.setCursor(Cursor.HAND);
		});	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
