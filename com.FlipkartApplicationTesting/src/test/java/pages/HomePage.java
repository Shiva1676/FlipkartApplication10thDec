/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.SwitchingWindows;
import utility.SynElement;

/**
 * @author Lenovo
 *
 */
public class HomePage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//button[@class= '_2AkmmA _29YdH8']")
	WebElement cancelButton;

	@FindBy(how = How.XPATH, using = ".//input[@type= 'text']")
	WebElement input;

	@FindBy(how = How.XPATH, using = ".//div[@class= '_3wU53n']")
	List<WebElement> mobileList;

	@FindBy(how = How.XPATH, using = ".//span[text()= 'Next']")
	WebElement nextButton;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public void cancelPopUpBox(String productName) throws InterruptedException {

		SynElement.waitForWebElement(driver, cancelButton).click();

		SynElement.waitForWebElement(driver, input).sendKeys(productName);

		input.submit();

		Thread.sleep(2000);

	}

	public boolean getHomePageDetails(String particularProduct) throws InterruptedException {

		boolean status = false;
		
		// Added 
		 SwitchingWindows.getParentId(driver);

		for (WebElement ele : mobileList) {

			String textValue = ele.getAttribute("innerHTML");

			// Thread.sleep(2000);

			if (textValue.equalsIgnoreCase(particularProduct)) {

				ele.click();
				
				System.out.println(particularProduct + "is matched with" + " " + textValue);

				status = true;
				// Added 
				SwitchingWindows.getChildID(driver);
				
                SwitchingWindows.switchingToChildWindow(driver);
			
                input.sendKeys("Mobiles");

				break;

			} else {

				System.out.println(particularProduct + "isn't matched with" + " " + textValue);

				status = false;
			}
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				mobileList.get(mobileList.size() - 1));

		// move slightly up as blue header comes in the picture
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");

		SynElement.waitForWebElement(driver, nextButton).click();

		WebElement OfferZone = driver.findElement(By.xpath(".//*[text()= 'Offer Zone']"));

		SynElement.waitForWebElement(driver, OfferZone).isDisplayed();

		Thread.sleep(2000);

		return status;
	}

	
	public void getNavigation(){
		
		driver.navigate().to("https://www.flipkart.com/");
		
		
	}
	
}
