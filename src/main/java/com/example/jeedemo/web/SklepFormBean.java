package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Mobile;
import com.example.jeedemo.domain.Sklep;
import com.example.jeedemo.service.SklepManager;

@SessionScoped
@Named("sklepF")
public class SklepFormBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Sklep sklep = new Sklep();
	private int[] id_telefonow;
	private ListDataModel<Mobile> mobiles = new ListDataModel<Mobile>();
	private ListDataModel<Sklep> sklepy = new ListDataModel<Sklep>();
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
		return "showSklep";
	}
	
	public ListDataModel<Mobile> getMobile(){
		mobiles.setWrappedData(sklepmanager.getMobile(sklep));
		return mobiles;
	}
	
	public ListDataModel<Sklep> getSklepy (){
		sklepy.setWrappedData(sklepmanager.selectSklep());
		return sklepy;
	}
	
	public String deleteSklep(){
		Sklep sklep = sklepy.getRowData();
		sklepmanager.deleteSklep(sklep);
		return "showSklep";
	}
	

}
