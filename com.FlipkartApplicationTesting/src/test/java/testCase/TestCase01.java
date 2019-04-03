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

import pages.HomePage;
import utility.HandleScreenshots;

/**
 * @author Lenovo
 *
 */
public class TestCase01 extends BaseClass{

	ExtentTest logger;
	
	@BeforeMethod
	public void setUpReport(){
		
		 logger =reports.startTest("Flipkart Application");
	}
	
	@AfterMethod
	public void closeReport(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(HandleScreenshots.getScreenshots(driver)));
			
		}
		
		reports.endTest(logger);
	}
	
	@Test
	public void verifyFlipKartSearchProduct() throws InterruptedException{
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		home.cancelPopUpBox("Mobiles");
		
		boolean status= false;
		
		for(int i=0; i<450; i++){
			
			 status = home.getHomePageDetails("Apple iPhone X (Space Gray, 64 GB)");
			
			if(status==true){
				
				logger.log(LogStatus.PASS, logger.addScreenCapture(HandleScreenshots.getScreenshots(driver)));
				
				break;
			}else{
				
				System.out.println(i +"Next page clicked");
			}
			
			
			
			
		}
		
		
	}
	
	
}
