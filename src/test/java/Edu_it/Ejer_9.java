package Edu_it;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejer_9 {

	WebDriver driver;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@Before
	public void OpenHRM_Before() {
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);	
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test @Ignore
	public void OpenHRM_LoginTest() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		WebElement txtUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); 
		txtUsername.sendKeys("Admin");

		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("admin123");


		WebElement btnLogin=driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();
	}

	@Test 
	public void OpenHRM_AltaUsuario() {

		//Login

		WebDriverWait wait_txt = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement txtUsername = wait_txt.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); 
		txtUsername.sendKeys("Admin");

		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("admin123");

		WebElement btnLogin=driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();

		//Opcion de menu
		WebDriverWait wait_btn = new WebDriverWait(driver,Duration.ofSeconds(10));
		//WebElement btnAdmin = wait_btn.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']")));
		WebElement btnAdmin = wait_btn.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin")));
		btnAdmin.click();

		WebDriverWait wait_btn_arr = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement btnArr = wait_btn_arr.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and @role='none']")));
		btnArr.click();

		WebDriverWait wait_txt_user = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement txtEmployeeUsername = wait_txt_user.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='oxd-input oxd-input--active']")));
		//WebElement txtEmployeeUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-v-1f99f73c]")));

		txtEmployeeUsername.sendKeys("newuser");

	}



	@After
	public void OpenHRM_After() {
		//driver.close();
	}

}
