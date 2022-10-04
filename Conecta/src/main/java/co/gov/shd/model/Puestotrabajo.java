package co.gov.shd.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Puestotrabajo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "piso")
	private int piso;
	@Column(name = "id_mapa")
	private int id_mapa;
	@Column(name = "corx", length = 50)
	private String corx;
	@Column(name = "cory", length = 50)
	private String cory;
	@Column(name = "id_sede")
	private int id_sede;
	
	
	// GETTERS & SETTERS
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getId_mapa() {
		return id_mapa;
	}
	public void setId_mapa(int id_mapa) {
		this.id_mapa = id_mapa;
	}
	public String getCorx() {
		return corx;
	}
	public void setCorx(String corx) {
		this.corx = corx;
	}
	public String getCory() {
		return cory;
	}
	public void setCory(String cory) {
		this.cory = cory;
	}
	public int getId_sede() {
		return id_sede;
	}
	public void setId_sede(int id_sede) {
		this.id_sede = id_sede;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
