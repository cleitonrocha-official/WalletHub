package com.ef.args;



public abstract class ArgumentCommand implements Arguments{

	private Arguments inputArguments;
	private String argument;
	private String filter;
	
	public ArgumentCommand(String filter) {
		this.argument = CommandList.getInstance().getArgToVerify();
		this.filter = filter;
	}

	@Override
	public void verifyArguments() {
		if(argument.contains(filter))
			createThisComand();
		else
			checkNextCommand(inputArguments);
	
	}
	
	abstract void createThisComand();

	public void setNextArguments(Arguments arguments) {
		this.inputArguments = arguments;
	}
	
	public String checkFilter(){
		return argument.replaceFirst(filter, "");
	}

	public String getArgument() {
		return argument;
	}


	public Arguments getInputArguments() {
		return inputArguments;
	}

	public String getFilter() {
		return filter;
	}

	
	
	
	
	
}
