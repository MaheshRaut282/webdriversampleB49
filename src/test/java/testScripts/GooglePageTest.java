package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class GooglePageTest {
  /**
 * 
 */
@Test
  public void seleniumSearch() {
//	ChromeOptions options = new ChromeOptions();
//	options.setBrowserVersion("120");
	WebDriver driver = new ChromeDriver();
//	WebDriver driver = new EdgeDriver();
	//EdgeOptions options = new EdgeChromeOptions();
	//options.setBrowserVersion("120");
	
	//WebDriver driver = new EdgeDriver(options);
	/*
	  driver.get("https://www.google.co.in/");
	WebElement searchBox =  driver.findElement(By.id("APjFqb"));
	searchBox.sendKeys("Iron Man");
	searchBox.sendKeys(Keys.ENTER);
	//searchBox.click();
	*/
	driver.get("https://the-internet.herokuapp.com/login");
	driver.manage().window().maximize();
	//WebElement name = driver.findElement(By.id("username"));
	//WebElement name = driver.findElement(By.xpath("//input[@name='username' and @id='username']"));
	WebElement name = driver.findElement(By.cssSelector("#username"));
	name.sendKeys("tomsmith");
	WebElement pwd = driver.findElement(By.id("password"));
	pwd.sendKeys("SuperSecretPassword!");
	//WebElement btnLogin = driver.findElement(By.className("radius"));
	WebElement btnLogin = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
	//WebElement btnLogin = driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in"));
	//*[@id="login"]/button/i
	//fa fa-2x fa-sign-in
	//WebElement btnLogin = driver.findElement(By.tagName("button"));
	btnLogin.click();
	
//	driver.navigate().back();
//	System.out.println(driver.getTitle());
//	System.out.println(driver.getCurrentUrl());
//	driver.navigate().forward();
//	System.out.println(driver.getCurrentUrl());
	driver.findElement(By.linkText("Elemental Selenium")).click();
	//driver.findElement(By.partialLinkText("Elemental")).click();
  }
}
