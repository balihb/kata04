package dot.kata04.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineReader {
	private File file;
	private BufferedReader br = null;

	public LineReader(File file) {
		this.file = file;
	}

	public String nextLine() throws IOException {
			checkInit();
			return br.readLine();
	}

	private void checkInit() throws FileNotFoundException {
		if (br == null) {
			br = new BufferedReader(new FileReader(file));
		}
	}
	
	public void close() throws IOException{
		if (br == null) {
			br.close();
		}
	}
}
