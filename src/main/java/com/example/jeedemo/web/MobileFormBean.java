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
	private ListDataModel<Mobile> mobileWhere = new ListDataModel<Mobile>();
	private String model;
	@Inject
	MobileManager mobilemanager;
	
	public ListDataModel<Mobile> getMobileWhere() {
		return mobileWhere;
	}

	public void setMobileWhere(ListDataModel<Mobile> mobileWhere) {
		this.mobileWhere = mobileWhere;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

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
		return "showMobile";
	}
	
	public ListDataModel<Mobile> getTelefony(){
		mobiles.setWrappedData(mobilemanager.getMobiles());
		return mobiles;
		
	}
	public String deleteMobile(){
		Mobile mobile = mobiles.getRowData();
		mobilemanager.deleteMobile(mobile);
		return "showMobile";
	}
	
	public String getMobileWheree(){
		mobileWhere.setWrappedData(mobilemanager.selectMobileWhere(model));
		return null;
	}
	
	public ListDataModel<Mobile> getMobileWhere (String model){
		mobiles.setWrappedData(mobilemanager.selectMobileWhere(model));
		return mobiles;
	}
	

}
