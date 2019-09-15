package com.system.websystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade {
	
	
	@Id
	private long id;
	private String nome;
	private Estado estado;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

}
