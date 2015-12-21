package dot.kata04.part1

import static org.junit.Assert.*

import org.junit.Before;
import org.junit.Test;

import dot.kata04.common.CanTParseNumber
import dot.kata04.common.AbstractProcessor.ProcessorHelperTuple

class WeatherTest extends Weather {

	public WeatherTest() {
		super(new File(System.getProperty("weather.file.name")))
	}

	@Test
	public void testProcessLineGreater() {
		def greater = ['greater', 40, 15] as String[]
		def less = new ProcessorHelperTuple('less', 5)
		assertEquals(
				"less wasn't returned",
				processLine(greater, less).name, 'less')
	}

	@Test
	public void testProcessLineLess() {
		def less = ['less', 20, 15] as String[]
		def greater = new ProcessorHelperTuple('greater', 40)
		assertEquals(
				"less wasn't returned",
				processLine(less, greater).name, 'less')
	}

	@Test
	public void testProcessLineEqual() {
		def eq1 = ['eq1', 20, 15] as String[]
		def eq2 = new ProcessorHelperTuple('eq2', 5)
		assertEquals(
				"eq2 wasn't returned",
				processLine(eq1, eq2).name, 'eq2')
	}

	@Test
	public void testProcessLineGreaterWrongOrder() {
		def less = ['less', 15, 16] as String[]
		def greater = new ProcessorHelperTuple('greater', 5)
		assertEquals(
				"greater wasn't returned",
				processLine(less, greater).name, 'greater')
	}

	@Test(expected=CanTParseNumber.class)
	public void testProcessLineBadInput() {
		processLine(["arrr", "abc", "cba"] as String[],null as ProcessorHelperTuple)
	}

	@Test
	public void testProcess() {
		 assertEquals("14 wasn't returned", process(), "14")
	}
}
