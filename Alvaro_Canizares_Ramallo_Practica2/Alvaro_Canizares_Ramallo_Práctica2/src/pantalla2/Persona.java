package pantalla2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Persona {
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellido;
    private final SimpleStringProperty mail;
    private final SimpleIntegerProperty edad;
 
    public Persona(String nombre, String apellido, String mail, Integer edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.mail = new SimpleStringProperty(mail);
        this.edad = new SimpleIntegerProperty(edad);
    }
 
   
	public String getNombre() {
        return nombre.get();
    }
    
    public void setNombre(String cadena) {
        nombre.set(cadena);
    }
        
    public String getApellido() {
        return apellido.get();
    }
    public void setApellido(String cadena) {
        apellido.set(cadena);
    }
    
    public String getMail() {
        return mail.get();
    }
    public void setMail(String cadena) {
        mail.set(cadena);
    }

	public Integer getEdad() {
		return edad.get();
	}
	public void setEdad(Integer n) {
		edad.set(n);
    }   
	public String toString() {
		String cadena = getNombre() +" "+getApellido()+"\n";
		return cadena;
	}
        
}