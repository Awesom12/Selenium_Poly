package pages;

import org.openqa.selenium.*;

public class LoginPage extends BasePage {

	private final By login_Panel = By.className("login-panel");
	private final By username_Field = By.id("login-username-input");
	private final By password_Field = By.id("login-password-input");
	private final By login_Btn = By.id("login-submit-button");
	/*private final By navigationbar_Header = By.id("navbar-site-header-div");
	private final By loggedIn_BtnText = By.xpath("//span[text()='Logged In']");*/
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean waitUntilLoginPanelIsDisplayed() {
		waitForPageLoad();
		waitForElementToAppear(login_Panel);
		boolean loginPanelDisplayed = isElementDisplayed(login_Panel);
		System.out.println("Login Page Url is: " + driver.getCurrentUrl());
		return loginPanelDisplayed;
	}
	
	public void setUsername(String username) {
		click(username_Field);
		//driver.findElement(username_Field).sendKeys(username);
		type(username_Field,username);
	}
	//set password
	public void setPassword(String password) {
		click(password_Field);
		type(password_Field,password);
	}
	
	public DashboardPage clickLoginButton() {
		waitForElementToAppear(login_Btn);
		waitForElementToBeClickable(login_Btn);
		click(login_Btn);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitForElementWithTextToDisappear(login_Btn);
		try {
			if (element(login_Btn).isDisplayed()) {
				driver.navigate().refresh();
			}
		}catch(NoSuchElementException | StaleElementReferenceException e) {
			e.printStackTrace();
		}
		return new DashboardPage(driver);
	}
}