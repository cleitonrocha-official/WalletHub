package com.ef.util;

import java.time.format.DateTimeFormatter;

public class DateFormatterUtil {
	static final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	static final private DateTimeFormatter formatterArgs = DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm:ss");
	public static DateTimeFormatter forReadLog() {
		return formatter;
	}
	
	public static DateTimeFormatter forInputByArgs() {
		return formatterArgs;
	}
	
}
