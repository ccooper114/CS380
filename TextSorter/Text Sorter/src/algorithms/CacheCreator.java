package algorithms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CacheCreator {

	public CacheCreator(){
		
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
		
		if(threeTxt.exists() == false || fourTxt.exists() == false || fiveTxt.exists() == false || sixTxt.exists() == false ||
				sevenTxt.exists() == false || eightTxt.exists() == false || nineTxt.exists() == false || tenTxt.exists() == false){
			try {
				//creates files
				threeTxt.createNewFile();
				fourTxt.createNewFile();
				fiveTxt.createNewFile();
				sixTxt.createNewFile();
				sevenTxt.createNewFile();
				eightTxt.createNewFile();
				nineTxt.createNewFile();
				tenTxt.createNewFile();
				tempTxt.createNewFile();
				
				//opens the files
				FileWriter fw3 = new FileWriter(threeTxt);
				FileWriter fw4 = new FileWriter(fourTxt);
				FileWriter fw5 = new FileWriter(fiveTxt);
				FileWriter fw6 = new FileWriter(sixTxt);
				FileWriter fw7 = new FileWriter(sevenTxt);
				FileWriter fw8 = new FileWriter(eightTxt);
				FileWriter fw9 = new FileWriter(nineTxt);
				FileWriter fw10 = new FileWriter(tenTxt);
				FileWriter fwTemp = new FileWriter(tempTxt);
				
				//writes file headers
				fw3.write("0");
				fw4.write("0");
				fw5.write("0");
				fw6.write("0");
				fw7.write("0");
				fw8.write("0");
				fw9.write("0");
				fw10.write("0");
				fwTemp.write("0");
				
				//closes writers
				fw3.close();
				fw4.close();
				fw5.close();
				fw6.close();
				fw7.close();
				fw8.close();
				fw9.close();
				fw10.close();
				fwTemp.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
