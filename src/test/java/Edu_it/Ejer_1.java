package Edu_it;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejer_1 {

	@Test
	public void OpenHRM_LoginTest() {

		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		WebElement txtUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); 
		//WebElement txtUsername = driver.findElement(By.name("username"));
		txtUsername.sendKeys("Admin");

		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("admin123");

		//WebElement btnLogin = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

		WebElement btnLogin=driver.findElement(By.xpath("//button[@type='submit']"));        
		btnLogin.click();

		driver.close();


	}

}
