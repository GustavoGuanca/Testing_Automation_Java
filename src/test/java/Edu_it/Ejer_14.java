package Edu_it;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.WebDriver.manage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ejer_14 {
	
	WebDriver driver;
    String url="http://automationpractice.pl/index.php?controller=authentication#account-creation";
    String url_registrado="http://www.automationpractice.pl/index.php?controller=my-account";
    
    
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");	
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}
	
	@BeforeTest
    public void irUrl() {
			driver.get(url);

		
	}
	
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Test(priority=1 ,description="Test")
	public void registrarUsuario() {
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo" + Math.random() + "@correo.com");
				
		WebElement btnCreate = driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();	

		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitCreate")));
		WebElement boton_1 = driver.findElement(By.id("SubmitCreate"));
		boton_1.click();
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
		WebElement title = driver.findElement(By.id("id_gender2"));
		title.click();
		
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		WebElement firstname = driver.findElement(By.name("customer_firstname"));
		firstname.sendKeys("Mara");
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_lastname")));
		WebElement lastname = driver.findElement(By.id("customer_lastname"));
		lastname.sendKeys("Rivo");
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
		WebElement pass = driver.findElement(By.id("passwd"));
		pass.sendKeys("Clave123");
		
		Select day = new Select (driver.findElement(By.id("days")));
		day.selectByValue("1");

		Select months = new Select (driver.findElement(By.id("months")));
		months.selectByValue("1");

		Select years = new Select (driver.findElement(By.id("years")));
		years.selectByValue("1977");
				
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitAccount")));
		WebElement btn_register = driver.findElement(By.id("submitAccount"));
		btn_register.click();
		
							
		Assert.assertEquals(url_registrado, driver.getCurrentUrl());
		Assert.assertTrue(url_registrado.contentEquals(driver.getCurrentUrl()));
	}
	
	@Test(enabled=false)
	public void pruebaTest() {
	    assertTrue(true);
	}
	

	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de prueba");
	
      
	}
    @AfterTest
	/*public void cierraNavegador() {
    	driver.close();
	    }
	 
	*/
    
    @AfterSuite
	public void finSuite () {
    System.out.println("Fin de suite");

	}
	

}