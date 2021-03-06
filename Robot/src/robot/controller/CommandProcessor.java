package robot.controller;

import java.util.List;
import java.util.stream.Collectors;

import robot.model.HeadingPosition;
import robot.model.Instruction;
import robot.model.Plateau;
import robot.model.Position;
import robot.model.Rover;

public class CommandProcessor {

	private static final String REGEX_PLATEAU_LINE = "\\d+ \\d+";
	private static final String REGEX_COMMAND_LINE = "[LRM]+";
	private static final String REGEX_ROVER_LINE = "\\d+ \\d+ [NSEW]";
	private static final String INVALID_COMMAND_LINE_MESSAGE = "Command line must be composed only by 'L','R' and 'M'. Example (without brackets) : [LMLMLMLMM]";
	private static final String INVALID_ROVER_LINE_MESSAGE = "Command line must be of format (without brackets): [1 2 N]";
	private static final String INVALID_PLATEAU_LINE_MESSAGE = "Plateau line must be of format (without brackets): [1 2]";

	public static Plateau parsePlateau(String commandLine) {
		if (!commandLine.matches(REGEX_PLATEAU_LINE)) {
			throw new RuntimeException(INVALID_PLATEAU_LINE_MESSAGE);
		}
		String[] plateauSize = commandLine.split(" ");
		return new Plateau(Integer.parseInt(plateauSize[0]), Integer.parseInt(plateauSize[1]));
	}

	public static Rover parseRover(String commandLine) {
		checkValidRoverCommmand(commandLine);
		String[] plateauSize = commandLine.split(" ");
		return new Rover(Position.of(Integer.parseInt(plateauSize[0]), Integer.parseInt(plateauSize[1])),
				HeadingPosition.valueOf(plateauSize[2]));
	}

	private static void checkValidRoverCommmand(String commandLine) {
		if (!commandLine.matches(REGEX_ROVER_LINE)) {
			throw new RuntimeException(INVALID_ROVER_LINE_MESSAGE);
		}
	}

	public static void parseCommand(Plateau plateau, Rover rover, String commandLine) {
		checkValid(commandLine);

		play(plateau, rover, parse(commandLine));
	}

	private static void checkValid(String commandLine) {
		if (!commandLine.matches(REGEX_COMMAND_LINE)) {
			throw new RuntimeException(INVALID_COMMAND_LINE_MESSAGE);
		}
	}

	private static void play(Plateau plateau, Rover rover, List<Instruction> instructions) {
		for (Instruction ins : instructions) {
			ins.instr.accept(rover);
		}
	}

	private static List<Instruction> parse(String commandLine) {
		return commandLine.chars().mapToObj(c -> String.valueOf((char) c)).map(Instruction::valueOf)
				.collect(Collectors.toList());
	}
}
