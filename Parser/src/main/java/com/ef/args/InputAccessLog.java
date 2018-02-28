package com.ef.args;

public class InputAccessLog extends ArgumentCommand {


	public InputAccessLog() {
		super("--accesslog=");
	}

	@Override
	void createThisComand() {
		CommandList.getInstance().setAccessLog(checkFilter());
	}



	


}
