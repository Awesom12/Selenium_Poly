package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utility.Screenshot;

import java.io.IOException;

public class BaseTests {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	private static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		ConfigReader config = new ConfigReader();
		
		//location of chrome executable file
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		
//		chromeOptions.addArguments("--disable-gpu");
//		chromeOptions.addArguments("--disable-extensions");

	//	chromeOptions.setExperimentalOption("useAutomationExtension", false);
	//	chromeOptions.addArguments("--proxy-server=direct://");
	//	chromeOptions.addArguments("--proxy-bypass-list=*");

//		chromeOptions.addArguments("--no-sandbox");
//		chromeOptions.addArguments("--disable-dev-shm-usage");

//		chromeOptions.addArguments("--start-maximized");
		//chromeOptions.addArguments("window-size=1024,728");
		chromeOptions.addArguments("headless");
		chromeOptions.addArguments("ignore-certificate-errors"); //without this line of code,
		// the browser always opened a blank page
	
		//chromeOptions.addArguments("--incognito");

	//Instantiate the Chrome driver - a new instance of chrome driver is created
		driver = new ChromeDriver(chromeOptions);
		//driver = new ChromeDriver();
		Reporter.log("Browser launched", true);
		//launch the browser and navigate to the DMA
		
		//maximize the screen
		driver.manage().window().maximize();
		
		//Navigate to the base URL of DMA
		driver.get(config.getBaseURL());
		Reporter.log("Navigating to the Base url of DMA", true);
	}
	
	@BeforeTest
	public void setExtentReports() {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("C://DMA_TestAutomation//Selenium_UIAutomation//test-output//ExtentReport.html");
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Selenium UI Automation");
		htmlReporter.config().setReportName("UI Smoke Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//Environment details
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Windows 10");
	}

/*
		@AfterTest
		public  void flushExtentReports(){
			extent.flush();
		}
*/
	
	
	@AfterMethod
	public void generateExtentReportWithLogs(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + " Test Case is FAILED");
			//log the error/exception in the report
			test.log(Status.FAIL, result.getThrowable() + " Test Case's error/exception ");
			//attach the screenshot in the report
			String screenshotPath = Screenshot.captureScreenshot(driver, result.getName());
			System.out.println(screenshotPath);
			try {
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException e) {
				test.fail("Cannot attach the screenshot");
			}
		} else if (ITestResult.SKIP == result.getStatus()) {
			test.log(Status.SKIP, result.getName() + " Test Case is SKIPPED");
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " Test Case is PASSED");
		}
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//Close all the browser windows open
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
