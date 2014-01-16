package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Mobile;
import com.example.jeedemo.domain.Sklep;

@Stateless
public class SklepManager {

		@PersistenceContext
		EntityManager sql;
		
		public void addSklep(Sklep sklep, int[] tabId){
			List<Mobile> mobile = new ArrayList<Mobile>();
			for(int e: tabId){
				Mobile komorka = new Mobile();
				komorka = sql.find(Mobile.class, e);
				mobile.add(komorka);
			}
			sklep.setMobiles(mobile);
			sql.persist(sklep);
		}
		public List<Mobile> getMobile(Sklep sklep){
			sklep = sql.find(Sklep.class, sklep.getId());
			List<Mobile> mobile = new ArrayList<Mobile>(sklep.getMobiles());
			return mobile;
		}
		
		public void deleteSklep (Sklep sklep){
			sklep = sql.find(Sklep.class, sklep.getId());
			sql.remove(sklep);
		}
		
		@SuppressWarnings("unchecked")
		public List<Sklep> selectSklep(){
			return sql.createNamedQuery("select.sklep").getResultList();
		}
}
		
