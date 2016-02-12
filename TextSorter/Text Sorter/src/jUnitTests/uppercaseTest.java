package jUnitTests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import algorithms.Uppercase;

public class uppercaseTest {

	@Test
	public void test() {

		File file = new File("src/jUnitTests/4.txt");
		File tempFile = new File("src/jUnitTests/temp.txt");
		
		Uppercase upper = new Uppercase();
		upper.makeUppercase(file,tempFile);
		
		try {
			
			ArrayList<String> strLst = new ArrayList<String>();
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//creates array to hold all words(Strings) from file
			String line;
			while((line = br.readLine()) != null){
				strLst.add(line);
			}
			
			//closes buffered reader
			br.close();
			
			//checks if any words are lower-case
			int counter = 0;
			while(counter < strLst.size()){
				if(strLst.get(counter).matches("[a-z]+") && strLst.get(counter) != ""){
					fail("not all upper-case");
				}
				counter ++;
			}
			
			//passes test and resets file
			assertEquals(1,1);
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("5" + "\n" + "abcd" + "\n" + "john" + "\n" + "bake" + "\n" + "done" + "\n" + "yesd");
			bw.close();
		}
		
		catch (IOException e){
			System.out.println("Could not find file: " + file);
			fail();
			e.printStackTrace();
		}
	}

}
