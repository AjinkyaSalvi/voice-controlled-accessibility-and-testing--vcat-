package com.mavs.uta.service.codegenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.mavs.uta.service.bean.WebElement;

public class TestScriptSourceUtility {

	/**
	 * The createTestScriptSourceFile is used to instantiate the TestScriptSource
	 * object
	 * 
	 * @param sourceFileName
	 * @param sourcePackage
	 * @param elements 
	 * @return
	 * @throws Exception
	 */
	public static TestScriptSource createTestScriptSourceFile(String sourceFileName, String sourcePackage, String URL, List<WebElement> elements) throws Exception {

		TestScriptSource source = new TestScriptSource(sourceFileName, sourcePackage);
		TestScriptSourceUtility.addImportsToSourceFile(source, SeleniumConstants.BY_IMPORT_PACKAGE);
		TestScriptSourceUtility.addImportsToSourceFile(source, SeleniumConstants.WEBDRIVER_IMPORT_PACKAGE);
		TestScriptSourceUtility.addImportsToSourceFile(source, SeleniumConstants.CHROMEDRIVER_IMPORT_PACKAGE);
		TestScriptSourceUtility.addImportsToSourceFile(source, SeleniumConstants.WEBELEMENT_IMPORT_PACKAGE);

		addURLConfigurationMethodToSource(source, URL);
		
		addTestCaseMethodToSource(source,elements);
		
		return source;
	}



	/**
	 * The addImportsToSourceFile is used to add an import to the source hierarchy
	 * 
	 * @param source
	 * @param importClass
	 * @throws Exception
	 */
	public static void addImportsToSourceFile(TestScriptSource source, String importClass) throws Exception {
		if (null == source) {
			throw new Exception();
		}
		Import imports = new Import(importClass);
		source.getImports().add(imports);
	}

	

	/**
	 * The addMethod is used to add an method to the source hierarchy
	 * 
	 * @param source
	 * @param methodReturnType
	 * @param methodName
	 * @param exceptions
	 * @param arguments
	 * @return
	 * @throws Exception
	 */
	public static Method addMethod(TestScriptSource source, String methodReturnType, String methodName, List exceptions,
			List arguments) throws Exception {

		if (null == source) {
			throw new Exception();
		}

		Method m = new Method(methodReturnType, methodName, exceptions, arguments);
		if (source.getMethods().contains(m)) {
			throw new Exception();
		} else {
			source.getMethods().add(m);
		}
		return m;
	}

	/**
	 * 
	 * The writeSourceToFile is used to write the source hierarchy as a java source
	 * file to the file system
	 * 
	 * @param source
	 * @param filePath
	 * @throws IOException
	 */
	public static void writeSourceToFile(TestScriptSource source, String filePath) throws IOException {

		File f = new File(filePath);
		FileUtils.cleanDirectory(f);

		System.out.println("deleted the old file..");

		System.out.println(f.exists());
		f = null;
		FileWriter fw = new FileWriter(filePath + "//" + source.getSourceFileName() + ".src");

		StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer);
		StringBuffer sourceString = source.getSourceAsString();
		System.out.println(sourceString);
		Scanner scan = new Scanner(sourceString.toString());
		while (scan.hasNextLine()) {
			String oneLine = scan.nextLine();
			out.println(oneLine);
		}
		
		fw.write(writer.toString());
		out.close();
		scan.close();
		fw.close();
	}

	private static void addURLConfigurationMethodToSource(TestScriptSource source, String URL) throws Exception {

		List<String> exceptions = new ArrayList<>();
		exceptions.add("Exception");
		List<Argument> arguments = new ArrayList<>();
		Argument arg = new Argument("String[]", "args");
		arguments.add(arg);
		Method method = TestScriptSourceUtility.addMethod(source, "void", "main", exceptions, arguments);

		StringBuffer definition = new StringBuffer();
		definition.append(
				"\n\tSystem.setProperty(\"webdriver.chrome.driver\", \"c:\\\\Softwares\\\\chromedriver.exe\");");
		definition.append("\n\tWebDriver driver = new ChromeDriver();");
		definition.append("\n\tdriver.get(\"" + URL + "\");");
		definition.append("\n\tThread.sleep(1000);\n");

		method.setDefinition(definition);
		source.setMainMethod(method);

	}
	
	private static void addTestCaseMethodToSource(TestScriptSource source, List<WebElement> elements) throws Exception {
		// TODO Auto-generated method stub
		List<String> exceptions = new ArrayList<>();
		exceptions.add("Exception");
		
		List<Argument> arguments = new ArrayList<>();
		Argument arg = new Argument("WebDriver", "driver");
		arguments.add(arg);
		
		int methodCount=source.getMethods().size()+1;
		Method method = TestScriptSourceUtility.addMethod(source, "void", "testCaseMethod"+methodCount,exceptions,arguments);
		for (WebElement webElement : elements) {
			WebComponent component = WebComponentFactory.getComponent(webElement.getElementtype(), 
					webElement.getElementvalue(), webElement.getElementxpath(), webElement.getElementaction());
			method.getDefinition().append(component.getComponentDefinition());
			
		}
		source.getMainMethod().getDefinition().append("\n\ttestCaseMethod"+methodCount+"(driver);\n");
	}
}
