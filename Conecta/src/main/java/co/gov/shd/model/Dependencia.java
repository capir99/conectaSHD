package co.gov.shd.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "DEPENDENCIA")
public class Dependencia{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "codigo", length = 10)
	private String codigo;
	@Column(name = "nombre", length = 250)
	private String nombre;
	@JoinColumn(name = "id_padre", referencedColumnName = "id")
	@Nullable
	@ManyToOne(optional = true)
	private Dependencia id_padre;
	@Column(name = "jerarquia")
	@Nullable
	private int jerarquia;
	
	
	// GETTERS & SETTERS
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Dependencia getId_padre() {
		return id_padre;
	}
	public void setId_padre(Dependencia id_padre) {
		this.id_padre = id_padre;
	}
	public int getJerarquia() {
		return jerarquia;
	}
	public void setJerarquia(int jerarquia) {
		this.jerarquia = jerarquia;
	}
	
	
	
	
	
	
	
	
	
	

	

}
