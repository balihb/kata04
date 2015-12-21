package dot.kata04.common;

import java.io.File;
import java.io.IOException;

public abstract class AbstractProcessor {
	public String process() throws AllLinesSkipped, FileHadZeroLinues {
		LineReader lr = new LineReader(getFile());
		String line = null;
		Integer skipped = 0;
		Integer lines = 0;
		ProcessorHelperTuple result = null;
		try {
			while ((line = lr.nextLine()) != null) {
				lines++;
				try {
					result = processLine(LineSplitter.split(line, getLimits()), result);
				} catch (Exception e) {
					skipped++;
				}
			}
		} catch (IOException e) {
			System.err.println("Failed to open file: " + getFile().getAbsolutePath());
		}
		if (lines == 0)
			throw new FileHadZeroLinues(getFile().getAbsolutePath());
		if (skipped.equals(lines))
			throw new AllLinesSkipped(getFile().getAbsolutePath());
		return getPrintableResult(result);
	}

	protected abstract ProcessorHelperTuple processLine(String[] split, ProcessorHelperTuple result) throws CanTParseNumber;
	
	protected abstract String getPrintableResult(ProcessorHelperTuple split);
	
	protected abstract Integer[] getLimits();
	
	protected abstract File getFile();
	
	public static class ProcessorHelperTuple {
		public final String name;
		public final Double diff;
		public ProcessorHelperTuple(String name, Double diff) {
			this.name = name;
			this.diff = diff;
		}
	}
}
