package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;


@Entity

@NamedQueries({
	@NamedQuery(name = "select.mobile", query = "Select m from Mobile m"),
	@NamedQuery(name = "where.mobile", query = "select m from Mobile m where m.model = :model")
})
	public class Mobile {
	private int id;
	private String marka;
	private String model;
	private Osoba owner;
	private int cena;
	private int ram;
	private int cpu;
	
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
	
	@ManyToOne
	public Osoba getOwner() {
		return owner;
	}
	public void setOwner(Osoba owner) {
		this.owner = owner;
	}

	@Min(100)
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	
	
	
	
	

}
