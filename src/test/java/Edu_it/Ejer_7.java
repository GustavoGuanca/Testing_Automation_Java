package Edu_it;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejer_7 {
	@Test
    public void lab2_E1Test() {

        System.setProperty("webdriver.chrome.driver", "..\\Edu_it\\Drivers\\chromedriver.exe"); //Indicar donde se encuentra el Driver
        ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation");
        driver.manage().window().maximize();
        WebElement txt_Email = driver.findElement(By.id("email_create"));
        txt_Email.sendKeys("micorreo" + Math.random()+ "@correo.com");
        WebElement btn_Create = driver.findElement(By.id("SubmitCreate"));
        btn_Create.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement btn_Title = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        btn_Title.click();
        WebElement txt_FirstName = driver.findElement(By.id("customer_firstname"));
        txt_FirstName.sendKeys("Jose");
        WebElement txt_LastName = driver.findElement(By.id("customer_lastname"));
        txt_LastName.sendKeys("Gomez");
        WebElement txt_Password = driver.findElement(By.id("passwd"));
        txt_Password.sendKeys("Password");
        Select cbo_Dia = new Select(driver.findElement(By.id("days")));
        //WebElement cbo_Dia = driver.findElement(By.id("days"));
        cbo_Dia.selectByValue("3");        
        WebElement cbo_Mes = driver.findElement(By.id("months"));
        cbo_Mes.sendKeys("july");
        WebElement cbo_Año = driver.findElement(By.id("years"));
        cbo_Año.sendKeys("1991");
        WebElement btn_NewsLetter = driver.findElement(By.id("newsletter"));
        btn_NewsLetter.click();
        WebElement btn_Register = driver.findElement(By.xpath("//*[text()='Register']"));
        //WebElement btn_Register = driver.findElement(By.id("submitAccount"));
        btn_Register.click();
        driver.close();
	}
}
