package robot.model;

import java.util.function.Consumer;

public enum Instruction {
	M((robot) -> {
		robot.setPosition(Plateau.moveForward(robot.getPosition(), robot.getHeading()));
	}), L((robot) -> {
		robot.setHeading(HeadingPosition.turnLeft(robot.getHeading()));
	}), R((robot) -> {
		robot.setHeading(HeadingPosition.turnRight(robot.getHeading()));
	});

	public Consumer<Rover> instr;

	private Instruction(Consumer<Rover> instr) {
		this.instr = instr;
	}

}