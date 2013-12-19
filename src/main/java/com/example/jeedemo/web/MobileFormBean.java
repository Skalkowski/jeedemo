package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Mobile;
import com.example.jeedemo.service.MobileManager;


@SessionScoped
@Named("mobileForm")
public class MobileFormBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Mobile mobile = new Mobile();

	@Inject
	MobileManager mobilemanager;

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public String saveMobile() {
		mobilemanager.addMobile(mobile);
		return null;
	}

}
