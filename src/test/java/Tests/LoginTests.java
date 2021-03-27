package Tests;

import config.ConfigReader;
import org.testng.Reporter;
import pages.BrowserCA_PrivacyErrorPage;
import pages.DashboardPage;
import pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
	
	@Test(priority = 1,groups = {"pError"},description = "This test case if successful takes us to the login Page")
	public void testPrivacyErrorPageNavigatesToLogin() throws InterruptedException {
		test = extent.createTest("testPrivacyErrorPageNavigatesToLogin");
		
		BrowserCA_PrivacyErrorPage pErrorPage = new BrowserCA_PrivacyErrorPage(getDriver());
		Reporter.log("Cert Privacy Error Page is displayed",true);
		test.info("Cert Privacy Error Page is displayed");
		
		//click on the 'Advanced' button on the Cert Authority Privacy error page
//		pErrorPage.clickAdvanced_Btn();
//
//		//click on proceed link
//		LoginPage loginPage = pErrorPage.clickProceed_link();
//		Reporter.log("Navigating to the Login Page",true);
//		test.info("Navigating to the Login Page");
		
		LoginPage loginPage = new LoginPage(getDriver());
				//verify if the login page gets displayed
		assertTrue(loginPage.waitUntilLoginPanelIsDisplayed(), "LoginPage is not displayed");
		Reporter.log("Login Page is displayed",true);
		test.info("Login Page is displayed");
	}
	
	@Test(priority = 2, dependsOnGroups = {"pError"}, groups = {"login"}, description = "This test case if successful takes us to the dashboard Page")
	public void testSuccessfulLogin() {
		
		test = extent.createTest("testSuccessfulLogin");
		
		//create an object of ConfigReader to get the Username and Password values
		ConfigReader config = new ConfigReader();
		
		//create an object of Login Page
		LoginPage loginPage = new LoginPage(getDriver());
		Reporter.log("On the Login Page",true);
		test.info("On the Login Page");
		
		//input the username - get the value of UN from config.properties file
		loginPage.setUsername(config.getUN());
		Reporter.log("Username is entered",true);
		
		//input the password
		loginPage.setPassword(config.getPW());
		Reporter.log("Entered the password",true);
		test.info("Username and Password are entered");

		//click login button
		DashboardPage dashboardPage = loginPage.clickLoginButton();
		Reporter.log("Logging in...",true);
		test.info("Logging in...");

		//Verify if DMA dashboard page is displayed
		assertEquals(dashboardPage.getDashboardPageTitle(),"RealPresence DMA - Dashboard","Dashboard Page is not displayed");
		Reporter.log("User is successfully logged in to DMA",true);
		test.info("User is successfully logged in");
	}

}
