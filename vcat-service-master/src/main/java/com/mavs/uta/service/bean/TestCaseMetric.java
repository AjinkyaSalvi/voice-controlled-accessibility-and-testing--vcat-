package com.mavs.uta.service.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestCaseMetric {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String osType;
	private String browserVersion;
	private String vcatUiTime;
	private String vcatServerTime;
	private String username;
	private String testCase;
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getBrowserVersion() {
		return browserVersion;
	}
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	public String getVcatUiTime() {
		return vcatUiTime;
	}
	public void setVcatUiTime(String vcatUiTime) {
		this.vcatUiTime = vcatUiTime;
	}
	public String getVcatServerTime() {
		return vcatServerTime;
	}
	public void setVcatServerTime(String vcatServerTime) {
		this.vcatServerTime = vcatServerTime;
	}
	public String getTestCase() {
		return testCase;
	}
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
