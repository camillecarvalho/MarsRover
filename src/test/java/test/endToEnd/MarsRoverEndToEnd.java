package test.endToEnd;
import org.junit.Test;

import marsRover.FileListener;
import marsRover.Point;
import marsRover.RoverController;
import marsRover.RoverPosition;

import static org.junit.Assert.assertEquals;

import org.hamcrest.Matcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Expectation;
import org.jmock.api.Invocation;

public class MarsRoverEndToEnd {
	
	private final Mockery context = new Mockery();
	private final FileListener fileListener = context.mock(FileListener.class);
	private final RoverController roverController = new RoverController(fileListener);
	
    
	@Test
	public void readUpperRightPlateouCoordinates() {
		
		context.checking(new Expectations() {{            
            atLeast(1).of(fileListener).readFirstLine(); will(returnValue("5 5"));
        }});
		
		Point upperRightPlateouCoordinates = roverController.getPlateauUpperRightCoordinates();
		
		assertEquals(5, upperRightPlateouCoordinates.getX());
		assertEquals(5, upperRightPlateouCoordinates.getY());
	}
	
	@Test
	public void readRoverPosition() {
		
		context.checking(new Expectations() {{            
            atLeast(1).of(fileListener).readSecondLine(); will(returnValue("0 1 N"));
        }});
		
		RoverPosition roverPosition = roverController.getRoverPosition();
		
		assertEquals(0, roverPosition.getX());
		assertEquals(1, roverPosition.getY());
		assertEquals('N', roverPosition.getDirection());
	}
	
	
	
	
}
