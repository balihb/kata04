package dot.kata04.common;

public class LineSplitter {
	public static String[] split(String line, Integer[] field_limit) throws FieldLimitException {
		checkValidFieldLimitArray(field_limit);
		checkLast(line, field_limit);
		String[] rtr = new String[field_limit.length + 1];
		Integer start = 0;
		for(Integer i = 0; i < field_limit.length; i ++) {
			checkValidNext(start, field_limit[i], line);
			rtr[i] = subStr(line, start, field_limit[i]);
			start = field_limit[i];
		}
		rtr[rtr.length - 1] = subStr(line, field_limit[field_limit.length - 1]);
		return rtr;
	}
	
	private static String subStr(String str, Integer start, Integer end) {
		return str.substring(start, end).trim();
	}
	
	private static String subStr(String str, Integer start) {
		return str.substring(start).trim();
	}
	
	private static void checkValidNext(Integer prev, Integer next, String str) throws FieldLimitException {
		if(prev >= next) throw new FieldLimitException(prev + " is bigger, than " + next);
		if(next > str.length() - 2) throw new FieldLimitException(next + " is bigger, than string length " + str.length());
	}
	
	private static void checkLast(String str, Integer[] fl) throws FieldLimitException {
		int ln = fl.length;
		if(fl[ln - 1] > str.length()) throw new FieldLimitException("last index is higher, than the length of the string");
	}
	
	private static void checkValidFieldLimitArray(Integer[] fl) throws FieldLimitException {
		if(fl == null || fl.length == 0) throw new FieldLimitException("field limit is invalid");
	}
}
