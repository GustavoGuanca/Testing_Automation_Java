package pruebas;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Laboratorio5_E3 {
	WebDriver driver;
	String driverPath = "..\\Edu_it\\Drivers\\chromedriver.exe";
	String urlTest ="https://demoqa.com/alerts";

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
	public void verAlert() {
		//driver.findElement(By.id("alertButton")).click();
		
		WebElement buttonAlert=driver.findElement(By.id("alertButton"));
		buttonAlert.click();
		
		Alert alert=driver.switchTo().alert();
		
		alert.accept();

	}
	
	@AfterSuite
	public void cerrar() {
	
     driver.close();
	}
}
