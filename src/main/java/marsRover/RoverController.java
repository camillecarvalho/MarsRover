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

}
