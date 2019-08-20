package commonPages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementations.AlertsControl;
import commonLibs.implementations.DropDownControl;
import commonLibs.implementations.ElementControl;

public class BasePage {
	
	public DropDownControl dropdownControl;
	
	public ElementControl elementControl;
	
	public AlertsControl alertControl; 
	
	
	public BasePage(WebDriver driver) {
		
		dropdownControl = new DropDownControl();
		
		elementControl = new ElementControl();
		
		alertControl = new AlertsControl(driver);
		
		
	}
	
	

}
