package marsRover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RoverController {

	private FileListener fileListener;
	private MarsRoverData marsRoverData;
	
	
	public RoverController(FileListener fileListener) {
		this.fileListener = fileListener;
	}
	
	public void extractMarsRoverDataFromInput(String inputFileName) throws Exception {
		 BufferedReader inputData = fileListener.readFile(inputFileName);
		 marsRoverData = new MarsRoverData(inputData);
	}
	
	public Point getPlateauUpperRightCoordinates() {
		return marsRoverData.getUpperRightCoordinates();
	}

	public RoverPosition getRoverPosition() {
		return marsRoverData.getRoverPosition();
	}
	
	

}
