package robot.model;

public class Rover {

	private Position position;
	private HeadingPosition heading;

	public Rover(Position position, HeadingPosition heading) {
		this.position = position;
		this.heading = heading;
	}

	public void setHeading(HeadingPosition heading) {
		this.heading = heading;
	}

	public HeadingPosition getHeading() {
		return heading;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return this.position.x() + " " + this.position.y() + " " + heading;
	}

}
