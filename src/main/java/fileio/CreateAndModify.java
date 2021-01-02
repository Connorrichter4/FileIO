package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class CreateAndModify {

	final static String filePath = "src/main/resources/testFile.txt";

	private FileOutputStream fileOutputStream;

	public CreateAndModify() {
		try {
			File file = new File(filePath);

			if (!file.exists()) {
				System.out.println("File is created");
				Files.createFile(Paths.get(filePath));
				FileWriter writer = new FileWriter(file);
				writer.write("Test Data\n");
				writer.close();

			} else {
				System.out.println("File already exists");
			}

			this.fileOutputStream = new FileOutputStream(file, true);
//			String testData = "Hello World\n";
//			fileOutputStream.write(testData.getBytes());
//			fileOutputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to create debug log file");
		}
	}

	public void readFromFile() throws IOException {
		File readFile = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(readFile);
		int r = 0;
		StringBuilder stringBuilder = new StringBuilder();
		while ((r = fileInputStream.read()) != -1) {
			stringBuilder.append((char) r);
		}
		String inputFile = stringBuilder.toString();
		System.out.println(inputFile);
	}
	
	public void modifyFile(String modifyFile) {
		try {
            byte[] message = String.format("[%s] EDIT %s\n", new Date(), modifyFile).getBytes();
            fileOutputStream.write(message);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to write to debug log. Message: " + e.getMessage());
        }
	}

}
