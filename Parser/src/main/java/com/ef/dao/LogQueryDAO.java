package com.ef.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ef.entity.LogEntity;
import com.ef.entity.LogQuery;


public class LogQueryDAO extends GenericDAO<LogQuery> {

	public LogQueryDAO(EntityManager em) {
		super(em);
	}
	
	public List<LogEntity> getLogQueryFindAllLogs(LocalDateTime queryDate){
		
		TypedQuery<LogEntity> query = 
				em.createNamedQuery
				("LogQueryFindAllLogs", LogEntity.class);
		
		  query.setParameter("pCreatedIn", queryDate);
	     

	      return query.getResultList();
	
	}
	



	
}
