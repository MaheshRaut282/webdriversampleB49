package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UploadFileTest {
  @Test
  public void uploadFile() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	  WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
	  String strPath = System.getProperty("user.dir") + "//screenshots//" + "1743068201627.png";
	  addFile.sendKeys(strPath);
	  
	  driver.findElement(By.xpath("//span[text()='Start upload']")).click();
	  
  }
}
