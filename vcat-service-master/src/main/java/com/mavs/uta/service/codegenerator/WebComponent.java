
package com.mavs.uta.service.codegenerator;

import java.util.Random;

public abstract class WebComponent {


	/**
	 * The componentType represents the type of the webcomponent
	 */
	private String webComponentType;

	/**
	 * The xpath of the webcomponent
	 */
	private String webComponentXpath;

	/**
	 * The webComponentValue represents the value the component can get assigned if
	 * an action is set to the webcomponent
	 */
	private String webComponentValue;

	/**
	 * The inputType represents the input type of the webcomponent
	 */
	private String inputType;

	/**
	 * The boolean flag to represent if the component is set an action or not
	 */
	private String action;

	/**
	 * The component name of the component
	 */
	private String componentName;
	
	

	public abstract String getComponentDefinition();

	public String getComponentImportPackage() {
		return SeleniumConstants.WEBELEMENT_IMPORT_PACKAGE;
	}
	
	public String getWebComponentType() {
		return webComponentType;
	}

	public void setWebComponentType(String webComponentType) {
		this.webComponentType = webComponentType;
	}

	public String getWebComponentXpath() {
		return webComponentXpath;
	}

	public void setWebComponentXpath(String webComponentXpath) {
		this.webComponentXpath = webComponentXpath;
	}

	public String getWebComponentValue() {
		return webComponentValue;
	}

	public void setWebComponentValue(String webComponentValue) {
		this.webComponentValue = webComponentValue;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentNameIdentifier() {
		String componentName = "";
		componentName = Integer.toString((new Random()).nextInt(100));
		return componentName;
	}

	public String getSearchIdentifierString() {
		String identify = "";
		identify = "By.xpath(\"" + getWebComponentXpath() + "\")";
		return identify;
	}

}
