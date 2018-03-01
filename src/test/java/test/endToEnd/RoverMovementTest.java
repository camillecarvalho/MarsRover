package test.endToEnd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import marsRover.Direction;
import marsRover.RoverMovement;
import marsRover.RoverPosition;

public class RoverMovementTest {

	RoverMovement roverMoviment = new RoverMovement();
	
	@Test
	public void canMoveToNorth() {
		RoverPosition roverPosition = new RoverPosition(0, 0, 'N');
		
		roverMoviment.move(roverPosition, 'M');
		
		assertEquals(roverPosition.getX(), 0);
		assertEquals(roverPosition.getY(), 1);
		assertEquals(roverPosition.getDirection(), Direction.NORTH);
	}
	
	@Test
	public void canMoveToSouth() {
		RoverPosition roverPosition = new RoverPosition(2, 2, 'S');
		
		roverMoviment.move(roverPosition, 'M');
		
		assertEquals(roverPosition.getX(), 2);
		assertEquals(roverPosition.getY(), 1);
		assertEquals(roverPosition.getDirection(), Direction.SOUTH);
	}
	
	@Test
	public void canMoveToEast() {
		RoverPosition roverPosition = new RoverPosition(2, 2, 'E');
		
		roverMoviment.move(roverPosition, 'M');
		
		assertEquals(roverPosition.getX(), 3);
		assertEquals(roverPosition.getY(), 2);
		assertEquals(roverPosition.getDirection(), Direction.EAST);
	}
	
	@Test
	public void canMoveToWeast() {
		RoverPosition roverPosition = new RoverPosition(2, 2, 'W');
		
		roverMoviment.move(roverPosition, 'M');
		
		assertEquals(roverPosition.getX(), 1);
		assertEquals(roverPosition.getY(), 2);
		assertEquals(roverPosition.getDirection(), Direction.WEST);
	}
	
	@Test
	public void canTurnRightFromNorth() {
		RoverPosition roverPosition = new RoverPosition(2, 2, 'N');
		
		roverMoviment.move(roverPosition, 'R');
		
		assertEquals(roverPosition.getX(), 2);
		assertEquals(roverPosition.getY(), 2);
		assertEquals(Direction.WEST, roverPosition.getDirection());
	}
	
	@Test
	public void canTurnRightFromEast() {
		RoverPosition roverPosition = new RoverPosition(2, 2, 'W');
		
		roverMoviment.move(roverPosition, 'R');
		
		assertEquals(roverPosition.getX(), 2);
		assertEquals(roverPosition.getY(), 2);
		assertEquals(Direction.SOUTH, roverPosition.getDirection());
	}
	
	@Test
	public void canTurnRightFromSouth() {
		RoverPosition roverPosition = new RoverPosition(2, 2, 'S');
		
		roverMoviment.move(roverPosition, 'R');
		
		assertEquals(roverPosition.getX(), 2);
		assertEquals(roverPosition.getY(), 2);
		assertEquals(Direction.EAST, roverPosition.getDirection());
	}
	
	@Test
	public void canTurnRightFromWest() {
		RoverPosition roverPosition = new RoverPosition(2, 2, 'E');
		
		roverMoviment.move(roverPosition, 'R');
		
		assertEquals(roverPosition.getX(), 2);
		assertEquals(roverPosition.getY(), 2);
		assertEquals(Direction.NORTH, roverPosition.getDirection());
	}
	
	
}
