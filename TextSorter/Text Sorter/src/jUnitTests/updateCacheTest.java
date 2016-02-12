package jUnitTests;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

import algorithms.CacheCreator;

public class updateCacheTest {

	@Test
	public void update_test() {
		
		//runs creator
		CacheCreator crtr = new CacheCreator();
		
		String filePath = "src/dictionary/";
		
		//creates file objects
		File threeTxt = new File(filePath + "3.txt");
		File fourTxt = new File(filePath + "4.txt");
		File fiveTxt = new File(filePath + "5.txt");
		File sixTxt = new File(filePath + "6.txt");
		File sevenTxt = new File(filePath + "7.txt");
		File eightTxt = new File(filePath + "8.txt");
		File nineTxt = new File(filePath + "9.txt");
		File tenTxt = new File(filePath + "10.txt");
		File tempTxt = new File(filePath + "temp.txt");
		
		//uses exist method from file object to see if they are present
		assertTrue(threeTxt.exists());
		assertTrue(fourTxt.exists());
		assertTrue(fiveTxt.exists());
		assertTrue(sixTxt.exists());
		assertTrue(sevenTxt.exists());
		assertTrue(eightTxt.exists());
		assertTrue(nineTxt.exists());
		assertTrue(tenTxt.exists());
		assertTrue(tempTxt.exists());
	}
}
