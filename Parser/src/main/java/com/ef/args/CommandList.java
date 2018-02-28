package com.ef.args;

import java.time.LocalDateTime;

public class CommandList {

	private String accessLog = "";
	private LocalDateTime startDate;
	private Duration duration;
	private int threShould = 0;
	private String arg;
	private final static CommandList thisInstance = new CommandList();

	public static CommandList getInstance() {
		return thisInstance;
	}

	private CommandList() {
		
	}
	public String getArgToVerify() {
		return arg;
	}

	public void setArgToVerify(String arg) {
		this.arg = arg;
	}

	public String getAccessLog() {
		return accessLog;
	}

	public void setAccessLog(String accessLog) {
		this.accessLog = accessLog;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public int getThreShould() {
		return threShould;
	}

	public void setThreShould(int threShould) {
		this.threShould = threShould;
	}

}
