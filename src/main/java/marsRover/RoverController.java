package marsRover;

import java.io.BufferedReader;
import java.util.List;

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

	public List<Rover> getRovers() {
		return marsRoverData.getRovers();
	}

	public void performMoviment() {
		RoverMovement roverMoviment = new RoverMovement();
		
		for (Rover rover: marsRoverData.getRovers()) {
			roverMoviment.move(rover.getRoverPosition(), rover.getRoverMovimentCommands());
				
		}
		
	}

}
