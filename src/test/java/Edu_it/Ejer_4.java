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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejer_4 {

	/************************************************
	 * 												*
	 *  		Variables de entorno 				*
	 *  											*
	 ************************************************/

	String WEBDRIVER 		= "webdriver.chrome.driver";
	String PATHDRIVER 		= "..\\Edu_it\\Drivers\\chromedriver.exe";
	WebDriver driver;
	String URL 				= "http://www.automationpractice.pl/index.php";
	String FIRSTNAME 		= "Admin";
	String LASTANAME		= "Automation";
	String PASSWORD 		= "admin123";
	String MESSAGESUCCESS	= "Your account has been created.";

	@Before
	public void initBrowser () 
	{
		System.setProperty(WEBDRIVER,PATHDRIVER);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@Test
	public void sendForm() {

		/************************************************
		 * 												*
		 *  				Selectors 					*
		 *  											*
		 ************************************************/

		WebElement buttonLogin 			= driver.findElement(By.cssSelector("#header .login"));
		buttonLogin.click();
		WebElement inputEmail 			= driver.findElement(By.id("email_create"));
		WebElement buttonCreate			= driver.findElement(By.id("SubmitCreate"));
		inputEmail.sendKeys("correopersonal" + Math.random()+"@correo.com");
		buttonCreate.click();

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		WebElement radioMrs	= wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2"))); 

		WebElement inputFirstName 		= driver.findElement(By.id("customer_firstname"));
		WebElement inputLastName		= driver.findElement(By.id("customer_lastname"));
		//WebElement inputPassword		= driver.findElement(By.id("passwd"));
		//WebElement comboDays			= driver.findElement(By.id("days"));
		Select comboMonths			    =new Select(driver.findElement(By.id("months")));
		//WebElement comboYears			= driver.findElement(By.id("years"));
		//WebElement checkboxNewsletter	= driver.findElement(By.id("newsletter"));
		WebElement buttonSubmitAccount	= driver.findElement(By.id("submitAccount"));

		radioMrs.click();
		inputFirstName.sendKeys(FIRSTNAME);   
		inputLastName.sendKeys(LASTANAME);
		//inputPassword.sendKeys(PASSWORD);
		//comboDays.sendKeys("20");
		comboMonths.selectByIndex(4);
		//comboMonths.sendKeys("January");
		//comboYears.sendKeys("2020");
		//checkboxNewsletter.click();
		buttonSubmitAccount.click();

	}

	@After
	public void ending() {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebElement titleSucces	= driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		//String messageSucces = titleSucces.getText();
		//messageSucces.equals(MESSAGESUCCESS);
		//driver.close();
	}

}
