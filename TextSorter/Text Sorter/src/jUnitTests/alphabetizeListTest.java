package jUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import algorithms.AlphabetizeFile;

public class alphabetizeListTest {

	@Test
	public void alphabetizeList_test() {

		File testFile = new File("src/jUnitTests/4.txt");
		
		AlphabetizeFile txtFile = new AlphabetizeFile(testFile);

		String line = null;
		ArrayList<String> wordLst = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(testFile);
			BufferedReader br = new BufferedReader(fr);
			
			//skip header
			br.readLine();

			while ((line = br.readLine()) != null) {
				wordLst.add(line);
			}
			br.close();
			
			int counter = 0;
			String lastString = wordLst.get(0);
			while(counter < wordLst.size()){
				if(lastString != ""){
					if(lastString.compareTo(wordLst.get(counter)) < 0 || lastString.compareTo(wordLst.get(counter)) == 0){
						lastString = wordLst.get(counter);
					}
					else{
						fail("file not alphabetized");
					}
				}
				counter ++;
			}
			
			//passes test and resets file
			assertEquals(1,1);
			FileWriter fw = new FileWriter(testFile, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("5" + "\n" + "abcd" + "\n" + "john" + "\n" + "bake" + "\n" + "done" +
					"\n" +"yesd");
			bw.close();
			
		} catch (IOException ex) {
			System.out.println("Cannot read file: " + testFile);
			fail();
		}
	}
}
