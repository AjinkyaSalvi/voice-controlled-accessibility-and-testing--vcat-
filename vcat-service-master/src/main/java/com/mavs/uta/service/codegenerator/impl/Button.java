package com.mavs.uta.service.codegenerator.impl;

import com.mavs.uta.service.codegenerator.WebComponent;

public class Button extends WebComponent {

	public  Button(String componentType, String Xpath){
		setWebComponentType(componentType);
		setWebComponentXpath(Xpath);
		setComponentName(getComponentNameIdentifier());
	}
	@Override
	public String getComponentDefinition() {
		
		String component = "\n\tWebElement button_" + getComponentName()
				+ " = driver.findElement("+getSearchIdentifierString()+");";
		if (getAction() !=null && getAction().equals("click")) {
			component += "\n\tbutton_" + getComponentName() + ".click();";

		}
		component +="\n\tThread.sleep(1000);";
		return component;
	}
	@Override
	public String getComponentImportPackage() {
		// TODO Auto-generated method stub
		return null;
	}

}
