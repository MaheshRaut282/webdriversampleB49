
package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WinPopupTest {
  @Test
  public void winPop() throws InterruptedException {
	  WebDriver driver = new EdgeDriver();
	  Actions actions = new Actions(driver);
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://demoqa.com/browser-windows");
	  String parentwin = driver.getWindowHandle();
	  Thread.sleep(5000);
	  actions.scrollByAmount(100, 1200).perform();
	  System.out.println("Parent win...." + parentwin);
	  
	  driver.findElement(By.id("tabButton")).click();
	  System.out.println("page title...." + driver.getTitle());
	  
	  Set<String> wins = driver.getWindowHandles();
	  System.out.println("No. of windows....." + wins.size());
	  
	  for (String child : wins) {
		  System.out.println("Wind Handles...." + child);
		  if(!child.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(child);
			  Thread.sleep(2000);
			  String h1TagText = driver.findElement(By.cssSelector("h1#sampleHeading")).getText();
			  System.out.println("Text in Tab window...." +h1TagText);
		  }
	  }
	  driver.close();
	  
	  driver.switchTo().window(parentwin);
	  driver.findElement(By.id("windowButton")).click();
	  
	  driver.switchTo().newWindow(WindowType.WINDOW);
	  driver.get("https://testautomationpractice.blogspot.com/");
	  driver.quit();
  }
}
