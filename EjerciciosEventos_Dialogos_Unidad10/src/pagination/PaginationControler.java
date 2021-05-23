package pagination;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class PaginationControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pagination paginator;

    @FXML
    private ProgressBar barra;

    private ArrayList<String> lista = new ArrayList<String>();
    private static final int ITEMS = 5;
    
    @FXML
    void initialize() {
    	//Añado los nombres
       this.aniadir(lista);
       
       //Se configura la cantidad de páginas necesarias, multiplo de Items y si sobra +1
       paginator.setPageCount(cuentapaginas());
       paginator.setPageFactory((Integer pageIndex) ->{return createPage(pageIndex);});
       
       //Se añade un listener, si cambia el indice, se actualiza la barra
       paginator.currentPageIndexProperty().addListener(
    		   (observable, oldValue, newValue) ->{
    			   barra.setProgress((newValue.doubleValue() + 1) / paginator.getPageCount());
    		   });
    }
    
    //Añade una página rellena hasta el máximo de items posibles
	private VBox createPage(int pageIndex) {
		VBox vbox = new VBox();
		int pagina = pageIndex * ITEMS;
		
		int limit = Math.min(pagina + ITEMS, lista.size());
		for (int i = pagina; i<limit; i++) {
			Label text = new Label((lista.get(i)));
			
			vbox.getChildren().add(text);
		}
		return vbox;
	}

	private void aniadir(ArrayList<String> lista) {
		for (int i = 0; i < 18; i++) {
			lista.add(Integer.toString(i));
		}
		
	}
	private int cuentapaginas() {
		int pags = lista.size() / ITEMS;
		if((lista.size()% ITEMS) > 0) {
			pags++;
		}
		return pags;
	}
}
