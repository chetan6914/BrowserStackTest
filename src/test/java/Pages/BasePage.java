package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public WebDriver driver;
	
	 public static Object fetchValue(String key) throws IOException   {
	        FileInputStream file = new FileInputStream("src\\test\\resources\\ConfigFile\\apiconfig.properties");
	        //FileInputStream file = new FileInputStream("C:\\Users\\chetan.mali\\IdeaProjects\\Paytm_Test\\src\\test\\resources\\ConfigFile\\apiConfig");
	        Properties property = new Properties();
	        property.load(file);
	        return property.get(key).toString();

	    }
	 
	 public WebDriver getBrowser(String name)
	 {
		 if(name.equalsIgnoreCase("chrome"))
		 {
			 File file = new File("src/test/resources/Drivers/chromedriver.exe");
			 System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			 this.driver = new ChromeDriver();
		 }
		 else if(name.equalsIgnoreCase("firefox"))
		 {
			 File file = new File("src/test/resources/Drivers/geckodriver.exe");
			 System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			 this.driver = new FirefoxDriver();
		 }
		return driver;
	 }
	 
	  


}
;