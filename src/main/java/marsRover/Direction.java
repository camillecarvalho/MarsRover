package marsRover;

public enum Direction {
	NORTH ('N', 0, 1),
	SOUTH ('S', 0, -1),
	EAST ('E', 1, 0),
	WEST ('W', -1, 0);

	public final char correspondingCharacter;
	public final int changeInXWhenMove;
	public final int changeInYWhenMove;

	Direction(char correspondingCharacter, int x, int y){
		this.correspondingCharacter = correspondingCharacter;
		this.changeInXWhenMove = x;
		this.changeInYWhenMove = y;
	}

	public char getCorrespondingCharacter() {
		return correspondingCharacter;
	}

	public int getX() {
		return changeInXWhenMove;
	}

	public int getY() {
		return changeInYWhenMove;
	}

	public static Direction getDirection(char correspondingCharacter) {
		for (Direction direction : Direction.values()) {
			if (direction.correspondingCharacter == correspondingCharacter) 
				return direction;
		}
		return null;
	}
}
