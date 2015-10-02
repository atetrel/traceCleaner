package Parsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteFromListToFile {
	private ArrayList<String> stringList;
	private String fileURI;

	public ArrayList<String> getStringList() {
		return stringList;
	}

	public void setStringList(ArrayList<String> stringList) {
		this.stringList = stringList;
	}

	public WriteFromListToFile(ArrayList<String> stringList, String fileURI) {
		super();
		this.stringList = stringList;
		this.fileURI=fileURI;
	}

	public WriteFromListToFile() {
		super();
	}
	
	public void writeToFile() throws FileNotFoundException {
		new File(fileURI);
		PrintWriter out = new PrintWriter(fileURI);
		for (int i=0;i<stringList.size();i++){
			out.println(stringList.get(i));
		}
		out.close();
		System.out.println("hihi");
	}
	

}
