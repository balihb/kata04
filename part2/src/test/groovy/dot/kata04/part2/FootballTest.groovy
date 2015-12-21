package dot.kata04.part2

import static org.junit.Assert.*;

import org.junit.Test;

class FootballTest extends Football {

	public FootballTest() {
		super(new File(System.getProperty("football.file.name")))
	}
	
	@Test
	public void testProcessLine() {
		
	}

		@Test
	public void testProcess() {
		 assertEquals("Aston_Villa wasn't returned", process(), "Aston_Villa")
	}

}
