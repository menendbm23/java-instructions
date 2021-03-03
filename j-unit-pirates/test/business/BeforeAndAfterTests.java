package business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAndAfterTests {

	@Test
	public void testA() {
		System.out.println("testA");
	}
	
	@Test
	public void testB() {
		System.out.println("testB");
	}
	
	@Test
	public void testC() {
		System.out.println("testC");
	}

	@Before
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@After
	public void afterTest() {
		System.out.println("afterTest");
	}
	
	@BeforeClass
	public static void beforeClassTest() {
		System.out.println("beforeClassTest");
	}
	@AfterClass
	public static void afterClassTest() {
		System.out.println("afterClassTest");
	}
}
