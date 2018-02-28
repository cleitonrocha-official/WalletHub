package com.ef.args;

public class InputDuration extends ArgumentCommand {

	public InputDuration() {
		super("--duration=");
	}

	@Override
	void createThisComand() {
		for (Duration value : Duration.values())
			if (value.checkCommand(getArgument()))
				CommandList.getInstance().setDuration(value);
	}

}
