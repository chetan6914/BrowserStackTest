package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class flipkart extends BasePage {
	
	By searchbox = By.xpath("//input[@title='Search for products, brands and more']");
	By searchIcon = By.xpath("//button[@class='L0Z3Pu']");
	By Mobiles = By.xpath("(//a[text()='Mobiles'])[1]");
	By FAssured = By.xpath("//section/div/label/div[1]");
	By Brand = By.xpath("//div[text()='Brand']/ancestor::section//label//div[1]");
	By HighToLow = By.xpath("//div[text()='Price -- High to Low']");
	
	
	WebDriver driver;
	
	@Given("^I navigate to \"([^\"]*)\" from \"([^\"]*)\" browser$")
	public void i_navigate_to_from_browser(String url, String browserName) throws Throwable {

		System.out.println("Test");
		driver = getBrowser(browserName);
		driver.get(BasePage.fetchValue(url).toString());
		driver.manage().window().maximize();
		
	}
	
	@When("^I search for the product \"([^\"]*)\"$")
	public void i_search_for_the_product(String toSearch) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(searchbox)).sendKeys(toSearch);
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
		
	}
	
	@And("^I click on filters$")
	public void i_click_on_filters() throws Throwable {
		clickOn(Mobiles);
		clickOn(FAssured);
		javaScriptClickOn(Brand);		
		clickOn(HighToLow);
	}
	
	
	@Then("^I export all links in list$")
	public void i_export_all_links_in_list() throws Throwable {
		
	    
		List <WebElement> listOfAllLinks = driver.findElements(By.xpath("(//div[@class='E2-pcE _1q8tSL'])[2]/div//a"));
		
//		for (WebElement l : listOfAllLinks)
//		{
//			System.out.println(l.getAttribute("href").toString());
//		}
		
		for (int i = 1; i<listOfAllLinks.size(); i++)
		{
			
			System.out.println(listOfAllLinks.get(i).getAttribute("href").toString());
		}
		
//		driver.close();
	}
	
	

	   public void clickOn(By locator) {
			WebDriverWait wait = new WebDriverWait(driver, 5);


	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	        } catch (StaleElementReferenceException e) {
	            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	        }
	    }
	   
	   public void javaScriptClickOn(By locator) {

			WebDriverWait wait = new WebDriverWait(driver, 5);
	          WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	    }
}
