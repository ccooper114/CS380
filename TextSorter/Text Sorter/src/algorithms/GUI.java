package algorithms;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class GUI extends JFrame {
	
	private JTextField fileField;
	private JTextField txtEnterWordTo;
	
	public GUI() {
		
		this.setTitle("Text Sorter");
		this.setSize(400,200);
		getContentPane().setLayout(new GridLayout(4, 1, 0, 0));
		
		fileField = new JTextField();
		fileField.setText("Enter file path:");
		getContentPane().add(fileField);
		fileField.setColumns(10);
		
		JButton btnCallButton = new JButton("Sort File");
		getContentPane().add(btnCallButton);
		
		txtEnterWordTo = new JTextField();
		txtEnterWordTo.setText("Enter Word to find:");
		getContentPane().add(txtEnterWordTo);
		txtEnterWordTo.setColumns(10);
		
		JButton btnDoesWordExist = new JButton("Does Word Exist");
		getContentPane().add(btnDoesWordExist);
		
		btnCallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onCallBtnClicked();
			}
		});
		btnDoesWordExist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onWordExistClicked();
			}
		});
	}
	
	protected void onWordExistClicked(){
		
		String word = this.txtEnterWordTo.getText();
		
		CheckExist find = new CheckExist();
		try {
			boolean present = find.wordExist(word);
			if(present == true){
				this.txtEnterWordTo.setText("Word exists");
			}
			else{
				this.txtEnterWordTo.setText("Word does not exist");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	protected void onCallBtnClicked() {
		//gets info for file location in user's hard drive
		String filePath = this.fileField.getText();
		String programFilePath = "src/dictionary/";
		
		//makes sure the dictionary files exist
		CacheCreator creator = new CacheCreator();
		
		//opens files for use
		File file = new File(filePath);
		File tempFile = new File(programFilePath + "temp.txt");
		
		//splits up and sorts file into dictionary
		Split splitter = new Split();
		splitter.splitWords(file);
		Uppercase upper = new Uppercase();
		
		
		int counter = 3;
		while(counter < 11){
			//opens dictionary file
			Integer converter = new Integer(counter);
			String number = converter.toString();
			File programFile = new File(programFilePath + number + ".txt");
			
			//modifies dictionary file to specifications
			//removes all duplicates, sets files to uppercase, and alphabetizes them
			RemoveDuplicates remover = new RemoveDuplicates(programFile);
			upper.makeUppercase(programFile, tempFile);
			AlphabetizeFile sorter = new AlphabetizeFile(programFile);
		}
	}
}
