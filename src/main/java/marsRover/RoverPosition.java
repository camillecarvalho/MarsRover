package marsRover;

public class RoverPosition extends Point {

	private Direction direction;
	
	public RoverPosition(int x, int y, char direction) {
		super(x, y);
		this.setDirection(direction);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		if (direction == Direction.NORTH.getCorrespondingCharacter())
			this.direction = Direction.NORTH;
			
	}
	
	public void moveX(int valueToMove) {
		x += valueToMove;
	}
	
	public void moveY(int valueToMove) {
		y += valueToMove;
	}

}
