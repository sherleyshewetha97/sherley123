package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class SignUpTest {
	
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

	@Test(description="This method tests the sign up functionality")
	public void signUp()
	{
	driver.findElement(By.linkText("Sign in")).click();
	  driver.findElement(By.id("email_create")).sendKeys("huyoiuolklpppppp@gmail.com");
	driver.findElement(By.id("SubmitCreate")).click();


	  driver.findElements(By.xpath("//input[@name='id_gender']")).get(1).click();
	  driver.findElement(By.name("customer_firstname")).sendKeys("Sherley");
	  driver.findElement(By.name("customer_lastname")).sendKeys("Shewetha");
	driver.findElement(By.id("passwd")).sendKeys("Sherley@#97");
		
	driver.findElement(By.id("firstname")).sendKeys("Sherley");
	driver.findElement(By.id("lastname")).sendKeys("Shewetha");
	driver.findElement(By.id("company")).sendKeys("BNP Paribas");
	driver.findElement(By.id("address1")).sendKeys("38/81, Maddox Street");
	driver.findElement(By.id("city")).sendKeys("abc");
				
		WebElement statedropdown =driver.findElement(By.name("id_state"));
		Select selectState =new Select(statedropdown);
		selectState.selectByValue("4");

		driver.findElement(By.name("postcode")).sendKeys("12345");
		
		WebElement countrydropDown=driver.findElement(By.name("id_country"));
		Select selectCountry=new Select(countrydropDown);
		selectCountry.selectByVisibleText("United States");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office@gmail.com");
		driver.findElement(By.name("submitAccount")).click();
		  String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

		
		  if(userText.contains("Sherley")) {
		System.out.println("User Verified,Test case Passed");
		  }
		  else {
		System.out.println("User Verification Failed,Test case Failed");
		  }
		  driver.close();
		
	}
	

	}
