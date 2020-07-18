package selenium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
	
	WebDriver driver;
	@BeforeClass
	public void testSetup()
	{
	
		System.setProperty("webdriver.gecko.driver", "E:\\firefoxDriver\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
			driver=new FirefoxDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

	}

	@BeforeMethod
	public void openBrowser()
	{
	String URL="http://automationpractice.com/index.php";
	driver.get(URL);
	}
	@Test(description="This method tests the login functionality")
	public void login()
	{
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("sherl@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Sherley@#97");
		driver.findElement(By.id("SubmitLogin")).click();
		
		String actualUrl="http://automationpractice.com/index.php?controller=my-account";
        String expectedUrl= driver.getCurrentUrl();

        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
System.out.println("Login successful");
        }
        else
        {
System.out.println("Login  failed");
        }
driver.quit();
    }
	}

	
	
	
	
	
	