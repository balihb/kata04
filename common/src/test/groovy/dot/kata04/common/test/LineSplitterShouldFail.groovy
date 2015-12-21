package dot.kata04.common.test

import org.junit.Before
import org.junit.Test

import dot.kata04.common.FieldLimitException
import dot.kata04.common.LineSplitter

class LineSplitterShouldFail {
	String simpleStr = "  2     8     15"
	String emptyStr = ""

	Integer[] fl = new Integer[2]

	@Test(expected=FieldLimitException.class)
	public void testWrongIndex() {
		fl[0]=3
		fl[1]=16
		LineSplitter.split(simpleStr, fl)
	}

	@Test(expected=FieldLimitException.class)
	public void testShorterString() {
		fl[0]=3
		fl[1]=9
		LineSplitter.split(emptyStr, fl)
	}
	
	@Test(expected=FieldLimitException.class)
	public void testEmptyEmpty() {
		String[] str = LineSplitter.split(emptyStr, new Integer[0])
	}
}
