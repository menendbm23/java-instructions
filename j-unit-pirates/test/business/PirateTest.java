package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class PirateTest {

	@Test
	public void PirateCreateTest() {
		Pirate pete = new Pirate("Pegleg Pete",3);
		assertEquals(3, pete.getLimbsRemaining());
		assertEquals("Pegleg Pete", pete.getName());
		
	}

	@Test
	public void octoPirateCreateTest() {
		Pirate pete = new Pirate("OctoPirate",8);
		assertEquals(8, pete.getLimbsRemaining());
	}
	
	@Test(timeout=1000)
	public void timeoutTest() {
		while (true) {
			// no nothing 
		}
	}
}
