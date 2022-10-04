package co.gov.shd.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dependencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "nombre", length = 50)
	private String nombre;
	@Column(name = "id_padre")
	private int id_padre;
	
	// GETTERS & SETTERS
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId_padre() {
		return id_padre;
	}
	public void setId_padre(int id_padre) {
		this.id_padre = id_padre;
	}
	
	
	
	
	

	

}
