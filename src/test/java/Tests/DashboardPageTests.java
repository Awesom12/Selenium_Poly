package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.UsersPage;

import static org.testng.Assert.assertTrue;

public class DashboardPageTests extends BaseTests {
	
	@Test(priority = 1,description = "This test verifies if User List Grid is displayed on the users page",
			groups = {"dashboard"}, dependsOnGroups = {"login"})
	public void testNavBarFunctionality() {
		
		test = extent.createTest("testNavBarFunctionality");
		//create an object of dashboard Page
		DashboardPage dashboardPage = new DashboardPage(getDriver());
		Reporter.log("Dashboard Page is displayed",true);
		test.info("Dashboard Page is displayed");
		
		//Click on the dropdown button(caret) next to User Menu on the navigation bar
		Reporter.log("User Menu is displayed on the navigation bar",true);
		test.info("User Menu is displayed on the navigation bar");
		dashboardPage.clickUserMenuDropdown();
		Reporter.log("Navigating to the users page...",true);
		test.info("Navigating to the users page...");
		
		//click on 'Users' option from the dropdown list
		UsersPage usersPage = dashboardPage.clickUsersDropdownItem();
		Reporter.log("Users Page is displayed",true);
		test.info("Users Page is displayed");
		
		// verify if the User list grid is displayed
		assertTrue(usersPage.verifyIfUserListGridIsDisplayed(), "User List Grid is not displayed");
		Reporter.log("User List grid is displayed on the Users Page",true);
		test.info("User List grid is displayed on the Users Page");
	}
	
	@Test(priority = 2, description = "This test verifies if the user can logout successfully and the login panel gets displayed after logging out",
			groups = {"logout"}, dependsOnGroups = {"login"})
	public void testLogoutFunctionality() {
		test = extent.createTest("testLogoutFunctionality");
		//create an object of dashboard Page
		DashboardPage dashboardPage = new DashboardPage(getDriver());
		//click on the logged in user on the navigation bar
		dashboardPage.clickUserOnNavBar();
		
		//click on sign out option
		LoginPage loginPage = dashboardPage.logout();
		
		//verify if the login page gets displayed
		assertTrue(loginPage.waitUntilLoginPanelIsDisplayed(), "LoginPage is not displayed");
		test.info("User is successfully logged out");
		}
}
