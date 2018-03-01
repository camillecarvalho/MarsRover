package marsRover;

public class Rover {
	
	private RoverPosition roverPosition;
	private String roverMovimentCommands;
	
	public Rover(RoverPosition roverPosition, String roverMovimentCommands) {
		this.roverPosition = roverPosition;
		this.roverMovimentCommands = roverMovimentCommands;
	}

	public RoverPosition getRoverPosition() {
		return roverPosition;
	}

	public String getRoverMovimentCommands() {
		return roverMovimentCommands;
	}

	public void setRoverPosition(RoverPosition roverPosition) {
		this.roverPosition = roverPosition;
	}

	public void setRoverMovimentCommands(String roverMovimentCommands) {
		this.roverMovimentCommands = roverMovimentCommands;
	}
	
	
}
