package basico2;
	
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainCSSBasico2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		Scene scene = createScene();
		
		primaryStage.setScene(scene);
		scene.getStylesheets().add("basico2/estilo3.css");
		
		primaryStage.setTitle("Ejemplo de CSS");
		primaryStage.show();	   
	}
	
    public Scene createScene() {
    	// Los estilos generales de cada contenedor HBox o VBox está en el CSS
    	// Se identifican por ID
    	
        ToggleGroup toggleGroup = new ToggleGroup();
 
        RadioButton radioButton1 = new RadioButton("High");
        radioButton1.setToggleGroup(toggleGroup);
        radioButton1.setSelected(true);
 
        RadioButton radioButton2 = new RadioButton("Medium");
        radioButton2.setToggleGroup(toggleGroup);
        
        RadioButton radioButton3 = new RadioButton("Low");
        radioButton3.setToggleGroup(toggleGroup);
        
        VBox vBox1 = new VBox();
        vBox1.setId("vbox-aux1");
        vBox1.getChildren().addAll(radioButton1, radioButton2, radioButton3);
        
        TextField textField = new TextField();
        textField.setPromptText("Your name");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        
        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(textField, passwordField);
        
        ChoiceBox<String> choiceBox = new ChoiceBox<>(
            FXCollections.observableArrayList("English", "???????", "Français"));
        choiceBox.setTooltip(new Tooltip("Your language"));
        choiceBox.getSelectionModel().select(0);
 
        HBox hBox1 = new HBox();
        hBox1.setId("hbox1");
        hBox1.getChildren().addAll(vBox1, vBox2, choiceBox);
        
        final Label label1 = new Label("Not Available");
        label1.getStyleClass().add("borders");
 
        Button button1 = new Button("Accept");
        button1.getStyleClass().add("button1");
   
        Button button2 = new Button("Decline");
        button2.getStyleClass().add("button2");

        HBox hBox2 = new HBox();
        hBox2.setId("hbox2");
        hBox2.getChildren().addAll(button1, button2, label1);
 
        CheckBox checkBox1 = new CheckBox("Normal");
 
        Separator separator = new Separator(); // Estilos vía CSS
 
        CheckBox checkBox2 = new CheckBox("Checked");
        checkBox2.setSelected(true);
 
        CheckBox checkBox3 = new CheckBox("Undefined");
        checkBox3.setIndeterminate(true);
        checkBox3.setAllowIndeterminate(true);
        
        HBox hBox3 = new HBox();
        hBox3.setId("hbox3");
        hBox3.getChildren().addAll(checkBox1, separator, checkBox2, checkBox3);
 
        Label label2 = new Label("Progress:");
        label2.getStyleClass().add("borders");
        
        Slider slider = new Slider();
 
        ProgressIndicator progressIndicator = new ProgressIndicator(0);
        progressIndicator.progressProperty().bind(Bindings.divide(
            slider.valueProperty(), slider.maxProperty()));
 
        HBox hBox4 = new HBox();
        hBox4.setId("hbox4");
        hBox4.getChildren().addAll(label2, slider, progressIndicator);
 
        final VBox vBox = new VBox();
        vBox.setId("vbox-final");
        
        // Estilo en línea. Tiene prioridad sobre el resto de estilos
        // TODO Probar a comentar para que adopte el padding del CSS
        vBox.setStyle("-fx-padding: 10");
        vBox.getChildren().setAll(hBox1, hBox2, hBox3, hBox4);
 
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vBox);
 
        return new Scene(scrollPane, 500, 350);
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
