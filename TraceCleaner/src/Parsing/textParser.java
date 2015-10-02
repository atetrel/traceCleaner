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
		
		while ( (myLine = bufRead.readLine()) != null)
		{
			if (myLine.startsWith("DTWH") && myLine.contains("ENTER SQLExecDirectW")){
				bufRead.readLine();
				System.out.println(bufRead.readLine());
				System.out.println();
			}
		}
		
		return rows;
	}
	
	
	public static void main(String[] args) {
		textParser p = new textParser(
				new File ("S:\\SER_PILOTAGE_ET_INFOCENTRE\\COMMUN\\Pilotage\\V2\\Reinternalisation Framework\\02 - Documentation sur l'existant\\OdbcTrc\\SQL-20150904-001.LOG"));
		
		try {
			p.parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
