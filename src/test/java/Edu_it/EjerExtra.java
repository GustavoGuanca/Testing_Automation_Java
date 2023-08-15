package Edu_it;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class EjerExtra {

	@Test @Ignore
	public void test() {

		int a=2;
		int b=3;
		int expectedResults=5;
		int sumaNumeros=a + b;
		Assert.assertEquals(expectedResults,sumaNumeros);

	}

	@Test 
	public void testOpInvalid() {
		int divNumeros=0;
		try {
			int a=2;
			int b=0;
			divNumeros=a/b ;
			System.out.print(divNumeros);

		}
		catch(Exception ex) {
			System.out.print("Se ha producido un error");
		}

	}


}
