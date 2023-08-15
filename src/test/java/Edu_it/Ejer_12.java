package Edu_it;

import java.time.Duration;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Ejer_12 {

	WebDriver driver;
	@Test
	public void lab_e4() {		
		//Indicar donde se encuentra el Driver a utilizar
		System.setProperty ("webdriver.chrome.driver","..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);

		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		driver.manage ().window().maximize();

		//Identificar elementos--- sendKeys es un elemento --- txtSearch es el nombre del elemento
		WebElement txt_Email = driver.findElement(By.id("email_create"));
		txt_Email.sendKeys("micorreo" + Math.random()+ ("@correo.com"));
		WebElement btn_Create =driver.findElement(By.id("SubmitCreate"));
		btn_Create.click();

		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement rdb_RadioButton= mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender2')]")));
		//WebElement rdb_RadioButton= driver.findElement(By.id("id_gender2")); 
		rdb_RadioButton.click();
		System.out.println(rdb_RadioButton.isSelected());


		//Metodo-Texto
		WebElement txt_FirstName = driver.findElement (By.id("customer_firstname")); 
		txt_FirstName.sendKeys("Mateo");


		WebElement txt_LastName = driver.findElement (By.id("customer_lastname")); 
		txt_LastName.sendKeys("Acosta");

		WebElement txt_Password = driver.findElement (By.id("passwd")); 
		txt_Password.sendKeys("24685");

		//Metodo-Lista
		Select drp_days = new Select (driver.findElement(By.id("days")));
		drp_days.selectByValue("2");

		Select drp_months = new Select (driver.findElement(By.id("months")));
		drp_months.selectByValue("12");

		Select drp_years = new Select (driver.findElement(By.id("years")));
		drp_years.selectByValue("1983");

		//Metodo CheckBox
		WebElement chk_newsletter  = driver.findElement(By.id("newsletter")); 
		chk_newsletter.click();

		WebElement btn_Registro =driver.findElement(By.id("submitAccount"));
		btn_Registro.click();




	}

	@After
	public void tearDown () {
		//Cierra el navegador
		driver.close();
		//driver.quit(); --> Cierra todas las ventanas

	}
}



