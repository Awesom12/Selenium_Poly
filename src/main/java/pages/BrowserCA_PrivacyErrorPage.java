package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserCA_PrivacyErrorPage extends BasePage {
	
	private final By advanced_Btn = By.id("details-button");
	private final By proceed_Link = By.id("proceed-link");
	
	public BrowserCA_PrivacyErrorPage(WebDriver driver){
		super(driver);
	}
	
	public void clickAdvanced_Btn() {
			//throws InterruptedException {
		//Thread.sleep(120000);
		waitForElementToAppear(advanced_Btn);
		click(advanced_Btn);
		}
	
	public LoginPage clickProceed_link(){
		click(proceed_Link);
		return new LoginPage(driver);
	}

}
