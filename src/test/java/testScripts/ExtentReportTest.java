package testScripts;

import java.time.Duration;

import org.apache.commons.exec.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;

public class ExtentReportTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("teset-output/SparkReport1.html").viewConfigurer().viewOrder().as(new ViewName[] {
				ViewName.DASHBOARD,
				ViewName.TEST,
				ViewName.AUTHOR,
				ViewName.DEVICE,
				ViewName.LOG
		}).apply();
		extentReports.attachReporter(spark);
	}
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://danube-webshop.herokuapp.com/");
	}
	
	@Test
	  public void horrorSearch() {
		  extentTest = extentReports.createTest("Horror Search Test");
		  driver.findElement(By.xpath("//a[contains(text(), 'Horror')]")).click();
		  String strUrl = driver.getCurrentUrl();
		  Assert.assertTrue(strUrl.contains("horror"));
	  }

	  @Test(retryAnalyzer = RetryAnalyserImp.class)
	  public void storiesSearch() {
		  extentTest = extentReports.createTest("Novel & Stories Search Test");
		  driver.findElement(By.xpath("//a[contains(text(), 'Novel')]")).click();
		  String strUrl = driver.getCurrentUrl();
		  Assert.assertTrue(strUrl.contains("novel fail"));
		  //Assert.assertTrue(strUrl.contains("novel Stories"));
	  }
	  
	  @AfterMethod
	  public void teardown(ITestResult result) {
		  extentTest.assignAuthor("Bhaiyya Raut").assignCategory("Regression").assignDevice(System.getProperty("os.name")).assignDevice(System.getProperty("os.version"));
		  if(ITestResult.FAILURE == result.getStatus()) {
			  extentTest.log(Status.FAIL, result.getThrowable());
			  String path = Utility.getScreenshotPath(driver);
			  extentTest.addScreenCaptureFromPath(path);
		  }
	  }
	  
	  @AfterTest
	  public void finishExtent() {
		  extentReports.flush();
	  }
	
	 
	  
	  
  

  
}
