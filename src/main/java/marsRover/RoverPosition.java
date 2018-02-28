package marsRover;

public class RoverPosition extends Point {

	private char direction;
	
	public RoverPosition(int x, int y, char direction) {
		super(x, y);
		this.setDirection(direction);
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

}
