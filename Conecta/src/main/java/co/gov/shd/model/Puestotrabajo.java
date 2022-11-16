package co.gov.shd.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Puestotrabajo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "piso")
	private int piso;
	@JoinColumn(name = "id_mapa", referencedColumnName = "id", nullable=true)
	@ManyToOne(optional = true)
	private Mapa id_mapa;
	@Column(name = "corx", length = 50)
	private String corx;
	@Column(name = "cory", length = 50)
	private String cory;
	@JoinColumn(name = "id_sede", referencedColumnName = "id", nullable=false)
	@ManyToOne(optional = true)
	private Sede id_sede;
	
	
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
	public Mapa getId_mapa() {
		return id_mapa;
	}
	public void setId_mapa(Mapa id_mapa) {
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
	public Sede getId_sede() {
		return id_sede;
	}
	public void setId_sede(Sede id_sede) {
		this.id_sede = id_sede;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
