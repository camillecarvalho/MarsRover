package marsRover;

public class RoverPosition extends Point {

	private Direction direction;

	public RoverPosition(int x, int y, char direction) {
		super(x, y);
		this.direction = Direction.getDirection(direction);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void moveX(int valueToMove) {
		x += valueToMove;
	}

	public void moveY(int valueToMove) {
		y += valueToMove;
	}

}
