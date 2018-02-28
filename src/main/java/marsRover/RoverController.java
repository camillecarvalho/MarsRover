package marsRover;

public class RoverController {

	private FileListener fileListener;
	
	
	public RoverController(FileListener fileListener) {
		this.fileListener = fileListener;
	}
	
	public Point getPlateauUpperRightCoordinates() {
		String firstLine = fileListener.readFirstLine();
		
		return new Point(Character.getNumericValue(firstLine.charAt(0)), Character.getNumericValue(firstLine.charAt(2)));
	}

	public RoverPosition getRoverPosition() {
		String secondLine = fileListener.readSecondLine();
		
		return new RoverPosition(Character.getNumericValue(secondLine.charAt(0)), Character.getNumericValue(secondLine.charAt(2)), secondLine.charAt(4));
	}
	
	

}
