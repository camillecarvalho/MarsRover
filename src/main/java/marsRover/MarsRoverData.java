package marsRover;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MarsRoverData {

	private Point upperRightCoordinates;
	private List<Rover> rovers = new ArrayList<Rover>();
	
	public MarsRoverData(BufferedReader inputData) throws IOException {
		extractMarsRoverDataFromInput (inputData);
	}

	public Point getUpperRightCoordinates() {
		return upperRightCoordinates;
	}

	public List<Rover> getRovers() {
		return rovers;
	}

	private void extractMarsRoverDataFromInput (BufferedReader inputData) throws IOException {
		upperRightCoordinates = getUpperRightCoordinates(inputData.readLine());
		String roverPositionLine;
		while ((roverPositionLine = inputData.readLine()) != null) {
			RoverPosition roverPosition = getRoverPosition(roverPositionLine);
			String roverMovimentLine = inputData.readLine();
			rovers.add(new Rover(roverPosition, getLineForRoverMovementCommands(roverMovimentLine)));
		}
	}
	
	private String getLineForRoverMovementCommands(String roverMovimentLine) {
		if (roverMovimentLine != null)
			return roverMovimentLine;
		else
			return "";
		
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
