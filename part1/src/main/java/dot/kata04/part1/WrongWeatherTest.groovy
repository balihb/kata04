package dot.kata04.part1

import static org.junit.Assert.*;

import org.junit.Test

import dot.kata04.common.AllLinesSkipped

class WrongWeatherTest extends Weather {

	public WrongWeatherTest() {
		super(new File(System.getProperty("wrong.weather.file.name")))
	}
	
	@Test(expected=AllLinesSkipped.class)
	public void testProcess() {
		process()
	}

}
