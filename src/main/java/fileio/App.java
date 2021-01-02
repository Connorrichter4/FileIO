package fileio;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
			
		CreateAndModify newFile = new CreateAndModify();
		newFile.readFromFile();
		newFile.modifyFile("I am editing this file!");
		newFile.readFromFile();
		
	}

}
