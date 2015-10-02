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
		File result = new File(fileURI);
		PrintWriter out = new PrintWriter(fileURI);
		for (int i=0;i<stringList.size();i++){
			out.println(stringList.get(i));
		}
		out.close();
	}
	
	public static void main(String[] args) {
		textParser tp = new textParser(
				new File("S:\\SER_PILOTAGE_ET_INFOCENTRE\\COMMUN\\Pilotage\\V2\\Reinternalisation Framework\\02 - Documentation sur l'existant\\OdbcTrc\\SQL-20150904-001.LOG"));
		ArrayList<String> toWrite;
		try {
			toWrite = tp.parse();
			WriteFromListToFile wfltf = new WriteFromListToFile(toWrite,
					"S:\\SER_PILOTAGE_ET_INFOCENTRE\\COMMUN\\Pilotage\\V2\\Reinternalisation Framework\\02 - Documentation sur l'existant\\OdbcTrc\\output.txt");
			wfltf.writeToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
