package Edu_it;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejer_2 {

	//VARIABLES GLOBALES
	WebDriver driver;
	String url= "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Before
	public void initChrome () 
	{
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();


	}


	@Test
	public void lab2_E1Test() 

	{
		WebElement txt_ValidateEmail= driver.findElement(By.id("email_create"));

		txt_ValidateEmail.sendKeys("micorreo"+ Math.random()+"@correo.com");
		WebElement btn_Create=driver.findElement(By.id("SubmitCreate"));
		btn_Create.click();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		WebElement rdb_Gender = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1"))); 
		rdb_Gender.click();
		System.out.println(rdb_Gender.isSelected());

		WebElement txt_Name= driver.findElement(By.id("customer_firstname"));
		txt_Name.sendKeys("Shanks");


	}

	@After
	public void ending() 
	{
		driver.close();
	}

}


