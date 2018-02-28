package com.ef.args;

public class InputThreShould extends ArgumentCommand {

	public InputThreShould() {
		super("--threShould=");
	}
	
	@Override
	void createThisComand() {
		CommandList.getInstance().setThreShould(Integer.parseInt(checkFilter()));
	}

	
}
