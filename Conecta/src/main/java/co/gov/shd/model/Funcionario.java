package co.gov.shd.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario {
    @Id
	private int id;
    @Column(name= "nombres", length = 50)
	private String nombres;
    @Column(name= "apellidos", length = 50)
	private String apellidos;
    @Column(name= "dependencia")
	private int dependencia;
    @Column(name= "fechaCumple")
	private Date fechaCumple;
	
    
    //GETTERS & SETTERS
    
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
	public int getDependencia() {
		return dependencia;
	}
	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}
	public Date getFechaCumple() {
		return fechaCumple;
	}
	public void setFechaCumple(Date fechaCumple) {
		this.fechaCumple = fechaCumple;
	}
    
    
}
