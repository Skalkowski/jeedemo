package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Sklep;
import com.example.jeedemo.service.SklepManager;

@SessionScoped
@Named("sklepF")
public class SklepFormBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Sklep sklep = new Sklep();
	private int[] id_telefonow;
	
	@Inject
	SklepManager sklepmanager;

	public Sklep getSklep() {
		return sklep;
	}

	public void setSklep(Sklep sklep) {
		this.sklep = sklep;
	}

	public int[] getId_telefonow() {
		return id_telefonow;
	}

	public void setId_telefonow(int[] id_telefonow) {
		this.id_telefonow = id_telefonow;
	}
	
	public String addSklep(){
		sklepmanager.addSklep(sklep, id_telefonow);
		return null;
	}
	

}
