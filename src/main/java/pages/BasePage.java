package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions action;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		this.action = new Actions(driver);
	}
	
	public void waitForPageLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		wait.until(pageLoadCondition);
	}
	
	protected void waitForElementToAppear(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected void waitForElementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	protected void waitForElementWithTextToDisappear(By locator){
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, "Logging In"));
	}
	
	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	protected WebElement element(By locator) {
		return driver.findElement(locator);
	}
	
	protected void type(By locator, String s) {
		element(locator).sendKeys(s);
	}
	
	protected boolean isElementDisplayed(By locator) {
		return element(locator).isDisplayed();
	}
	
}
