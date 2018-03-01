package marsRover;

public class RoverMovement{

	public void move(RoverPosition roverPosition, char command) {
		if (commandForMoveForward(command))
			moveForwardAccordingToRoverDirection(roverPosition);		
		else if (commandForTurnLeft(command))
			turnLeft(roverPosition);
		else if (commandForTurnRight(command))
			turnRight(roverPosition);
	}

	private Boolean commandForMoveForward(char command) {
		return command == 'M';
	}

	private Boolean commandForTurnLeft(char command) {
		return command == 'L';
	}
	
	private Boolean commandForTurnRight(char command) {
		return command == 'R';
	}

	private void moveForwardAccordingToRoverDirection(RoverPosition roverPosition) {
		roverPosition.moveX(roverPosition.getDirection().changeInXWhenMove);
		roverPosition.moveY(roverPosition.getDirection().changeInYWhenMove);
	}

	private void turnLeft(RoverPosition roverPosition) {
		switch (roverPosition.getDirection()) {
		case NORTH:
			roverPosition.setDirection(Direction.WEST);
			break;
		case WEST:
			roverPosition.setDirection(Direction.SOUTH);
			break;
		case SOUTH:
			roverPosition.setDirection(Direction.EAST);
			break;
		case EAST:
			roverPosition.setDirection(Direction.NORTH);
			break;
		}
	}
	
	private void turnRight(RoverPosition roverPosition) {
		switch (roverPosition.getDirection()) {
		case NORTH:
			roverPosition.setDirection(Direction.EAST);
			break;
		case EAST:
			roverPosition.setDirection(Direction.SOUTH);
			break;
		case SOUTH:
			roverPosition.setDirection(Direction.WEST);
			break;
		case WEST:
			roverPosition.setDirection(Direction.NORTH);
			break;
		}
	}

}