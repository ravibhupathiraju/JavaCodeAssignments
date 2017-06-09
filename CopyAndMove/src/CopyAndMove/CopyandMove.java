//Copy and move program. Does copy/move to a target location. If the target location directory does not exist, this program will create it.
//* Takes three arguments as inputs that is move/copy action, source file location, target file location. 
//Arguments input example- move ou2.txt "C:/My Data/GFC/Javacode/CopyAndMove/ravinew2/ou2.txt"

package CopyAndMove;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class CopyandMove {

	private static byte[] data = null;

	// read method
	private static void read(String action, String path) {
		byte[] buf = new byte[100];
		int dataIdx = 0;
		try {
			RandomAccessFile f = new RandomAccessFile(path, "r");
			data = new byte[(int) f.length()];
			while (true) {
				int nBytes = f.read(buf);
				if (nBytes == -1) {
					break;
				}
				for (int i = 0; i < nBytes; i++) {
					data[dataIdx] = buf[i];
					dataIdx++;
				}
			}
			f.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Input file not found");
			System.exit(1);
		} catch (IOException ex) {
			System.out.println(ex);
			System.exit(1);
		}
		Charset cs = Charset.forName("UTF-8");
		String s = new String(data, cs);
	}

	// Write method for writing into a new location
	public static void write(String Action, byte[] bs, String outPath) {
		try {
			Path path = Paths.get(outPath);
			if (!Files.exists(path)) {
				try {
					Files.createDirectories(path.getParent());
				} catch (IOException e) {
					// fail to create directory
					e.printStackTrace();
				}
			}
			RandomAccessFile f = new RandomAccessFile(outPath, "rw");
			f.write(bs);
			f.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Output file path not found");
			System.exit(1);
		} catch (IOException ex) {
			System.out.println(ex);
			System.exit(1);
		}
	}

	// Main method
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out
					.println("This program needs three inputs: copy/move, input file name, outputfile");
			return;
		}
		String action = args[0];
		String inputFilPath = args[1];
		String outFilPath = args[2];
		if (!("move".equals(action))) {
			if (!("copy".equals(action))) {
				System.out
						.println("first input parameter should be a move or copy");
				return;
			}
		}
		CopyandMove.read(action, inputFilPath);
		CopyandMove.write(action, data, outFilPath);
		if ("move".equals(action)) {
			File file = new File(inputFilPath);
			file.delete();
			System.out.println("File moved successfully to " + outFilPath);
		} else if ("copy".equals(action)) {
			System.out.println("File copied successfully to " + outFilPath);
		}

	}
}