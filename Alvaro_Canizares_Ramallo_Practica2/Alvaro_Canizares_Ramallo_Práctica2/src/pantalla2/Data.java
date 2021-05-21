package pantalla2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data {
	private static ObservableList<Persona> data = FXCollections.observableArrayList(
    	    new Persona("capitan", "america", "cap@mail.com", 99),
    	    new Persona("bucky", "bames", "bu@mail.com", 99),
    	    new Persona("hulk", "-", "verde@mail.com", 40),
    	    new Persona("iron", "man", "tony@mail.com", 45),
    	    new Persona("thor", "tilla", "papas@mail.com", 99),
    	    new Persona("quick", "silver", "platarapida@mail.com", 99),
    	    new Persona("pepper", "pots", "pimiento@mail.com", 40)
    	);
	public ObservableList<Persona> getData () {
		return data;
	}
	public static void setData(ObservableList<Persona> nuevoData) {
		data = nuevoData;
		
	}
	
}
