package jUnitTests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import algorithms.RemoveDuplicates;

public class duplicateRemoverTest {

	@Test
	public void duplicateRemover_test() {
		
		File file = new File("src/jUnitTests/duplicates.txt");
		
		RemoveDuplicates remover = new RemoveDuplicates(file);
		
		try {
			
			ArrayList<String> strLst = new ArrayList<String>();
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			br.readLine(); //skips header
			
			//creates array to hold all words(Strings) from file
			String line;
			while((line = br.readLine()) != null){
				strLst.add(line);
			}
			
			//closes buffered reader
			br.close();
			
			//checks if any duplicates exist
			int counter = 0;
			String lastWord = "";
			System.out.println(strLst);
			while(counter < strLst.size()){
				if(strLst.get(counter).compareTo(lastWord) == 0){
					fail("Duplicate Words still exist");
				}
				lastWord = strLst.get(counter);
				counter ++;
			}
			
			//passes test and resets file
			assertEquals(1,1);
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("8" + "\n" + "duplicate" + "\n" + "duplicate" + "\n" + "hi" + "\n" + "john" + "\n" + "chocolate" + "\n" + "yes" + 
					"\n" + "balls" + "\n" + "hi");
			bw.close();
		}
		
		catch (IOException e){
			System.out.println("Could not find file: " + file);
			fail();
			e.printStackTrace();
		}
		
	}

}
