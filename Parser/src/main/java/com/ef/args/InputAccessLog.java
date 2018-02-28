package com.ef.args;

public class InputAccessLog extends ArgumentCommand {


	public InputAccessLog() {
		super("--accessLog=");
	}

	@Override
	void createThisComand() {
		CommandList.getInstance().setAccessLog(checkFilter());
	}



	


}
