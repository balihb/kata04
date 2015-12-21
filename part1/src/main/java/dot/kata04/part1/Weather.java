package dot.kata04.part1;

import java.io.File;

import dot.kata04.common.AbstractProcessor;
import dot.kata04.common.CanTParseNumber;

public class Weather extends AbstractProcessor {
	private static Integer[] field_limit = { 5, 9, 15 };
	private File file;

	public Weather(File file) {
		this.file = file;
	}

	@Override
	protected ProcessorHelperTuple processLine(String[] split, ProcessorHelperTuple result) throws CanTParseNumber {
		try {
			Double max = Double.parseDouble(split[1]);
			Double min = Double.parseDouble(split[2]);
			Double diff = Math.abs(max - min);
			if (result == null || ((max >= min) && result.diff > diff)) {
				return new ProcessorHelperTuple(split[0], diff);
			}
		} catch (NumberFormatException e) {
			// something went wrong. meh. who cares?
			throw new CanTParseNumber("Can't parse string as number", e);
		}
		return result;
	}

	@Override
	protected Integer[] getLimits() {
		return field_limit;
	}

	@Override
	protected File getFile() {
		return file;
	}

	@Override
	protected String getPrintableResult(ProcessorHelperTuple result) {
		return result.name;
	}

}
