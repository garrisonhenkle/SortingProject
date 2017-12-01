package stuff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RandomNumberGenerator {

	public static void main(String[] args) throws IOException {

		int numNumbers = 10000;
		int fileNum;

		while (numNumbers <= 50000) {

			fileNum = 1;

			while (fileNum <= 10) {

				String pathString = "C:\\Code\\RandomNum\\" + Integer.toString(numNumbers) + "\\rand"
						+ Integer.toString(fileNum) + ".txt";
				Path path = Paths.get(pathString);

				try {
					Files.createFile(path);
				} catch (FileAlreadyExistsException ignored) {
				}

				PrintWriter out = new PrintWriter(pathString);

				int num;

				for (int i = 0; i < numNumbers - 1; i++) {
					num = (int) (Math.random() * Math.pow(10, 6));
					out.println(num);
				}

				num = (int) (Math.random() * Math.pow(10, 6));
				out.print(num);

				out.close();

				fileNum++;
			}
			numNumbers += 10000;
		}
	}
}
