/**
 * 
 */
package utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

/**
 * @author Lenovo
 *
 */
public class SwitchingWindows {

	static String parentID;

	static Set<String> allwindows;

	public static String getParentId(WebDriver driver) {

		parentID = driver.getWindowHandle();

		System.out.println("The parentID is:" + parentID);

		return parentID;
	}

	public static Set<String> getChildID(WebDriver driver) {

		allwindows = driver.getWindowHandles();

		System.out.println("The childID is:" + (allwindows.size() - 1));

		return allwindows;
	}

	
	public static void switchingToChildWindow(WebDriver driver) throws InterruptedException{
		
		for(String child:allwindows){
			
			if(!parentID.equalsIgnoreCase(child)){
				
				driver.switchTo().window(child);
				
				System.out.println("Switched to child window");
				
				Thread.sleep(3000);
				
			/*	driver.close();
				
				System.out.println("Child window closed");*/
			}
			
			driver.switchTo().window(parentID);
			
			
			System.out.println("Again its switched to parent window");
			
//			driver = Browsers.startBrowser(Config.getConfig().getBrowser(), Config.getConfig().getURL());
		}
		
	}
	
	
	
}
