package jUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class writeToFileTest {

	@Test
	public void writeToFile_test() {

		File testFile = new File("src/jUnitTests/keepMeEmpty.txt");

		// TODO add method here for writing to file

		try {
			FileReader fr = new FileReader(testFile);

			BufferedReader br = new BufferedReader(fr);
			String firstLine = br.readLine();
			System.out.println(firstLine);
			if (firstLine != null && firstLine != "") {
				
				//resets file back to blank
				FileWriter fileReset = new FileWriter(testFile,false);
				fileReset.write("");
				fileReset.close();
				
				assertEquals(1, 1);
			}
			else{
				br.close();
				fail("file does not contain anything");
			}
			br.close();
			
		} 
		catch (IOException ex) {
			fail("file not found");
			ex.printStackTrace();
		}
	}
}