package com.system.websystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Venda {
	
	
	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
