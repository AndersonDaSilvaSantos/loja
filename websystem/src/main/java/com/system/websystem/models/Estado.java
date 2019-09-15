package com.system.websystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
	
	
	@Id
	private long id;
	private String nome;
	private String sigla;
	
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	

}
