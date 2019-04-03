/**
 * 
 */
package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Lenovo
 *
 */
public class Browsers {

	static WebDriver driver;

	public static WebDriver startBrowser(String browser, String url) {

		if (browser.equalsIgnoreCase("Chrome")) {

			/*
			 * ChromeOptions options = new ChromeOptions();
			 * 
			 * options.addArguments("--start maximized");
			 * 
			 * options.addArguments("--start fullscreen");
			 */

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			System.out.println("The following browser is running on:" + browser);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

			System.out.println("The following browser is running on:" + browser);

		} else if (browser.equalsIgnoreCase("IE")) {

			driver = new InternetExplorerDriver();

			driver.manage().window().maximize();

			System.out.println("The following browser is running on:" + browser);
		}

		driver.get(url);

		return driver;

	}

}
