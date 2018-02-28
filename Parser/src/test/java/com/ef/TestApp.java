package com.ef;

import static org.junit.Assert.*;


import org.junit.Test;

import com.ef.args.CommandList;
import com.ef.args.CreateCommand;

//test example with JUNIT

public class TestApp {
	
	String[] arguments =  {
			"--startDate=2017-01-01.13:00:00", 
					"--duration=hourly", 
					"--threShould=10",
					"--accessLog=access.log"};
	
	
	@Test
	public void createAnysCommandFromAnInput(){
		
		for (String argument : arguments)
			CreateCommand.tryThis(argument);
		
		assertEquals("access.log",CommandList.getInstance().getAccessLog());
		assertEquals(10,CommandList.getInstance().getThreShould());
		
		
		
	}
	
	
	


}
