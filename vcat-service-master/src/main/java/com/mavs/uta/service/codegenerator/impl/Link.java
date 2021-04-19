package com.mavs.uta.service.codegenerator.impl;

import com.mavs.uta.service.codegenerator.WebComponent;

public class Link extends WebComponent {

	public Link(String componentType, String Xpath) {
		setWebComponentType(componentType);
		setWebComponentXpath(Xpath);
		setComponentName(getComponentNameIdentifier());

	}

	@Override
	public String getComponentDefinition() {
		// TODO Auto-generated method stub
		String component = "\nWebElement element_" +  getComponentName()
				+ " = driver.findElement("+getSearchIdentifierString()+");";
		if (getAction() !=null && getAction().equals("click")) {
			component += "\nelement_" + getComponentName() + ".click();";

		}
		component +="\nThread.sleep(100);";

		return component;
	}
}
