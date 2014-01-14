package com.example.jeedemo.service;

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
	
}
