package commonLibs.implementations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.Ijavascript;

public class JavascriptControl implements Ijavascript {
	
private WebDriver driver;
	 
	 public JavascriptControl(WebDriver driver) {
		this.driver = driver;
	}
	 
	 private JavascriptExecutor getjsEngine() {
		 JavascriptExecutor jsEngine;
		 jsEngine = (JavascriptExecutor) driver;
		 return jsEngine;
	 }

	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
		
		getjsEngine().executeScript(scriptToExecute);
		
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		
		String jsCommand = String.format("window.scrollBy(%d,%d)",x,y);
		getjsEngine().executeScript(jsCommand);
		
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
		return null;
	}
	 
	 
	 

}
