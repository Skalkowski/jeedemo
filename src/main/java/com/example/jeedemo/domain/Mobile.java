package com.example.jeedemo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Mobile {
	private int id;
	private String marka;
	private String model;
	private Osoba owner;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Osoba getOwner() {
		return owner;
	}
	public void setOwner(Osoba owner) {
		this.owner = owner;
	}
	
	

}