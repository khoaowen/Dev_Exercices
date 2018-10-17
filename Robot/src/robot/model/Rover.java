package robot.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import robot.controller.Plateau;
import robot.model.instruction.Instruction;

public class Rover {

	private static final String POSITION_OUT_OF_SCOPE_ERROR_MESSAGE = "Position is out of scope. Robot is not moved!";
	private int x;
	private int y;
	private HeadingPosition heading;
	private Instruction instruction;

	public Rover(int x, int y, HeadingPosition heading) {
		this.x = x;
		this.y = y;
		this.heading = heading;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setHeading(HeadingPosition heading) {
		this.heading = heading;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public HeadingPosition getHeading() {
		return heading;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + heading;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
	
	public void applyCommand(Plateau plateau) {
		instruction.applyCommand(this);
	}
	
	
	
	
	
	
	
	
	public void applyCommand(Plateau plateau, String command) {
		instruction.applyCommand(this);
		
		switch (command) {
		case "M":
			switch (this.heading) {
			case E:
				if (x + 1 > plateau.getTotalX()) {
					Logger.getLogger(Rover.class.getName()).log(Level.WARNING, POSITION_OUT_OF_SCOPE_ERROR_MESSAGE);
					return;
				}
				x++;
				break;
			case N:
				if (y + 1 > plateau.getTotalY()) {
					Logger.getLogger(Rover.class.getName()).log(Level.WARNING, POSITION_OUT_OF_SCOPE_ERROR_MESSAGE);
					return;
				}
				y++;
				break;
			case S:
				if (y- 1 < 0) {
					Logger.getLogger(Rover.class.getName()).log(Level.WARNING, POSITION_OUT_OF_SCOPE_ERROR_MESSAGE);
					return;
				}
				y--;
				break;
			case W:
				if (x- 1 < 0) {
					Logger.getLogger(Rover.class.getName()).log(Level.WARNING, POSITION_OUT_OF_SCOPE_ERROR_MESSAGE);
					return;
				}
				x--;
				break;
			}
			break;
		case "L":
			switch (this.heading) {
			case E:
				this.heading = HeadingPosition.N;
				break;
			case N:
				this.heading = HeadingPosition.W;
				break;
			case S:
				this.heading = HeadingPosition.E;
				break;
			case W:
				this.heading = HeadingPosition.S;
				break;
			}
			break;
		case "R":
			switch (this.heading) {
			case E:
				this.heading = HeadingPosition.S;
				break;
			case N:
				this.heading = HeadingPosition.E;
				break;
			case S:
				this.heading = HeadingPosition.W;
				break;
			case W:
				this.heading = HeadingPosition.N;
				break;
			}
			break;
		default:
			throw new RuntimeException("Command is not handled: " + command);
		}
	}

}
