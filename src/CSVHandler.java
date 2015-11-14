import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;

public class CSVHandler {
	int count = 0;
	CSVReader reader = null;
	StringBuilder sb = new StringBuilder("");
	String[] nextLine;
	String uncompressedData = new String();

	public CSVHandler() {
		/* Initializing the file reader */
		try {
			reader = new CSVReader(new FileReader("F:\\FYP related contents\\Debs_challenge\\sorted100M.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CSVHandler(String path) {
		/* Initializing the file reader */
		try {
			reader = new CSVReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String returnStringData(int maxBlockLines, boolean print_flag) {
		try {
			while (((nextLine = reader.readNext()) != null) && (count < maxBlockLines)) {
				for (int i = 0; i < 7; i++) { // picking up all the elements of
												// a single CSV row
					sb.append(nextLine[i]);
					sb.append(",");
				}

				/*int limiterTimeStamp = Integer.parseInt(nextLine[1]);
				int temp = 0;
				if (count == 0) {
					temp = limiterTimeStamp;
				}
				if (limiterTimeStamp != temp) {
					break;
				}
				temp = limiterTimeStamp;*/

				uncompressedData += sb; // creating single String document from
										// CSV
				uncompressedData += "\n"; // creating the new line in the single
				if (print_flag) {
					System.out.println(sb); // print line by line fetched data
											// from CSV file
				}
				sb.delete(0, sb.length()); // clearing the String builder to
											// Fetch next new line
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uncompressedData;
	}

	public void closeCSVReader() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
