package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActionsTest {
  @Test
  public void MouseActions() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  driver.manage().deleteAllCookies();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  WebElement txtField = driver.findElement(By.id("field2"));
	  actions.scrollToElement(txtField).perform();
	  
	  WebElement btn = driver.findElement(By.xpath("//button[contains(text(), 'Point Me')]"));
	  actions.moveToElement(btn).perform();
	  
	  WebElement item2 = driver.findElement(By.linkText("Laptops"));
	  actions.click(item2).perform();
	  
	  Thread.sleep(3000);
//	  actions.moveToElement(btn).click(item2).build().perform();
	  WebElement btnDbl = driver.findElement(By.xpath("//button[contains(text(), 'Copy Text')]"));
	  actions.doubleClick(btnDbl).perform();
	  actions.contextClick(txtField).perform();
	  
	  
  }
}
