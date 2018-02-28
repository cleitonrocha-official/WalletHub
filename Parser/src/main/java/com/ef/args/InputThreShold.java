package com.ef.args;

public class InputThreShold extends ArgumentCommand {

	public InputThreShold() {
		super("--threshold=");
	}
	
	@Override
	void createThisComand() {
		CommandList.getInstance().setThreShould(Integer.parseInt(checkFilter()));
	}

	
}
