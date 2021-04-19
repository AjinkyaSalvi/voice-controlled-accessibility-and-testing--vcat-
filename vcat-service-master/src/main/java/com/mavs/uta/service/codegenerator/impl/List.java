package com.mavs.uta.service.codegenerator.impl;

import com.mavs.uta.service.codegenerator.WebComponent;

public class List extends WebComponent {

	public  List(String componentType, String Xpath){
		setWebComponentType(componentType);
		setWebComponentXpath(Xpath);
		setComponentName(getComponentNameIdentifier());

	}
	@Override
	public String getComponentDefinition() {
		
		String component = "\nSelect select_" +  getComponentName()
				+ " = new Select(driver.findElement("+getSearchIdentifierString()+"));";
		if (getAction() !=null && getAction().equals("click")) {
			component += "\nselect_" +  getComponentName()
					+ ".selectByIndex(" + getWebComponentValue() + ");";
		}
		component +="\nThread.sleep(100);";

		return component;
	}

}
