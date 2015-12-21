package dot.kata04.part2;

import java.io.File;

import dot.kata04.common.AbstractProcessor;
import dot.kata04.common.CanTParseNumber;

public class Football extends AbstractProcessor {
	private static Integer[] field_limit = { 7, 23, 39, 45, 48, 52 };
	private File file;

	public Football(File file) {
		this.file = file;
	}

	@Override
	protected ProcessorHelperTuple processLine(String[] split, ProcessorHelperTuple result) throws CanTParseNumber {
		try {
			Double f = Double.parseDouble(split[3]);
			Double a = Double.parseDouble(split[5]);
			Double diff = Math.abs(f - a);
			if (result == null || result.diff > diff) {
				return new ProcessorHelperTuple(split[1], diff);
			}
		} catch (NumberFormatException e) {
			// something went wrong. meh. who cares?
			throw new CanTParseNumber("Can't parse string as number", e);
		}
		return result;
	}

	@Override
	protected String getPrintableResult(ProcessorHelperTuple split) {
		return split.name;
	}

	@Override
	protected Integer[] getLimits() {
		return field_limit;
	}

	@Override
	protected File getFile() {
		return file;
	}
}
