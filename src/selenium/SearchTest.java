package selenium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class SearchTest {
	WebDriver driver;
	@BeforeClass
	public void testSetup()
	{
	
		System.setProperty("webdriver.gecko.driver", "E:\\firefoxDriver\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
		driver=new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	}

	@BeforeMethod
	public void openBrowser()
	{
	String URL="http://automationpractice.com/index.php";
	driver.get(URL);
	driver.manage().window().maximize();
	}
	@Test(description = "This method tests the search functionality")
	public void productSearch() throws InterruptedException {

		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("sherl@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Sherley@#97");
		driver.findElement(By.id("SubmitLogin")).click();

		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		Thread.sleep(2000);
		WebElement womenTab = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a"));
		Thread.sleep(2000);
		WebElement TshirtTab = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a"));
		actions.moveToElement(womenTab).moveToElement(TshirtTab).click().perform();
		Thread.sleep(2000);

		String ProductName = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
		System.out.println(ProductName);
		driver.findElement(By.id("search_query_top")).sendKeys(ProductName);
		driver.findElement(By.name("submit_search")).click();

		String SearchResultProductname = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();

		if (ProductName.equalsIgnoreCase(SearchResultProductname)) {
			System.out.println("Search Results Matched; Test Case Passed");
		} else {
			System.out.println("Search Results Not Matched; Test Case Failed");
		}

		driver.close();
		
	}

}
	


