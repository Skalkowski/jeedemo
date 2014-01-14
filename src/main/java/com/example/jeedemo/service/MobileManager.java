package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Mobile;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Sklep;


@Stateless
public class MobileManager {
	
	@PersistenceContext
	EntityManager entity;

    public void addMobile(Mobile mobile, int o) {
    	List<Mobile> mobiles = new ArrayList<Mobile>();
    	mobiles.add(mobile);
    	
        Osoba osoba = new Osoba();
    	osoba = entity.find(Osoba.class, o);
        
        Sklep s = new Sklep();
    	s.setNazwa("Kloc");
    	s.setMobiles(mobiles);
        
    	mobile.setOwner(osoba);
        
        
        entity.persist(s);
        entity.persist(mobile);
    	
    }
	
}
