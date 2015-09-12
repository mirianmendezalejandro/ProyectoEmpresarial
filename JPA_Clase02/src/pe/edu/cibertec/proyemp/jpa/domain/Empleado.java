package pe.edu.cibertec.proyemp.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Empleado {
	
@Id
@GeneratedValue
private Long id;

private String nombre;

@OneToOne
private  Departamento departamento;


public Empleado() {}

public Empleado(String nombre, Departamento departamento) {
	super();
	this.nombre = nombre;
	this.departamento = departamento;
}

public Empleado(String nombre) {
	super();
	this.nombre = nombre;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

@Override
public String toString() {
	return "Empleado [id=" + id + ", nombre=" + nombre + "]";
}


}
