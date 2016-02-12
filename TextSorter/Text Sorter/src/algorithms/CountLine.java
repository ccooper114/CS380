package algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class CountLine {
	
	public int countWords(File file) {
		try {
			int numOfLines = -1; //start at -1 to prevent counting the header
//			int lineStarter = 1;
//			String fileName = new String ("c://"+numVar+".txt");
//			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			LineNumberReader tst = new LineNumberReader(reader);
			 
			while (tst.readLine() != null){
				numOfLines += 1;
			}
			
			
//			String lineNum = numOfLines + "";
//			FileWriter numWriter = new FileWriter(file);
//			BufferedWriter buffW = new BufferedWriter(numWriter);
//			while (tst.getLineNumber() == 0) {
//				buffW.write(numOfLines);
//			}
////			buffW.write(numOfLines);
//			buffW.close();
			tst.close();
			return numOfLines;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
