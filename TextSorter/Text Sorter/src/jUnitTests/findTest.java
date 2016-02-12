package jUnitTests;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

import algorithms.CheckExist;


public class findTest {
	
	@Test
	public void find_test(){
		
		File testFile = new File("src/jUnitTest/4.txt");
		
		CheckExist obj = new CheckExist();

		try {
			boolean rtnedBoolean = obj.wordExist("john");
			assertTrue("extant word not found",rtnedBoolean);
			
		} catch (IOException e) {
			fail("Could not find file: " + testFile);
			e.printStackTrace();
		}
		
		
	}

}
