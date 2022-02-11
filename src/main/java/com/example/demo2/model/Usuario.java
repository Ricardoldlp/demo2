package com.example.demo2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="TEST")
@ApiModel("Modelo de usuario")
public class Usuario {
	
	@Id
	private int id;
	
	@ApiModelProperty(value="Nombre de usuario", example="Manolo")
	@NotEmpty(message="Es necesario introducir el nombre del usuario")
	private String name;
	
	@ApiModelProperty(value="Fecha de nacimiento",dataType = "org.joda.time.LocalDate", example="2000/09/09")
	@NotNull(message = "Es necesario introducir la fecha de nacimiento")
	private Date fecha;
	
	//Constructores
	public Usuario() {
	}
	
	public Usuario(int id, String name, Date fecha) {
		super();
		this.id = id;
		this.name = name;
		this.fecha = fecha;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "ID: "+id+", Nombre: "+name+", Fecha nacimiento: "+fecha;
	}
	
	
	
}
