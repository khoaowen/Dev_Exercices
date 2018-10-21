package robot.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Plateau {

	private static final String POSITION_OUT_OF_SCOPE_ERROR_MESSAGE = "Position is out of scope. Robot is not moved!";
	private static int totalX;
	private static int totalY;

	public Plateau(int totalX, int totalY) {
		Plateau.totalX = totalX;
		Plateau.totalY = totalY;
	}

	public static int getTotalX() {
		return totalX;
	}

	public static int getTotalY() {
		return totalY;
	}

	public static Position moveForward(Position currentPosition, HeadingPosition currentHeading) {
		switch (currentHeading) {
		case E:
			if (currentPosition.x() + 1 > getTotalX()) {
				Logger.getLogger(Rover.class.getName()).log(Level.WARNING, POSITION_OUT_OF_SCOPE_ERROR_MESSAGE);
				return currentPosition;
			}
			return Position.of(currentPosition.x() + 1, currentPosition.y());
		case N:
			if (currentPosition.y() + 1 > getTotalY()) {
				Logger.getLogger(Rover.class.getName()).log(Level.WARNING, POSITION_OUT_OF_SCOPE_ERROR_MESSAGE);
				return currentPosition;
			}
			return Position.of(currentPosition.x(), currentPosition.y() + 1);
		case S:
			if (currentPosition.y() - 1 < 0) {
				Logger.getLogger(Rover.class.getName()).log(Level.WARNING, POSITION_OUT_OF_SCOPE_ERROR_MESSAGE);
				return currentPosition;
			}
			return Position.of(currentPosition.x(), currentPosition.y() - 1);
		case W:
			if (currentPosition.x() - 1 < 0) {
				Logger.getLogger(Rover.class.getName()).log(Level.WARNING, POSITION_OUT_OF_SCOPE_ERROR_MESSAGE);
				return currentPosition;
			}
			return Position.of(currentPosition.x() - 1, currentPosition.y());
		default:
			throw new RuntimeException("Heading position is not handled: " + currentHeading);
		}
	}
}
