package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends  BasePage {
	
	//private WebDriver driver;
	private final By userList_Grid = By.id("users-user-list-grid");
	
	public UsersPage(WebDriver driver) {
		super(driver);
	}
	
	//Verify if the user list grid is present
	public boolean verifyIfUserListGridIsDisplayed() {
		//System.out.println("User list grid is displayed: " + userListDisplayed);
		return isElementDisplayed(userList_Grid);
	}
}