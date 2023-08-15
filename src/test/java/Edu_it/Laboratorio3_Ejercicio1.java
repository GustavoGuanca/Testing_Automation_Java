package Edu_it;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Laboratorio3_Ejercicio1 {

	WebDriver driver;
	String url="http://automationpractice.pl/index.php?controller=authentication#account-creation";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);	


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


		WebElement txtEmail=driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo"+ Math.random()+"@correo.com");


		WebElement btnCreate=driver.findElement(By.xpath("//*[@id='SubmitCreate']"));


		btnCreate.click();

		//g)
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));

		driver.findElement(By.id("id_gender1")).click();

		//c)
		driver.findElement(By.name("customer_firstname")).sendKeys("Juan Torres"); 

		//d)
		driver.findElement(By.name("passwd")).sendKeys("123456"); 

		//e)

		Select months= new Select(driver.findElement(By.id("months")));

		months.selectByValue("4");
		//h)
		driver.findElement(By.xpath("//*[text()='Register']")).click();


		Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication", driver.getCurrentUrl());





	}

	@Test(enabled=false)
	public void pruebaTest() {
		assertTrue(true);
	}

	@AfterMethod
	public void capturaPantalla () throws Exception {
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\Edu_it\\Evidencias\\pantalla.png"));
	}


	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de Prueba");


	}
	@AfterTest
	public void cierraNavegador() {
		driver.close();

	}
	@AfterSuite
	public void finSuite () {

		System.out.println("Fin de Suite");

	}


}
