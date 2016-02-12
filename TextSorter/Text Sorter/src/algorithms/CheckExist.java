package algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckExist {

	String name = "";
	File dict;

	
	public String getFileName(int n){
		
		//might be unnecessary, see final method
		
		if(n>11||n<=3){
			System.err.println("ERROR");
			return null;
		}
		return n + ".txt";
	}

	
	public boolean fileCheck(){
		//I don't know if this is supposed to be how you check for if the dictionary exists or not
		//if it is, should it find no dictionary, it needs to create the dictionary package and associated files
		// that or it needs another method to do this

		int n = 0;

		name = getFileName(n);

		dict = new File(name);	//need someway to get the txt from the dict file

		boolean checkExist = false;


		for(int i = 0; i < 7; i++){
			i += 3;
			n = i;
			try{
				//dict.createNewFile();

				//dict = new File(empty);
				//if(dict.exists() && dict.isFile()){
				//		System.out.println("File exists")
				//}

				checkExist = new File(new File(getFileName(i)), dict.getName()).exists();	//check if the dict exist
				System.out.println("File is a file" + checkExist);

				if(dict.isDirectory()) checkExist = true;
				System.out.println("File is a directory" + checkExist);

			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return checkExist;
	}

	
	public boolean wordExist(String word) throws IOException{
		
		int n = word.length();
		boolean checkExists = false;

		File file = new File("src/jUnitTests/" + getFileName(n));
		
		BufferedReader br = null;

		try{
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line = "";
			while((line = br.readLine()) != null){
				if(word.equalsIgnoreCase(line)){
					checkExists = true;
					return checkExists;
				}
			}
		}catch(IOException e){
			System.err.println("File not found");
			e.printStackTrace();
		}

		finally{
			try{
				if(br!=null){
					br.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
				System.exit(1);
			}
		}
		return checkExists;
	}
}