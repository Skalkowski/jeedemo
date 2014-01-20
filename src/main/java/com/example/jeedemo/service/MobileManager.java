package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Mobile;
import com.example.jeedemo.domain.Osoba;


@Stateless
public class MobileManager {
	
	@PersistenceContext
	EntityManager sql;

    public void addMobile(Mobile mobile, int o) {
    	List<Mobile> mobiles = new ArrayList<Mobile>();
    	mobiles.add(mobile);
    	
        Osoba osoba = new Osoba();
    	osoba = sql.find(Osoba.class, o);
        
        
        
    	mobile.setOwner(osoba);
        sql.persist(mobile);
    	
    }
    
    @SuppressWarnings("unchecked")
	public List<Mobile> getMobiles(){
     	
    	return sql.createNamedQuery("select.mobile").getResultList();
    }
    public void deleteMobile (Mobile mobile){
		mobile = sql.find(Mobile.class, mobile.getId());
		sql.remove(mobile);
	}
    
    @SuppressWarnings("unchecked")
	public List<Osoba> selectMobileWhere(String model){
		
		return sql.createNamedQuery("where.mobile").setParameter("model", model).getResultList();
	}
}
	

