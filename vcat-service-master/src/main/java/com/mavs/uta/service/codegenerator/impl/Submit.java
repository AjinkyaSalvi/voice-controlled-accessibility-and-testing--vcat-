package com.mavs.uta.service.codegenerator.impl;

import com.mavs.uta.service.codegenerator.WebComponent;

public class Submit extends WebComponent {

	public  Submit(String componentType, String Xpath){
		setWebComponentType(componentType);
		setWebComponentXpath(Xpath);
		setComponentName(getComponentNameIdentifier());
	}
	
	@Override
	public String getComponentDefinition() {
		// TODO Auto-generated method stub
		String component = "\n\tWebElement submit_" + getComponentName() + " = driver.findElement("
				+ getSearchIdentifierString() + ");";
		if (getAction() != null && (getAction().equals("click") || getAction().equals("submit"))) {
			component += "\n\tsubmit_" + getComponentName() + ".submit();";

		}
		component += "\n\tThread.sleep(1000);";
		return component;
	}

}
