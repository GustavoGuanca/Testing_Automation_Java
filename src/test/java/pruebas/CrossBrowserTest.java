package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {
	WebDriver driver;
	String url="http://automationpractice.pl/index.php";
	String driverPath="..\\Edu_it\\Drivers\\chromedriver.exe";
	String driverPathF="..\\Edu_it\\Drivers\\geckodriver.exe";

	@BeforeMethod
    @Parameters("navegador")
	public void setUp(String navegador) {	
		if (navegador.equalsIgnoreCase("chrome")) {

		   System.setProperty("webdriver.chrome.driver",driverPath);
	        ChromeOptions options=new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
		    driver= new ChromeDriver(options);
		
		}
		else {
			
			System.setProperty("webdriver.gecko.driver", driverPathF);
	    	driver=new FirefoxDriver();
			
		}	
		
		driver.get(url);
		driver.manage().window().maximize();
	
	 }
	@Test
	public void buscarPalabra() {
		WebElement txtBuscar=driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscar.clear();
		txtBuscar.sendKeys("Blouse");
		txtBuscar.sendKeys(Keys.ENTER);
		
	
	}
	
	@AfterMethod
	public void cierraNavegador() {
		
		driver.quit();
		

	}
}

