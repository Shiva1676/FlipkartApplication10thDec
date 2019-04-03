/**
 * 
 */
package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Lenovo
 *
 */
public class SynElement {

	
	public static WebElement waitForWebElement(WebDriver driver, WebElement ele){
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		return wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
}
