package co.gov.shd.model;

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

    
    
}
