package com.ef.args;

public class CreateCommand {
	
	public static void tryThis(String argument){
		CommandList.getInstance().setArgToVerify(argument);
		
		InputThreShould inputThreShould 
		= new InputThreShould();

		InputDuration inputDuration 
		= new InputDuration();

		InputStartDate inputStartDate 
		= new InputStartDate();
		
		InputAccessLog inputAccessLog 
		= new InputAccessLog();
		
		inputAccessLog.setNextArguments(inputStartDate);
		inputStartDate.setNextArguments(inputDuration);
		inputDuration.setNextArguments(inputThreShould);
		
		inputAccessLog.verifyArguments();
	}
	

	
}
