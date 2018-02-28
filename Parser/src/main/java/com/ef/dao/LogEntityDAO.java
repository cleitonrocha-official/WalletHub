package com.ef.dao;

import javax.persistence.EntityManager;

import com.ef.entity.LogEntity;


public class LogEntityDAO extends GenericDAO<LogEntity>{

	public LogEntityDAO(EntityManager em) {
		super(em);
		
	}

	
}
