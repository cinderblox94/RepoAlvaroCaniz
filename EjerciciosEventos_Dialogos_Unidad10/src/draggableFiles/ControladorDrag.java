package draggableFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;


public class ControladorDrag {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text destino;

    @FXML
    private Text origen;

    @FXML
    private ImageView imageView;

    @FXML
    void handleDragOver(DragEvent event) {
    	if(event.getDragboard().hasFiles()) {
    		event.acceptTransferModes(TransferMode.ANY);
    	}
    }

    @FXML
    void handleDrop(DragEvent event) {
    	List<File> files = event.getDragboard().getFiles();
    	try {
			Image img = new Image(new FileInputStream(files.get(0)));
			imageView.setImage(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void handleDragDetection(MouseEvent event) {
    	Dragboard db = origen.startDragAndDrop(TransferMode.ANY);
    	
    	ClipboardContent cb = new ClipboardContent();
    	cb.putString(origen.getText());
    	
    	db.setContent(cb);
    	event.consume();    	
    }
    
    @FXML
    void handleTextDrag(DragEvent event) {
    	if(event.getDragboard().hasString()) {
    		event.acceptTransferModes(TransferMode.ANY);
    	}
    }
    
    @FXML
    void handleTextDropped(DragEvent event) {
    	String str = event.getDragboard().getString();
    	destino.setText(str);
    }
    
    @FXML
    void handleDragDone(DragEvent event) {
    	origen.setText("Operación Drag terminada");
    }


    @FXML
    void initialize() {

    }
}

