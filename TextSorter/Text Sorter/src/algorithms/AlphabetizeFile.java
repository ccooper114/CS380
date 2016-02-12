package algorithms;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AlphabetizeFile {

	public AlphabetizeFile(File file){
		
		try {
		
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> strLst = new ArrayList<String>();
			
			//creates array
			br.readLine(); //skips header (number value for number words in list)
			String line = "";
			while((line = br.readLine()) != null){
				strLst.add(line);
				
			}
			br.close();
			
			//sort time complexity at n^2, try to make this heap sort to speed it up?
			boolean isSorted = false;
			while(isSorted == false){
				
				//sorts list
				String lastWord = strLst.get(0);
				int counter = 0;
				while(counter < strLst.size()){
					if(strLst.get(counter).compareTo(lastWord) < 0){
						//occurs if word being looked at is earlier in alphabet than last word
						//switches the two words
						strLst.set(counter - 1, strLst.get(counter));
						strLst.set(counter, lastWord);
					}
					lastWord = strLst.get(counter);
					counter ++;
				}
				
				//checks if in alphabetical order
				int checkCounter = 0;
				String lastString = strLst.get(0);
				while(checkCounter < strLst.size()){
					System.out.println(lastString.compareTo(strLst.get(checkCounter)));
					
					if(lastString.compareTo(strLst.get(checkCounter)) == 0 || lastString.compareTo(strLst.get(checkCounter)) < 0){
						lastString = strLst.get(checkCounter);
						isSorted = true;
					}
					else{
						isSorted = false;
						break;
					}
					checkCounter ++;
				}
			}
			
			//writes array to file
			FileWriter fw = new FileWriter(file,false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int writeCounter = 0;
			int totalWordsInt = strLst.size();
			Integer converter = totalWordsInt;
			String totalWordStr = converter.toString();
			bw.write(totalWordStr);
			while(writeCounter < strLst.size()){
				
				bw.write("\n");
				bw.write(strLst.get(writeCounter));
				writeCounter ++;
			}
			bw.close();
		}
		
		catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not find file: " + file);
		}
	}
}
