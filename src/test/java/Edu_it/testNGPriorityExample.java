package Edu_it;
import org.testng.annotations.Test;

public class testNGPriorityExample {
	@Test(priority=1)
	public void registerAccount()
	{
		System.out.println("First register your account");
	}
	@Test(priority=3)
	public void sendEmail()
	{
		System.out.println("Send email after login");
	}
	@Test(priority=2)
	public void login()
	{
		System.out.println("Login to the account after registration");
	}

}
