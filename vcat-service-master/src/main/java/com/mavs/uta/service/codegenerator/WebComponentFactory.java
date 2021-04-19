package com.mavs.uta.service.codegenerator;

import com.mavs.uta.service.codegenerator.impl.Button;
import com.mavs.uta.service.codegenerator.impl.InputField;
import com.mavs.uta.service.codegenerator.impl.Link;
import com.mavs.uta.service.codegenerator.impl.List;
import com.mavs.uta.service.codegenerator.impl.Radio;
import com.mavs.uta.service.codegenerator.impl.Submit;

public class WebComponentFactory {

	public static WebComponent getComponent(String elementType, String elementValue, String elementXpath,
			String isElementAction) throws Exception {
		WebComponent component = null;
		if (null == elementType || elementType.equals("")) {
			throw new Exception("Element type cannot be empty");
		}
		if (null == elementXpath || elementXpath.equals("")) {
			throw new Exception("Element Xpath cannot be empty");
		}
		switch (elementType) {
		case "drop down":
			component = new List(elementType, elementXpath);
			break;

		case "input field":
		case "INPUT":
			
			component = new InputField("inputField", elementXpath);
			break;

		case "radio":
		case "check box":
			component = new Radio(elementType, elementXpath);
			break;

		case "link":
			component = new Link("link", elementXpath);
			break;

		case "button":
			component = new Button("button", elementXpath);
			break;

		case "submit":
			component = new Submit("submit", elementXpath);
			break;
		}
		component.setAction(isElementAction);
		component.setWebComponentValue(elementValue);
		return component;
	}
}
