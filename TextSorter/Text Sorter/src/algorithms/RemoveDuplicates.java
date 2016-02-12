package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RemoveDuplicates {
	
	public RemoveDuplicates(File file){
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			br.readLine(); //skips header
			
			//create array to hold strings
			ArrayList<String> strLst = new ArrayList<String>();
			String line = "";
			while((line = br.readLine()) != null){
				strLst.add(line);
			}
			
			br.close();
			
			//runs through array list and removes duplicates, time complexity n^2
			int finalCounter = 0;
			int counter = 0;
			while(finalCounter < strLst.size()){
				String searchFor = strLst.get(counter);
				counter ++; //skips current value so its not checked and removed
				while(counter < strLst.size()){
					if(searchFor.compareTo(strLst.get(counter)) == 0){
						strLst.remove(counter);
					}
					else{
						counter ++;
					}
				}
				finalCounter ++; //allows farthest out of scope while loop to end
				counter = finalCounter; //resets counter of inner loop for next go
			}
			
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//writes header
			int totalWords = strLst.size();
			Integer converter = new Integer(totalWords);
			String totalWordStr = converter.toString(totalWords);
			fw.write(totalWordStr);
			
			//writes words back into file
			int writeCounter = 0;
			while(writeCounter < strLst.size()){
				fw.write("\n");
				fw.write(strLst.get(writeCounter));
				writeCounter ++;
			}
			
			bw.close();
			
		}
		catch (IOException e) {
			System.out.println("Could not find file: " + file);
			e.printStackTrace();
		}
		String filePath = "src/dictionary/";
	}
}

