package co.gov.shd.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombres", length = 50, nullable=true)
	private String nombres;
	@Column(name = "apellidos", length = 50, nullable=true)
	private String apellidos;
	@Column(name = "id_dependencia", nullable=true)
	private int id_dependencia;
	@Column(name = "fechaN", nullable=true)
	private Date fechaN;
	@Column(name = "foto_dir", length = 255, nullable=true)
	private String foto_dir;
	@Column(name = "telefono", length = 30, nullable=true)
	private String telefono;
	@Column(name = "ext", nullable=true)
	private int ext;
	@Column(name = "cod_func", nullable=true)
	private int cod_func;
	@Column(name = "id_cargo", nullable=true)
	private int id_cargo;
	@Column(name = "activo", nullable=false)
	private boolean activo;
	
	
	// GETTERS & SETTERS
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getId_dependencia() {
		return id_dependencia;
	}
	public void setId_dependencia(int id_dependencia) {
		this.id_dependencia = id_dependencia;
	}
	public Date getFechaN() {
		return fechaN;
	}
	public void setFechaN(Date fechaN) {
		this.fechaN = fechaN;
	}
	public String getFoto_dir() {
		return foto_dir;
	}
	public void setFoto_dir(String foto_dir) {
		this.foto_dir = foto_dir;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getExt() {
		return ext;
	}
	public void setExt(int ext) {
		this.ext = ext;
	}
	public int getCod_func() {
		return cod_func;
	}
	public void setCod_func(int cod_func) {
		this.cod_func = cod_func;
	}
	public int getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

	

}
