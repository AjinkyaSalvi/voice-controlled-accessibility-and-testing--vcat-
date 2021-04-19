package com.mavs.uta.service.codegenerator.impl;

import com.mavs.uta.service.codegenerator.WebComponent;

public class Radio extends WebComponent {

	public  Radio(String componentType, String Xpath){
		setWebComponentType(componentType);
		setWebComponentXpath(Xpath);
		setComponentName(getComponentNameIdentifier());

	}
	@Override
	public String getComponentDefinition() {
		// TODO Auto-generated method stub
		
		
		String component = "\nList<WebElement>  listOfValues_" +  getComponentName()
				+ " = new Select(driver.findElements("+getSearchIdentifierString()+"));";

		if (null != component) {
			component += "\nlistOfValues_" +  getComponentName() + ".get("
					+ Integer.parseInt(getWebComponentValue()) + ");";
		}
		component +="\nThread.sleep(100);";

		return component;
	}

}
