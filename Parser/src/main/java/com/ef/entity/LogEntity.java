package com.ef.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ef.JPQL;
import com.ef.util.GsonTransformer;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "log_entity")
@NamedQuery( name = "LogEntity"+JPQL.QUERY_BETWEEN_DATE,query = "SELECT l.ip FROM LogEntity l "
		+ "WHERE l.date BETWEEN :"+JPQL.START_DATE +" AND :"+JPQL.END_DATE )
public class LogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
	private long id;
	
	@Expose
	@Column(name = "date_time")
	private LocalDateTime date;

	@Expose
	@Column(name = "ip")
	private String ip;

	@Expose
	@Column(name = "request")
	private String request;

	@Expose
	@Column(name = "status")
	private int status;

	@Expose
	@Column(name = "user_agent")
	private String userAgent;

	public Long getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public String toString() {
		return GsonTransformer.toJson(this);
	}

}
