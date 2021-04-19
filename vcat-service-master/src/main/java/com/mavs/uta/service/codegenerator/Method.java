package com.mavs.uta.service.codegenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Method {

	final String METHOD_ACCESS_MODIFIER = "public";
	private String returnType;
	private List<String> exceptions;
	private StringBuffer definition;
	private List<Argument> argument;
	private String name;
	private Set<Variable> variables;
	
	public Method(String methodReturnType, String methodName, List<String> exceptions,List<Argument> arguments) {
		// TODO Auto-generated constructor stub
		this.returnType=methodReturnType;
		this.name=methodName;
		this.exceptions=exceptions;
		this.argument=arguments;
		this.variables = new HashSet<Variable>();
		this.definition = new StringBuffer();
	}

	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public List<String> getExceptions() {
		return exceptions;
	}
	public void setExceptions(List<String> exceptions) {
		this.exceptions = exceptions;
	}
	public StringBuffer getDefinition() {
		return definition;
	}
	public void setDefinition(StringBuffer definition) {
		this.definition = definition;
	}
	public String getMETHOD_ACCESS_MODIFIER() {
		return METHOD_ACCESS_MODIFIER;
	}
	public List<Argument> getArgument() {
		return argument;
	}
	public void setArgument(List<Argument> argument) {
		this.argument = argument;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Variable> getVariables() {
		return variables;
	}
	public void setVariables(Set<Variable> variables) {
		this.variables = variables;
	}
	
	
}
