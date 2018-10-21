package robot.model;

public class Position {

	private int x;
	private int y;

	private Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Position of(int x, int y) {
		return new Position(x, y);
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
