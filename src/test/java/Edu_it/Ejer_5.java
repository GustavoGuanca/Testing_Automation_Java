package Edu_it;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class Ejer_5 {

	String txt_URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	WebDriver driver;

	@Before
	public void lab2_Setup() {
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
	    driver= new ChromeDriver(options);
		driver.get(txt_URL);
		driver.manage().window().maximize();
	}

	@Test
	public void lab2_Test1() {

		WebElement txt_Email  = driver.findElement(By.id("email_create"));
		WebElement bnt_Create = driver.findElement(By.id("SubmitCreate"));
		txt_Email.sendKeys("mi"+ (int) (Math.random()*1000) +"@correo.com");
		bnt_Create.click();

		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement chk_Gender = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		chk_Gender.click();

		WebElement txt_Firstname = driver.findElement(By.id("customer_firstname"));
		WebElement txt_Lastname = driver.findElement(By.id("customer_lastname"));
		WebElement txt_Password = driver.findElement(By.id("passwd"));

		txt_Firstname.sendKeys("Juan");
		txt_Lastname.sendKeys("Perez");
		txt_Password.sendKeys("12345");

		Select drp_days = new Select(driver.findElement(By.id("days")));
		Select drp_months = new Select(driver.findElement(By.id("months")));
		Select drp_years = new Select(driver.findElement(By.id("years")));

		drp_days.selectByValue("3");
		drp_months.selectByValue("4");
		drp_years.selectByValue("1955");

		WebElement bnt_submit = driver.findElement(By.id("submitAccount"));
		bnt_submit.click();

		String text_ACreated="Your account has been created.";
		WebElement txt_Class = driver.findElement(By.xpath("//p[contains(text(),'Your account has been created.')]"));
		//assertTrue( txt_Class.getText() == " Your account has been created. ");
		Assert.assertEquals(text_ACreated,txt_Class.getText());


	}


	@After
	public void tear_Down() {
		driver.close();
	}



}
