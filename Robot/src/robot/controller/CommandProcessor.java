package robot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import robot.model.HeadingPosition;
import robot.model.Rover;
import robot.model.instruction.ForwardInstruction;
import robot.model.instruction.Instruction;

public class CommandProcessor {
	
	private static final String REGEX_PLATEAU_LINE = "\\d+ \\d+";
	private static final String REGEX_COMMAND_LINE = "[LRM]+";
	private static final String REGEX_ROVER_LINE= "\\d+ \\d+ [NSEW]";
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
		return new Rover(Integer.parseInt(plateauSize[0]), Integer.parseInt(plateauSize[1]),
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
			rover.setInstruction(ins);
			rover.applyCommand(plateau);
		}
	}
	
	enum Instruction {
		M((robot) -> {
			/**/
		}),
		L((robot) -> {
			robot.setHeading(HeadingPosition.turnLeft(robot.getHeading()));
		}),
		R((robot) -> {
			robot.setHeading(HeadingPosition.turnRight(robot.getHeading()));
		});
		
		Consumer<Rover> instr;

		private Instruction(Consumer<Rover> instr) {
			this.instr = instr;
		}
		
		
	}

	private static List<Instruction> parse(String commandLine) {
		return commandLine.chars()
		.mapToObj(c -> String.valueOf((char) c))
		.map(Instruction::valueOf)
		.collect(Collectors.toList());
	}
}
