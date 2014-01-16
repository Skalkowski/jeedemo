package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.service.OsobaManager;

@SessionScoped    //dostepna w sesji 
@Named("osobaF") //nazwa gdzie odnosze sie w formularz
public class OsobaFormBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Osoba osoba = new Osoba();
	private ListDataModel<Osoba> osoby =new ListDataModel<Osoba>();
	private String imie;

	@Inject
	OsobaManager osobamanager;
	
	
	
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String addOsoba(){
		osobamanager.addOsoba(osoba);
		return "showOsoba";
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	public ListDataModel<Osoba> getOsoby (){
		osoby.setWrappedData(osobamanager.selectOsoba());
		return osoby;
	}
	
	public ListDataModel<Osoba> getOsobyWhere (String imie){
		osoby.setWrappedData(osobamanager.selectOsobaWhere(imie));
		return osoby;
	}
	
	public String deleteOsoba(){
		Osoba osoba = osoby.getRowData();
		osobamanager.deleteOsoba(osoba);
		return "showOsoba";
	}
	
}
