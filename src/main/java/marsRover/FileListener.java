package marsRover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public interface FileListener {

	
	public BufferedReader readFile(String inputFileName) throws FileNotFoundException;
	
	
}
