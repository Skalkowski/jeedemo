package com.example.jeedemo.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "select.sklep", query = "select s from Sklep s")
public class Sklep {
	private int id;
	private String nazwa;
	private Collection<Mobile> mobiles;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@ManyToMany
	public Collection<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Collection<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

}
