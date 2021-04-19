package com.mavs.uta.service.bean;

import java.util.List;

public class TestCaseRequest {
	
	private String url;
	private String os;
	private String chromeversion;
	private String executiontime;
	private String username;
	private List<WebElement> elements;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<WebElement> getElements() {
		return elements;
	}
	public void setElements(List<WebElement> elements) {
		this.elements = elements;
	}
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	public String getChromeversion() {
		return chromeversion;
	}
	public void setChromeversion(String chromeversion) {
		this.chromeversion = chromeversion;
	}
	public String getExecutiontime() {
		double duration = Double.parseDouble(this.executiontime);
		int seconds = (int) ((duration / 1000) % 60);
		int minutes = (int) ((duration / 1000) / 60);
		return String.format("%d minutes and %d seconds.",  minutes, seconds);
	}
	public void setExecutiontime(String executiontime) {
		this.executiontime = executiontime;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "TestCaseRequest [url=" + url + ", os=" + os + ", chromeversion=" + chromeversion + ", executiontime="
				+ executiontime + ", username=" + username + ", elements=" + elements + "]";
	}


	
	

}
