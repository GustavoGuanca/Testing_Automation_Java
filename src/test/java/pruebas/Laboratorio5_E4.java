package pruebas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5_E4 {
	
	WebDriver driver;
	String driverPath = "..\\Edu_it\\Drivers\\chromedriver.exe";
	String urlTest ="http://demo.guru99.com/test/table.html";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);	
		driver.manage().window().maximize();
    	driver.get(urlTest);
	}
	
	@Test
	public void verCelda() {
		
	 WebElement celda=driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
	 Assert.assertEquals(celda.getText(),"8");
	

	}
	
	@AfterSuite
	public void  cerrar() {
		  driver.close();

	}

}
