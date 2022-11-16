package co.gov.shd.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sede {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre", length = 50)
	private String nombre; 
	@Column(name = "direccion", length = 50)
	private String direccion; 
	@Column(name = "telefono", length = 50)
	private String telefono;
	@Column(name = "gps_dir", length = 100)
	private String gps_dir;
	
	
	// GETTERS & SETTERS
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getGps_dir() {
		return gps_dir;
	}
	public void setGps_dir(String gps_dir) {
		this.gps_dir = gps_dir;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
