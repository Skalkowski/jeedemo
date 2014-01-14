package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Mobile;
import com.example.jeedemo.service.MobileManager;


@SessionScoped
@Named("mobileF")
public class MobileFormBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_osoba;
	private Mobile mobile = new Mobile();
	private ListDataModel<Mobile> mobiles = new ListDataModel<Mobile>(); 
	
	@Inject
	MobileManager mobilemanager;
	
	
	
	public int getId_osoba() {
		return id_osoba;
	}

	public void setId_osoba(int id_osoba) {
		this.id_osoba = id_osoba;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public String saveMobile() {
		mobilemanager.addMobile(mobile, id_osoba);
		return null;
	}
	
	public ListDataModel<Mobile> getTelefony(){
		mobiles.setWrappedData(mobilemanager.getMobiles());
		return mobiles;
		
	}
	

}
