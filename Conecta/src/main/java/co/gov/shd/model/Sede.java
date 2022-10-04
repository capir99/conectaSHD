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
	@Column(name = "direccion", length = 50)
	private String direccion; 
	@Column(name = "telefono")
	private int telefono;
	@Column(name = "gps_dir", length = 100)
	private String gps_dir;
	
	
	// GETTERS & SETTERS
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getGps_dir() {
		return gps_dir;
	}
	public void setGps_dir(String gps_dir) {
		this.gps_dir = gps_dir;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
