package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioChkBoxTest {
  @Test
  public void selectRadioTest() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
//	  driver.get("https://the-internet.herokuapp.com/checkboxes");
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
//	  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
//	  boolean isSel = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected();
//	  if(isSel) {
//		  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		  
//	(//input[@id='male'])
	  driver.findElement(By.xpath("(//input[@id='male'])")).click();
	  boolean isSel = driver.findElement(By.xpath("(//input[@id='female'])")).isSelected();
	  if(isSel) {
		  driver.findElement(By.xpath("(//input[@id='female'])")).click();
	  }
  }
}
