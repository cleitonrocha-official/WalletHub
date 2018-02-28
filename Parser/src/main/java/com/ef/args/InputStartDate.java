package com.ef.args;

import java.time.LocalDateTime;

import com.ef.util.DateFormatterUtil;

public class InputStartDate extends ArgumentCommand {

	
	public InputStartDate() {
		super("--startDate=");
	}
	
	@Override
	void createThisComand() {
		CommandList.getInstance().setStartDate( LocalDateTime.parse(checkFilter(),
				DateFormatterUtil.forInputByArgs()));
	}







	





}
