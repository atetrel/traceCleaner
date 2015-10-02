package MainCleaner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Parsing.WriteFromListToFile;
import Parsing.textParser;

public class TraceCleaner {
	private String inputFileParentPath;
	private String inputFilePath;
	private String outputFileName;
	
	public TraceCleaner(String inputFileParentPath, String outputFileName, String inputFilePath) {
		super();
		this.inputFileParentPath = inputFileParentPath;
		this.outputFileName = outputFileName;
		this.inputFilePath = inputFilePath;
	}

	
	
	public TraceCleaner() {
		super();
	}

	public String getInputFileParentPath() {
		return inputFileParentPath;
	}

	public void setInputFileParentPath(String inputFileParentPath) {
		this.inputFileParentPath = inputFileParentPath;
	}
	
	public String getInputFilePath() {
		return inputFilePath;
	}

	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	
	public void execute() throws IOException {
		ArrayList<String> textParsed = new textParser(new File(inputFilePath)).parse();
		System.out.println(inputFileParentPath);
		new WriteFromListToFile(textParsed, inputFileParentPath+"\\"+outputFileName+".txt").writeToFile();
	}
	

}
