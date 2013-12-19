package com.example.jeedemo.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Mobile;


@Stateless
public class MobileManager {
	
	@PersistenceContext
	EntityManager entity;

    public void addMobile(Mobile mobile) {
            entity.persist(mobile);
    }
	
}
