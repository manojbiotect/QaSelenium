package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitTillElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		 wait.until(ExpectedConditions.visibilityOf(element));
		
	}

}
