package Edu_it;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Laboratorio1 {
	@Test
	public void lab1_Test() {
		System.out.println("Hola mundo de Automatización!");

	}
	@Test
	public void lab2_Test() {
		System.out.println("Este es otro test");

	}

	@Test
	public void lab1_e1() {
		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		driver.close();

	}


	@Test
	public void lab1_3()  {

		System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);;
		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		WebElement txtBuscador=driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("Blouse");
		txtBuscador.sendKeys(Keys.ENTER);
		driver.close();

	}


}
