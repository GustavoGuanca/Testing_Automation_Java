package parallelTesting;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ParallelTest1 {
	WebDriver driver;
	@Test
	public void logoTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		WebElement logoWeb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-branding']"))); 

		Assert.assertTrue(logoWeb.isDisplayed());
	    Thread.sleep(5000);
	    driver.close();

	}
	
	@Test
	public void homepageTitle() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		Thread.sleep(5000);
		driver.close();

	}
	
}


