package com.mavs.uta.service.bean;

public class WebElement {

	private String elementtype;
	private String elementxpath;
	private String elementaction;
	private String elementvalue;

	public String getElementtype() {
		return elementtype;
	}

	public void setElementtype(String elementtype) {
		this.elementtype = elementtype;
	}

	public String getElementxpath() {
		return elementxpath;
	}

	public void setElementxpath(String elementxpath) {
		this.elementxpath = elementxpath;
	}

	public String getElementaction() {
		return elementaction;
	}

	public void setElementaction(String elementaction) {
		this.elementaction = elementaction;
	}

	public String getElementvalue() {
		return elementvalue;
	}

	public void setElementvalue(String elementvalue) {
		this.elementvalue = elementvalue;
	}

	@Override
	public String toString() {
		return "WebElement [elementtype=" + elementtype + ", elementxpath=" + elementxpath + ", elementaction="
				+ elementaction + ", elementvalue=" + elementvalue + "]";
	}

}
