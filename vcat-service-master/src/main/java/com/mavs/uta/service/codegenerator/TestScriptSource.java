package com.mavs.uta.service.codegenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class TestScriptSource {

	private Set<Import> imports;
	private List<Method> methods;
	private Method mainMethod;
	private String sourcePackage;
	private String sourceFileName;
	final String SPACE=" ";
	private List<Variable> variables;
	public TestScriptSource(String sourceFileName, String sourcePackage) {
		// TODO Auto-generated constructor stub
		this.sourceFileName = sourceFileName;
		this.sourcePackage = sourcePackage;
		this.imports = new HashSet<Import>();
		this.methods = new ArrayList<Method>();
	}
	public Set<Import> getImports() {
		return imports;
	}
	public void setImports(Set<Import> imports) {
		this.imports = imports;
	}
	public List<Method> getMethods() {
		return methods;
	}
	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}
	public String getSourcePackage() {
		return sourcePackage;
	}
	public void setSourcePackage(String sourcePackage) {
		this.sourcePackage = sourcePackage;
	}
	public String getSourceFileName() {
		return sourceFileName;
	}
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}
	public Method getMainMethod() {
		return mainMethod;
	}
	public void setMainMethod(Method mainMethod) {
		this.mainMethod = mainMethod;
	}
	public List<Variable> getVariables() {
		return variables;
	}
	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}
	public StringBuffer getSourceAsString() {
		// TODO Auto-generated method stub
		StringBuffer sourceString = new StringBuffer();
		
		sourceString.append("package"+SPACE+sourcePackage+";\n");

		for(Import imp : imports){
			sourceString.append("import"+SPACE+imp.getImportClass()+";\n");
		}
		sourceString.append("public class "+sourceFileName+" {\n");
		for(Method method : methods){
			
			sourceString.append(method.METHOD_ACCESS_MODIFIER+SPACE+"static"+SPACE+method.getReturnType()
					+SPACE+method.getName());
			
			if(method.getArgument()!=null){
				sourceString.append("("+StringUtils.join(method.getArgument(), ',')+")");
			}else{
				sourceString.append("()");
			}
			
			if(method.getExceptions()!=null){
				sourceString.append(SPACE+"throws"+SPACE+StringUtils.join(method.getExceptions(), ','));
			}
			sourceString.append("{\n");
			sourceString.append(method.getDefinition());
			sourceString.append("\n\tThread.sleep(10000);");
			sourceString.append("\n\tdriver.close();");
			sourceString.append("\n}\n");
			
		}
		sourceString.append("\n}\n");
		return sourceString;
	}
	

	@Override
	public String toString() {
		return "TestScriptSource [imports=" + imports + ", methods=" + methods
				+ ", sourcePackage=" + sourcePackage + ", sourceFileName="
				+ sourceFileName + "]";
	}
	
	
}
