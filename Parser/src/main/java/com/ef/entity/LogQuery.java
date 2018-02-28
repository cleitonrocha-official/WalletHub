package com.ef.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ef.JPQL;
import com.ef.util.GsonTransformer;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "log_queries")
@NamedQueries( {
	@NamedQuery(name = "LogQuery"+JPQL.QUERY_BETWEEN_DATE ,query = "SELECT q.createdIn FROM LogQuery q "
		+ "WHERE q.createdIn BETWEEN :"+JPQL.START_DATE +" AND :"+ JPQL.END_DATE )
	,
	@NamedQuery(name = "LogQueryFindAllLogs" ,query = "SELECT l FROM LogQuery q, IN(q.logs) l "
			+ "WHERE q.createdIn=:pCreatedIn")
	
})


public class LogQuery {

	@Id
	@Column(name = "created_in")
	@Expose
	private LocalDateTime createdIn = LocalDateTime.now();

	@Column(name = "comentary")
	@Expose
	private String comentary;
	
	@OneToMany( targetEntity = LogEntity.class, cascade = CascadeType.ALL)
	@Column(name = "logs")
	@Expose
	private List<LogEntity> logs = new ArrayList<>();

	public LogQuery() {}
	
	public LogQuery(List<LogEntity> logs,String comentary) {
		this.logs = logs;
		this.comentary = comentary;
	}

	public LocalDateTime getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(LocalDateTime createdIn) {
		this.createdIn = createdIn;
	}
	
	public String getComentary() {
		return comentary;
	}

	public void setComentary(String comentary) {
		this.comentary = comentary;
	}

	public List<LogEntity> getLogs() {
		return logs;
	}

	public void setLogs(List<LogEntity> logs) {
		this.logs = logs;
	}
	
	@Override
	public String toString() {
		return GsonTransformer.toJson(this);
	}
	
	
	
}
