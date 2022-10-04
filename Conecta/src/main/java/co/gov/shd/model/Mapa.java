package co.gov.shd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mapa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "mapa_dir", length = 255)
	private String mapa_dir;
	
	
	
	// GETTERS & SETTERS
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMapa_dir() {
		return mapa_dir;
	}
	public void setMapa_dir(String mapa_dir) {
		this.mapa_dir = mapa_dir;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
