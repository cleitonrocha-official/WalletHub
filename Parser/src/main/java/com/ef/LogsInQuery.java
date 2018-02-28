package com.ef;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import com.ef.dao.LogQueryDAO;
import com.ef.entity.LogEntity;
import com.ef.util.DateFormatterUtil;
import com.ef.util.JPAUtil;

public class LogsInQuery {
	
	public static void main(String[] args) {
		EntityManager  em = new JPAUtil().getEntityManager();
		
		//"yyyy-MM-DD.HH:mm:ss"
		em.getTransaction().begin();
		LocalDateTime dateQuery = 
				LocalDateTime.parse(args[0], 
			DateFormatterUtil.forInputByArgs());
		List<LogEntity> logQueryFindAllLogs = new LogQueryDAO(em).getLogQueryFindAllLogs(dateQuery);
		logQueryFindAllLogs.forEach(System.out::println);
		em.getTransaction().commit();
		
		
	}
}
