package com.mavs.uta.service.codegenerator.impl;


import com.mavs.uta.service.codegenerator.WebComponent;

public class InputField extends WebComponent{

	public  InputField(String componentType, String Xpath){
		setWebComponentType(componentType);
		setWebComponentXpath(Xpath);
		setComponentName(getComponentNameIdentifier());


	}
	@Override
	public String getComponentDefinition() {
		// TODO Auto-generated method stub
		String component = "\nWebElement inputBox_" +  getComponentName()
				+ " = driver.findElement("+getSearchIdentifierString()+");";
		
		if (getAction() !=null && getAction().equals("set")) {
			component += "\ninputBox_" +  getComponentName()
					+ ".sendKeys(\"" + getWebComponentValue() + "\");";

		}
		component +="\nThread.sleep(100);";

		return component;
	}

}
