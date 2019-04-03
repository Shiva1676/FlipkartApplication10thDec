/**
 * 
 */
package testCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Config;
import pages.HomePage;
import utility.HandleScreenshots;

/**
 * @author Lenovo
 *
 */
public class TestCase03 extends BaseClass {

	ExtentTest logger;

	@BeforeMethod
	public void setUpReport() {

		logger = reports.startTest("Flipkart Application");
	}

	@AfterMethod
	public void closeReport(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, logger.addScreenCapture(HandleScreenshots.getScreenshots(driver)));

		}

		reports.endTest(logger);
	}

	@Test
	public void verifyFlipKartSearchProduct() throws InterruptedException {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		home.cancelPopUpBox("Mobiles");

		// Reading excel data

		int rows = Config.getExcelConfig().getRow("Sheet1");

		System.out.println("The number of rows present in Sheet1 is:" + rows);

		int columns = Config.getExcelConfig().getColumn("Sheet1");

		System.out.println("The number of columns are present in Sheet1 is:" + columns);

		String data = "";

		boolean status = false;

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns; j++) {

				if (j == 0)	;


				data = Config.getExcelConfig().getExcelData("Sheet1", i, j);

				for (int k = 0; k < 450; k++) {

					status = home.getHomePageDetails(data);

					if (status == true) {

						break;

					} else {

						System.out.println(k + "Next page clicked");
						
					}

				}

			}

		}

	}

} 
