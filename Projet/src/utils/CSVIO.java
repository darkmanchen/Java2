/**
 * 
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author MO Fei
 *
 */
public class CSVIO {

	public static ArrayList<ArrayList<String>> read(String filePath) {
		File file = new File(filePath);
		if (file.isFile()) {
			try {
				Scanner lineScanner = new Scanner(file);
				ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
				while (lineScanner.hasNextLine()) {
					Scanner valueScanner = new Scanner(lineScanner.nextLine());
					ArrayList<String> rowValues = new ArrayList<String>();
					valueScanner.useDelimiter(",");
					while (valueScanner.hasNext()) {
						rowValues.add(valueScanner.next());
					}
					table.add(rowValues);
					valueScanner.close();
				}
				lineScanner.close();
				return table;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
