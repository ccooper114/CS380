package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Split {

	public void splitWords(File file){
		
		BufferedReader br = null;

		try{

			br = new BufferedReader(new FileReader(file));	//reads the file
			String line = "";
			while((line = br.readLine()) != null){
				
				String[] splitUpLst = line.split("\\s");	//split the space in between lines

				//if bigger than 3 character, smaller than 10 char, n is not int...
				int counter = 0;
				while(counter < splitUpLst.length){
					String word = splitUpLst[counter];
					if(word.length() >= 3 && word.length() <= 10 && word.matches("[a-zA-Z]+")){
						writeFile(word);	
					}
					counter ++;
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void writeFile(String str) throws IOException{
		System.out.println(str);

		String filePath = "src/dictionary/";
		Integer converter = new Integer(str.length());
		String fileName = converter.toString() + ".txt";
		
		File file = new File(filePath + fileName);
		
		FileWriter fw = new FileWriter(file, true);
		
		try{
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			fw.write("\n" + str);	//writes into the file with the string argument
			fw.close();
			
			
		}
		catch(IOException e){
			System.err.format("Can not be written");
			e.printStackTrace();
		}
		
	}

}