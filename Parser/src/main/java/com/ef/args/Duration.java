package com.ef.args;

public enum Duration {
	
	HOURLY("hourly"),DAILY("daily");
	
	private final String value;
	
	Duration(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public boolean checkCommand(String arg){
		return arg.contains(getValue());
		
	}
	
	
}
