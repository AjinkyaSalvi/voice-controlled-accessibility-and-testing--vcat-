package com.mavs.uta.service.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mavs.uta.service.bean.TestCaseMetric;
import com.mavs.uta.service.bean.TestCaseRequest;
import com.mavs.uta.service.bean.TestCaseResponse;
import com.mavs.uta.service.codegenerator.SeleniumConstants;
import com.mavs.uta.service.codegenerator.TestScriptSource;
import com.mavs.uta.service.codegenerator.TestScriptSourceUtility;
import com.mavs.uta.service.repository.TestCaseRepository;

@RestController
@RequestMapping(path = "/vcat")
public class TestCaseController {
	

	@Autowired
	private TestCaseRepository testCaseRepository;
	
	
	@PostMapping(value="/testcase",consumes="application/json", produces = "application/json")
	public ResponseEntity<TestCaseResponse> generateTestCase(@RequestBody TestCaseRequest testCaseRequest) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date start = new Date();
		String sourceFileName=SeleniumConstants.TESTCASE_NAME;
		String sourcePackage=SeleniumConstants.TESTCASE_BASE_PACKAGE;
		String URL=testCaseRequest.getUrl();
		System.out.println(testCaseRequest.toString());
		TestScriptSource source;
		try {
			source =  TestScriptSourceUtility.createTestScriptSourceFile(sourceFileName, sourcePackage, URL,testCaseRequest.getElements());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
        Date finish = new Date();
        
        long elapsed = start.getTime() - finish.getTime(); 
        
        int hours = (int) Math.floor(elapsed / 3600000);
        
        int minutes = (int) Math.floor((elapsed - hours * 3600000) / 60000);
        
        int seconds = (int) Math.floor((elapsed - hours * 3600000 - minutes * 60000) / 1000);
        
		TestCaseResponse response = new TestCaseResponse();
		response.setTestcase(source.getSourceAsString().toString());
		TestCaseMetric testCaseMetric = new TestCaseMetric();
		testCaseMetric.setOsType(testCaseRequest.getOs());
		testCaseMetric.setBrowserVersion(testCaseRequest.getChromeversion());
		testCaseMetric.setVcatUiTime(testCaseRequest.getExecutiontime());
		testCaseMetric.setVcatServerTime(minutes+"minutes and "+seconds+"seconds");
		testCaseMetric.setUsername(testCaseRequest.getUsername());
		testCaseMetric.setTestCase(source.getSourceAsString().toString());
		testCaseRepository.save(testCaseMetric);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/testcase")
	public boolean verifyUser(@RequestParam String username) {
    
		return testCaseRepository.existsByUsername(username);
	}

}
