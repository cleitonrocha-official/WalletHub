package com.ef.args;

public interface Arguments {

	
	void verifyArguments();
	
	default void checkNextCommand(Arguments arguments){
		arguments.verifyArguments();
	}
	
	
	
}
