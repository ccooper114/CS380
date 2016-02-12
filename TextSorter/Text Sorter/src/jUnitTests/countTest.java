package jUnitTests;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

import algorithms.CountLine;

public class countTest {

	@Test
	public void count_Test() {

		File file = new File("src/jUnitTests/4.txt");
		
		CountLine counter = new CountLine();
		int totalWords = counter.countWords(file);
		
		assertEquals("incorrect count",5,totalWords);
	}

}
