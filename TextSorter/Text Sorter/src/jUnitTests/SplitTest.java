package jUnitTests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import algorithms.Split;

public class SplitTest {

	@Test
	public void test() {
		String filePath = "src/jUnitTests/";
		File file = new File(filePath + "splitTextTest.txt");
		
		Split spliter = new Split();
		spliter.splitWords(file);
		
		//check files 3, 4, 5, 6
		
		//no real test here, just kinda... you know... yeah...
	}

}
