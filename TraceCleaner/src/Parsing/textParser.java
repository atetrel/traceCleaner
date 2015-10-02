package Parsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class textParser {
	private File file;
	
	public textParser () {
	}
	
	public textParser (File f) {
		file=f;
	}
	
	public void setFile (File f) {
		file=f;
	}
	
	public File getFile () {
		return file;
	}
	
	public ArrayList<String> parse () throws IOException {
		ArrayList<String> rows = new ArrayList<String>();
		
		
		// read the file f
		FileReader input = new FileReader(file);
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;
		String toWrite;
		int a=0;
		
		while ( (myLine = bufRead.readLine()) != null)
		{
			if (myLine.startsWith("DTWH") && myLine.contains("ENTER SQLExecDirectW")){
				bufRead.readLine();
				toWrite = bufRead.readLine();
				toWrite = toWrite.substring(toWrite.indexOf("] ")+2, toWrite.length());
				toWrite = toWrite.replace("\"", "");
				rows.add(toWrite);
			}
		}
		System.out.println(a);
		bufRead.close();
		return rows;
	}
	

}
