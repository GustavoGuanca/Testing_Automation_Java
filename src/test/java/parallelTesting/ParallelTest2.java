package parallelTesting;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class ParallelTest2 {
	
	WebDriver driver;
	@Test
	public void LoginTest() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("remote-allow-origins=*");
	driver= new ChromeDriver(options);	
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	driver.manage().window().maximize();

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	WebElement txtUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); 

	txtUsername.sendKeys("Admin");

	WebElement txtPassword = driver.findElement(By.name("password"));
	txtPassword.sendKeys("admin123");

	
	WebElement btnLogin=driver.findElement(By.xpath("//button[@type='submit']"));        
	btnLogin.click();
   
	Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	Thread.sleep(5000);
	
	driver.close();
	

	}
	
	
}
