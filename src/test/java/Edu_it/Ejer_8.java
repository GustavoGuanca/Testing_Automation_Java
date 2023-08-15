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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejer_8 {
	String txt_Url="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	WebDriver driver;

	@Before
	public void lab2_Septup() {
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);; 
		driver.get(txt_Url);
		driver.manage().window().maximize();

	}
	@Test
	public void lab3_test1() {
		WebElement txt_Email=driver.findElement(By.id("email_create"));
		txt_Email.sendKeys("micorreo"+ Math.random()+"@correo.com");
		WebElement btn_Create=driver.findElement(By.id("SubmitCreate"));
		btn_Create.click();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement chk_Gender= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
		chk_Gender.click();

		WebElement txt_Firstname=driver.findElement(By.id("customer_firstname"));
		WebElement txt_Lastname=driver.findElement(By.id("customer_lastname"));
		WebElement txt_Password=driver.findElement(By.id("passwd"));

		txt_Firstname.sendKeys("kelly");
		txt_Lastname.sendKeys("williams");
		txt_Password.sendKeys("34344");

		Select drp_days=new Select(driver.findElement(By.id("days")));
		Select drp_months=new Select(driver.findElement(By.id("months")));
		Select drp_years=new Select(driver.findElement(By.id("years")));

		drp_days.selectByValue("28");
		drp_months.selectByValue("1");
		drp_years.selectByValue("2000");

		WebElement bnt_submit= driver.findElement(By.id("submitAccount"));
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
