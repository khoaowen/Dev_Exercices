package robot.model;

public enum HeadingPosition {
	E,
	W,
	N,
	S;
	
	public static HeadingPosition turnLeft(HeadingPosition currentHeading) {
		switch (currentHeading) {
		case E:
			return HeadingPosition.N;
		case N:
			return HeadingPosition.W;
		case S:
			return HeadingPosition.E;
		case W:
			return HeadingPosition.S;
		default:
			throw new RuntimeException("Heading position is not handled: " + currentHeading);
		}
	}
	
	public static HeadingPosition turnRight(HeadingPosition currentHeading) {
		switch (currentHeading) {
		case E:
			return HeadingPosition.S;
		case N:
			return HeadingPosition.E;
		case S:
			return HeadingPosition.W;
		case W:
			return HeadingPosition.N;
		default:
			throw new RuntimeException("Heading position is not handled: " + currentHeading);
		}
	}
	
}
