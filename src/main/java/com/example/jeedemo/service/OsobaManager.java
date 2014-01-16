package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Osoba;

@Stateless //bez stanowe
public class OsobaManager {

		@PersistenceContext //moge operowac na bazie danych
		EntityManager sql;
		
		public void addOsoba(Osoba osoba){
			sql.persist(osoba); //zapisanie do bazy danych
		}
		
		@SuppressWarnings("unchecked")
		public List<Osoba> selectOsoba(){
			return sql.createNamedQuery("select.osoba").getResultList();
		}
		public void deleteOsoba (Osoba osoba){
			osoba = sql.find(Osoba.class, osoba.getId());
			sql.remove(osoba);
		}
		
		@SuppressWarnings("unchecked")
		public List<Osoba> selectOsobaWhere(String imie){
			
			return sql.createNamedQuery("where.osoba").setParameter("imie", imie).getResultList();
		}
	
}
