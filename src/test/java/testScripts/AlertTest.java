package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertTest {
  @Test
  public void variousAlerts() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  driver.findElement(By.id("alertBtn")).click();
	  Alert alert = driver.switchTo().alert();
	  System.out.println(alert.getText());
	  Assert.assertEquals(alert.getText(), "I am an alert box!");
	  alert.accept();
	  
	  driver.findElement(By.id("confirmBtn")).click();
	  Alert confirm = driver.switchTo().alert();
	  System.out.println(confirm.getText());
//	  Assert.assertEquals(confirm.getText(), "Press a button");
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertEquals(confirm.getText(), "Press a button!");
	  confirm.dismiss();
	  
	  driver.findElement(By.id("promptBtn")).click();
	  Alert prompt = driver.switchTo().alert();
	  System.out.println(prompt.getText());
	  prompt.sendKeys("Hello welcome");
	  prompt.accept();
	  
	  softAssert.assertAll();
	  
	  
  }
}
