package pruebas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.paginaLogin;



public class Laboratorio5_E1b {
	

	WebDriver driver;

	paginaLogin login;
	
	String driverPath="..\\Edu_it\\Drivers\\chromedriver.exe";
	String url="http://automationpractice.pl/index.php?controller=authentication&back=my-account";
	
	
    @BeforeSuite
	public void setUp(){
    	System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);	
    	driver.get(url);
    	
     }
    
    @AfterSuite
  	public void cierreNavegador(){
        driver.close();
       }

    @Test(dataProvider="Datos Login")
    public void irRegistroLogin(String email,String password) {
    	login= new paginaLogin(driver);
    	login.enterEmail(email,password);
    	Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
    	
     }
    
    @DataProvider(name="Datos Login")
    public Object[][] getData(){
    	
    	Object[][] data =new Object[3][2];
    	
    	data[0][0]="test1@gmail.com";data[0][1]="123";
    	data[1][0]="test2@gmail.com";data[1][1]="456";
    	data[2][0]="test3@gmail.com";data[2][1]="789";
    	
    	return data;
    }
    
    
     
 
}