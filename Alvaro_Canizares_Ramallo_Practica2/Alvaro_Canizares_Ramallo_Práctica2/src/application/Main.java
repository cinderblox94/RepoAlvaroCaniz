package application;
	
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener.Change;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pantalla2.Controlador2;
import pantalla2.Data;
import pantalla2.Persona;


public class Main extends Application {
	private BorderPane rootLayout;	
	public ObservableList<Persona> data;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Data d = new Data();
			data = d.getData();
			
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Menu.fxml"));
			rootLayout = (BorderPane) loader.load();

			Controlador controlador = loader.getController();
			controlador.setRootLayout(rootLayout);
			controlador.setMainApp(this);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			
			
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
