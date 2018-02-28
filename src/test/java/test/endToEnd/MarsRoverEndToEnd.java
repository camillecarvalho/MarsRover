package test.endToEnd;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import marsRover.Direction;
import marsRover.FileListener;
import marsRover.Point;
import marsRover.RoverController;
import marsRover.RoverPosition;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.hamcrest.Matcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Expectation;
import org.jmock.api.Invocation;

public class MarsRoverEndToEnd {

	private final Mockery context = new Mockery();
	private final FileListener fileListener = context.mock(FileListener.class);
	private final String inputFileName = "input.txt";
	private final RoverController roverController = new RoverController(fileListener);
	private BufferedReader inputData;
	
	@Test
	public void readUpperRightPlateouCoordinates() throws Exception {

		String inputFileContent = String.join("\n"
				, "5 5");

		InputStream inputStreamFileContent = new ByteArrayInputStream(inputFileContent.getBytes());

		inputData = new BufferedReader(new InputStreamReader(inputStreamFileContent));

		context.checking(new Expectations() {{            
			atLeast(1).of(fileListener).readFile(inputFileName); will(returnValue(inputData));
		}});

		roverController.extractMarsRoverDataFromInput(inputFileName);

		Point upperRightPlateouCoordinates = roverController.getPlateauUpperRightCoordinates();

		assertEquals(5, upperRightPlateouCoordinates.getX());
		assertEquals(5, upperRightPlateouCoordinates.getY());
	}

	@Test
	public void readRoverPosition() throws Exception {

		String inputFileContent = String.join("\n"
				, "5 5"
				, "0 1 N");

		InputStream inputStreamFileContent = new ByteArrayInputStream(inputFileContent.getBytes());

		inputData = new BufferedReader(new InputStreamReader(inputStreamFileContent));

		context.checking(new Expectations() {{            
			atLeast(1).of(fileListener).readFile(inputFileName); will(returnValue(inputData));
		}});

		roverController.extractMarsRoverDataFromInput(inputFileName);

		RoverPosition roverPosition = roverController.getRoverPosition();

		assertEquals(0, roverPosition.getX());
		assertEquals(1, roverPosition.getY());
		assertEquals(Direction.NORTH, roverPosition.getDirection());
	}

	@Test
	public void roverCanMoveForward() throws Exception {

		String inputFileContent = String.join("\n"
				, "5 5"
				, "0 1 N"
				, "M");

		InputStream inputStreamFileContent = new ByteArrayInputStream(inputFileContent.getBytes());

		inputData = new BufferedReader(new InputStreamReader(inputStreamFileContent));

		context.checking(new Expectations() {{            
			atLeast(1).of(fileListener).readFile(inputFileName); will(returnValue(inputData));
		}});

		roverController.extractMarsRoverDataFromInput(inputFileName);

		roverController.performMoviment();

		RoverPosition roverPosition = roverController.getRoverPosition();

		assertEquals(0, roverPosition.getX());
		assertEquals(2, roverPosition.getY());
		assertEquals(Direction.NORTH, roverPosition.getDirection());

	}
	
	@Test
	public void roverCanTurnDirectionToRight() throws Exception {

		String inputFileContent = String.join("\n"
				, "5 5"
				, "0 1 N"
				, "R");

		InputStream inputStreamFileContent = new ByteArrayInputStream(inputFileContent.getBytes());

		inputData = new BufferedReader(new InputStreamReader(inputStreamFileContent));

		context.checking(new Expectations() {{            
			atLeast(1).of(fileListener).readFile(inputFileName); will(returnValue(inputData));
		}});

		roverController.extractMarsRoverDataFromInput(inputFileName);

		roverController.performMoviment();

		RoverPosition roverPosition = roverController.getRoverPosition();

		assertEquals(0, roverPosition.getX());
		assertEquals(1, roverPosition.getY());
		assertEquals(Direction.WEST, roverPosition.getDirection());

	}
	

}
