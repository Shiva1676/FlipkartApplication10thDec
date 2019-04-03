/**
 * 
 */
package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

import factory.Browsers;
import factory.Config;
import utility.HandleCurrentDateAndTime;

/**
 * @author Lenovo
 *
 */
public class BaseClass {

	WebDriver driver;

	ExtentReports reports;

	@BeforeSuite
	public void startReporting() {

		System.out.println("=============Reports starting==============");

		String path = System.getProperty("user.dir") + "/Reports/Flipkart" + HandleCurrentDateAndTime.getDateAndTime()
				+ ".html";

		reports = new ExtentReports(path);

		System.out.println("=============Reports Started=================");
	}

	@AfterSuite
	public void flushReport() {

		reports.close();

		System.out.println("Closed reporting");
	}

	@BeforeTest
	public void startBrowser() {

		System.out.println("==============Browser & url are about to start============");

		driver = Browsers.startBrowser(Config.getConfig().getBrowser(), Config.getConfig().getURL());

		System.out.println("=============Browser & url are up and running=============");
	}

	/*@AfterTest
	public void closeBrowser() {

		driver.quit();

		System.out.println("============Browser closed================");
	}*/

}
