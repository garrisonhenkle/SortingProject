package stuff;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TestingTemplate {

	public static void main(String[] args) {

		int fileNum;
		String pathString;
		Scanner scan;
		int currPos;

		int[][] rand1 = new int[10][10000];
		int[][] rand2 = new int[10][20000];
		int[][] rand3 = new int[10][30000];
		int[][] rand4 = new int[10][40000];
		int[][] rand5 = new int[10][50000];

		int[][] sort1 = new int[10][10000];
		int[][] sort2 = new int[10][20000];
		int[][] sort3 = new int[10][30000];
		int[][] sort4 = new int[10][40000];
		int[][] sort5 = new int[10][50000];

		int[][] active;

		for (int i = 10000; i <= 50000; i += 10000) {

			for (fileNum = 1; fileNum <= 10; fileNum++) {

				pathString = "C:\\Code\\RandomNum\\" + Integer.toString(i) + "\\rand" + Integer.toString(fileNum)
						+ ".txt";

				Path path = Paths.get(pathString);

				switch (i) {
				case 10000:
					active = rand1;
					break;
				case 20000:
					active = rand2;
					break;
				case 30000:
					active = rand3;
					break;
				case 40000:
					active = rand4;
					break;
				case 50000:
					active = rand5;
					break;
				default:
					active = rand1;
				}

				try {
					scan = new Scanner(path);
					currPos = 0;

					while (scan.hasNextInt()) {
						active[fileNum - 1][currPos] = scan.nextInt();
						currPos++;
					}

				} catch (Exception ignored) {
				}

			}
		}

		/////////////////////////////////////////////////////////////
		// Insert the sorting algorithm here
		/////////////////////////////////////////////////////////////

		// columns are for the 10 rand files, the rows indicate which length are being
		// used
		long[][] times = new long[5][10];

		// stores the start, final, and elapsed time
		long startTime;
		long finalTime;
		long time;

		// holds the current array being sorted
		int currArray[];

		// contains the sorts
		SortsClass sorts = new SortsClass();

		// holds the sorted data
		Integer[] data;

		PrintWriter out;

		// rand1
		for (int i = 1; i <= 10; i++) {

			currArray = rand1[i - 1];

			data = Arrays.stream(currArray).boxed().toArray(Integer[]::new);

			startTime = System.nanoTime();

			sorts.selectionSort(data, 10000);

			finalTime = System.nanoTime();
			time = finalTime - startTime;

			System.out.println(i + ": " + time);
			times[0][i - 1] = time;

			try {
				Files.createFile(Paths.get("C:\\Code\\sortedRand" + i + "_10000.txt"));
			} catch (Exception ignored) {
			}
			try {
				out = new PrintWriter("C:\\Code\\sortedRand" + i + "_10000.txt");

				for (int j = 0; j < 9999; j++) {
					out.println(data[j]);
				}
				out.print(data[9999]);

				out.close();
			} catch (Exception ignored) {
			}

		}

		double sum = 0;
		for (long i : times[0]) {
			sum += i;
		}
		System.out.println("The average time (10000) was " + Double.toString(((sum / 10) / 1000000000)) + " seconds.");

		// rand2
		for (int i = 1; i <= 10; i++) {

			currArray = rand2[i - 1];

			data = Arrays.stream(currArray).boxed().toArray(Integer[]::new);

			startTime = System.nanoTime();

			sorts.selectionSort(data, 20000);

			finalTime = System.nanoTime();
			time = finalTime - startTime;

			System.out.println(i + ": " + time);
			times[1][i - 1] = time;

			try {
				Files.createFile(Paths.get("C:\\Code\\sortedRand" + i + "_20000.txt"));
			} catch (Exception ignored) {
			}
			try {
				out = new PrintWriter("C:\\Code\\sortedRand" + i + "_20000.txt");

				for (Integer intInData : data) {
					out.println(intInData);
				}

			} catch (Exception ignored) {
			}
		}

		sum = 0;
		for (long i : times[1]) {
			sum += i;
		}
		System.out.println("The average time (20000) was " + Double.toString(((sum / 10) / 1000000000)) + " seconds.");

		// rand3
		for (int i = 1; i <= 10; i++) {

			currArray = rand3[i - 1];

			data = Arrays.stream(currArray).boxed().toArray(Integer[]::new);

			startTime = System.nanoTime();

			sorts.selectionSort(data, 30000);

			finalTime = System.nanoTime();
			time = finalTime - startTime;

			System.out.println(i + ": " + time);
			times[2][i - 1] = time;

			try {
				Files.createFile(Paths.get("C:\\Code\\sortedRand" + i + "_30000.txt"));
			} catch (Exception ignored) {
			}
			try {
				out = new PrintWriter("C:\\Code\\sortedRand" + i + "_30000.txt");

				for (Integer intInData : data) {
					out.println(intInData);
				}

			} catch (Exception ignored) {
			}
		}

		sum = 0;
		for (long i : times[2]) {
			sum += i;
		}
		System.out.println("The average time (30000) was " + Double.toString(((sum / 10) / 1000000000)) + " seconds.");

		// rand4
		for (int i = 1; i <= 10; i++) {

			currArray = rand4[i - 1];

			data = Arrays.stream(currArray).boxed().toArray(Integer[]::new);

			startTime = System.nanoTime();

			sorts.selectionSort(data, 40000);

			finalTime = System.nanoTime();
			time = finalTime - startTime;

			System.out.println(i + ": " + time);
			times[3][i - 1] = time;

			try {
				Files.createFile(Paths.get("C:\\Code\\sortedRand" + i + "_40000.txt"));
			} catch (Exception ignored) {
			}
			try {
				out = new PrintWriter("C:\\Code\\sortedRand" + i + "_40000.txt");

				for (Integer intInData : data) {
					out.println(intInData);
				}

			} catch (Exception ignored) {
			}
		}

		sum = 0;
		for (long i : times[3]) {
			sum += i;
		}
		System.out.println("The average time (40000) was " + Double.toString(((sum / 10) / 1000000000)) + " seconds.");

		// rand5
		for (int i = 1; i <= 10; i++) {

			currArray = rand5[i - 1];

			data = Arrays.stream(currArray).boxed().toArray(Integer[]::new);

			startTime = System.nanoTime();

			sorts.selectionSort(data, 50000);

			finalTime = System.nanoTime();
			time = finalTime - startTime;

			System.out.println(i + ": " + time);
			times[4][i - 1] = time;

			try {
				Files.createFile(Paths.get("C:\\Code\\sortedRand" + i + "_50000.txt"));
			} catch (Exception ignored) {
			}
			try {
				out = new PrintWriter("C:\\Code\\sortedRand" + i + "_50000.txt");

				for (Integer intInData : data) {
					out.println(intInData);
				}

			} catch (Exception ignored) {
			}
		}

		sum = 0;
		for (long i : times[4]) {
			sum += i;
		}
		System.out.println("The average time (50000) was " + Double.toString(((sum / 10) / 1000000000)) + " seconds.");
		/////////////////////////////////////////////////////////////
		// End of sorting algorithm
		/////////////////////////////////////////////////////////////
	}
}
