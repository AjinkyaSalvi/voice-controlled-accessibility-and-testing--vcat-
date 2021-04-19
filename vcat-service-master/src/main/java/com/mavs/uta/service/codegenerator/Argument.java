package com.mavs.uta.service.codegenerator;
 

public class Argument {

	/**
	 * The type represents the data type of the argument.
	 */
	private String type;

	/**
	 * The name represents the name of the argument.
	 */
	private String name;

	public Argument(String type, String name) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getType() + " " + getName();
	}

}
