package dot.kata04.common.test

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import dot.kata04.common.LineSplitter

class LineSplitterShouldPass {
	String simpleStr = "  2     8     15    "
	
	Integer[] fl = new Integer[2]

	@Before
	public void setUp() {
		fl[0]=3
		fl[1]=9
	}


	@Test
	public void testSimple() {
		String[] splittedString = LineSplitter.split(simpleStr,fl)
		assertEquals("1st is not 2", "2", splittedString[0])
		assertEquals("2nd is not 8", "8", splittedString[1])
		assertEquals("3rd is not 15", "15", splittedString[2])
	}
}
