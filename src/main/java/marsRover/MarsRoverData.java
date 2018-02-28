package marsRover;

import java.io.BufferedReader;
import java.io.IOException;

public class MarsRoverData {

	private Point upperRightCoordinates;
	private RoverPosition roverPosition;
	private String roverMovimentCommands;

	public MarsRoverData(BufferedReader inputData) throws IOException {
		extractMarsRoverDataFromInput (inputData);
	}

	public Point getUpperRightCoordinates() {
		return upperRightCoordinates;
	}

	public RoverPosition getRoverPosition() {
		return roverPosition;
	}
	
	public String getRoverMovimentCommads() {
		return roverMovimentCommands;
	}

	private void extractMarsRoverDataFromInput (BufferedReader inputData) throws IOException {
		upperRightCoordinates = getUpperRightCoordinates(inputData.readLine());
		String line;
		while ((line = inputData.readLine()) != null) {
			roverPosition = getRoverPosition(line);
			String roverMovimentLine = inputData.readLine();
			if (roverMovimentLine != null)
				roverMovimentCommands = roverMovimentLine;
		}
	}

	private Point getUpperRightCoordinates (String upperRightCoodinates) {
		int x = Character.getNumericValue(upperRightCoodinates.charAt(0));
		int y = Character.getNumericValue(upperRightCoodinates.charAt(2));
		return new Point(x, y);
	}
	
	private RoverPosition getRoverPosition (String roverPosition) {
		int x = Character.getNumericValue(roverPosition.charAt(0));
		int y = Character.getNumericValue(roverPosition.charAt(2));
		char direction = roverPosition.charAt(4);
		return new RoverPosition(x, y, direction);
	}



}
