package Edu_it;


import org.junit.*;

public class LaboratorioExtra_1 {

	@Before
	public void setUp() {

		System.out.print("===========================");

		System.out.print("Se ejecuta antes cada test");

		System.out.print("===========================");

	}

	@Test
	public void Test_1() {
		System.out.print("===========================");

		System.out.print("Test 1");

		System.out.print("===========================");

	}
	@Test
	public void Test_2() {

		System.out.print("===========================");

		System.out.print("Test 2");

		System.out.print("===========================");

	}



	@After
	public void tearDown() {

		System.out.print("===========================");

		System.out.print("Se ejecuta al final cada test");

		System.out.print("===========================");

	}
}
