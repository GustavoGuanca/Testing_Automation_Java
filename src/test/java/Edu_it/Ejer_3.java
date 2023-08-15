package Edu_it;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejer_3 {
	WebDriver driver;

	@Before
	public void setUp() {
		System.out.println("***********************");
		System.out.println("Init SetUp");
		System.out.println("***********************");	

		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void lab2_e1() {

		//WebElement login = driver.findElement(By.className("login"));
		//login.click();

		WebElement txt_email = driver.findElement(By.id("email_create"));
		txt_email.sendKeys("EducacionIT" + Math.random() + "@educacion.com");

		//String txt_email_value = txt_email.getAttribute("value");

		WebElement btn_acount = driver.findElement(By.name("SubmitCreate"));
		btn_acount.click();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		WebElement chk_gender= wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1"))); 
		// WebElement chk_gender = driver.findElement(By.cssSelector("body.authentication.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 form.std.box div.account_creation div.clearfix:nth-child(2) div.radio-inline:nth-child(3) > label.top"));
		chk_gender.click();

		WebElement txt_firstName = driver.findElement(By.id("customer_firstname"));
		txt_firstName.sendKeys("Juan");

		WebElement txt_lastName = driver.findElement(By.id("customer_lastname"));
		txt_lastName.sendKeys("Perez");

		//WebElement txt_passwd = driver.findElement(By.id("passwd"));
		//txt_passwd.sendKeys("123456789");

		//WebElement cbo_dia = driver.findElement(By.id("days"));
		//cbo_dia.sendKeys("15");

		//WebElement cbo_mes = driver.findElement(By.id("months"));
		//cbo_mes.sendKeys("may");

		Select months= new Select(driver.findElement(By.id("months")));

		months.selectByValue("4");


		//WebElement cbo_año = driver.findElement(By.id("years"));
		//cbo_año.sendKeys("1993");

		//WebElement chk_newsletter = driver.findElement(By.id("uniform-newsletter"));
		//chk_newsletter.click();

		//WebElement btn_submitAccount = driver.findElement(By.name("submitAccount"));
		//btn_submitAccount.click();
		WebElement btn_submitAccount = driver.findElement(By.xpath("//*[text()='Register']"));
		btn_submitAccount.click();  
		//WebElement btn_informationPersonal = driver.findElement(By.className("icon-user"));
		//btn_informationPersonal.click();

		//String txt_user = driver.findElement(By.id("email")).getAttribute("value");


		//if (txt_user.equals(txt_email_value)) {
		//  System.out.println("Usuario verificado. Test Ok");
		//} else {
		//  System.out.println("Usuario no verificado. El test falló");
		// }
	}

	@After
	public void tearDown() {

		System.out.print("***********************");

		System.out.print("Fin test");

		driver.close();

		System.out.print("***********************");

	}


}

