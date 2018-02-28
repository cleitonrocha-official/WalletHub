package com.ef.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ef.JPQL;


public abstract class GenericDAO<T> {
	
	protected EntityManager em;
	private Class<T> clazz;
	

	public GenericDAO(EntityManager em) {
		this.em = em;
	
	}

	public List<T> getListBetween(LocalDateTime startDate, LocalDateTime endDate){
		
		TypedQuery<T> query = 
				em.createNamedQuery
				(clazz.getSimpleName()+JPQL.QUERY_BETWEEN_DATE, clazz);
		
		  query.setParameter(JPQL.START_DATE, startDate);
	      query.setParameter(JPQL.END_DATE, endDate);

	      return query.getResultList();
	
	}

}