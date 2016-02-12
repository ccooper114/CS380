package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class Uppercase {
	public void makeUppercase(File file, File tempFile) {
		try {
			//runs through first file and copies upper-case text to temporary file
			FileReader reader = new FileReader(file);
			LineNumberReader tst = new LineNumberReader(reader);
			
			FileWriter lineWriter = new FileWriter(tempFile,false);
			BufferedWriter buffW = new BufferedWriter(lineWriter);
			String wordHolder = "";
			while ((wordHolder = tst.readLine()) != null) {
				String uppedWordHolder = wordHolder.toUpperCase();
				buffW.write(uppedWordHolder);
				buffW.write("\n");
			}
			buffW.close();
			tst.close();
			
			//writes from Upper-case temporary file to real file
			FileReader fr = new FileReader(tempFile);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(file,false);
			
			String line = "";
			while((line = br.readLine()) != null){
				fw.write("\n" + line);
			}
			fw.close();
			br.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
