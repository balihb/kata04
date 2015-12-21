package dot.kata04.part2

import static org.junit.Assert.*;

import org.junit.Test;

import dot.kata04.common.AllLinesSkipped

class WrongFootballTest extends Football {

	public WrongFootballTest() {
		super(new File(System.getProperty("wrong.football.file.name")))
	}
	
	@Test(expected=AllLinesSkipped.class)
	public void testProcess() {
		process()
	}
}
