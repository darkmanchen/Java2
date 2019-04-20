/**
 * 
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author MO Fei
 *
 */
public class CSVIO {

	public static ArrayList<ArrayList<String>> read(String filePath) {
		File csvFile = new File(filePath);
		if (csvFile.isFile()) {
			try {
				Scanner lineScanner = new Scanner(csvFile);
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

	public static void save(String filePath, ArrayList<ArrayList<String>> arrayLists) {
		File csvFile = new File(filePath);
		try {
			if (!csvFile.exists()) {
				csvFile.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(csvFile);
			for (ArrayList<String> arrayList : arrayLists) {
				for (int index = 0; index < arrayList.size(); ++index) {
					fileWriter.write(arrayList.get(index));
					if (index + 1 != arrayList.size()) {
						fileWriter.write(',');
					} else {
						fileWriter.write('\n');
					}
				}
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
