package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

	
	private By navigationbar_Header = By.id("navbar-site-header-div");
	private By UserMenu_Drpdwn = By.xpath("//a[@id='user' and @ng-switch-when='dropdown']");
	private By Users_DrpdwnItem = By.xpath("//a[text() = 'Users']");
	private By loggedInUser = By.xpath("//a[@id='navbar-user-a' and @role='button']");
	private By logout = By.id("logout");
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	
	// Verify if the user navigation bar is displayed
	public String getDashboardPageTitle() {
		waitForElementToAppear(navigationbar_Header);
		//display on the console if the navigation bar is displayed
//		boolean navBarDisplayed = isElementDisplayed(navigationbar_Header);
//		if (!navBarDisplayed) {
//			driver.navigate().refresh();
//		} else {
//			System.out.println("User navigation bar is displayed: " + true);
//		}
		//Get the title of the page
		return driver.getTitle();
	}
	
	//click the User dropdown
	public void clickUserMenuDropdown() {
		waitForElementToAppear(UserMenu_Drpdwn);
		waitForElementToBeClickable(UserMenu_Drpdwn);
		/* boolean userDrpDwnDisplayed = isElementDisplayed(UserMenu_Drpdwn);
		System.out.println("User Menu dropdown is displayed: " + userDrpDwnDisplayed);*/
		driver.findElement(UserMenu_Drpdwn).click();
	}
	
	//click on Users dropdown item
	public UsersPage clickUsersDropdownItem() {
		click(Users_DrpdwnItem);
		return new UsersPage(driver);
	}
	
	//click the logged in 'user' on the navigation bar
	public void clickUserOnNavBar() {
		click(loggedInUser);
	}
	
	//logout from DMA
	public LoginPage logout() {
		click(logout);
		return new LoginPage(driver);
	}
}
