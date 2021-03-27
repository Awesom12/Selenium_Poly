package utility;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
//import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
	
	public static String captureScreenshot(WebDriver driver, String testCaseName) {
		String currentDate = new SimpleDateFormat("MMddyyyyhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = "C:/DMA_TestAutomation/Selenium_UIAutomation/screenshots/"+ testCaseName + currentDate +".png";
		//File Utils from apache commons
			//FileUtils.copyFile(src, new File("./Screenshots/" + screenshotName+ ".png"));
		
		//File Handler from Selenium
		try {
			FileHandler.copy(src, new File(destination));
		}catch (Exception e){
			e.printStackTrace();
		}
		return destination;
	}
}
