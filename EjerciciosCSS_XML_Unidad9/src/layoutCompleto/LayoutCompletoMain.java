package layoutCompleto;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class LayoutCompletoMain extends Application {
	private FlowPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LayoutCompletoMain.class.getResource("LayoutCOmpleto.fxml"));
			rootLayout = (FlowPane) loader.load();
			
			
			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add("layoutCompleto/css/estilo.css");
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
