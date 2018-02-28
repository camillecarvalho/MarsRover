package marsRover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileController implements FileListener{

	@Override
	public BufferedReader readFile(String inputFileName) throws FileNotFoundException {
		BufferedReader inputData = new BufferedReader(new FileReader(inputFileName));
		return inputData;
	}

}
