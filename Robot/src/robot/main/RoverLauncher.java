package robot.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import robot.controller.CommandProcessor;
import robot.controller.Plateau;
import robot.model.Rover;

public class RoverLauncher {

	public static void main(String[] args) {
		if (args.length == 0 ) {
			throw new RuntimeException("Must be launched with an argument indicating the file name which contains the list of commands (ex: input.txt)");
		}
		
		try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
			stream.forEach(new Consumer<String>() {
				int i = 0;
				Plateau plateau;
				Stack<Rover> rovers = new Stack<>();
				@Override
				public void accept(String line) {
					if (i == 0) {
						plateau = CommandProcessor.parsePlateau(line);
					} else if (i > 0) {
						if ((i-1)%2 == 0) {
							// add robots
							rovers.push(CommandProcessor.parseRover(line));
						} else {
							// add commands
							Rover rover = rovers.pop();
							CommandProcessor.parseCommand(plateau, rover, line);
							// printout the final position of rover
							System.out.println(rover);
						}
					}
					i++;
				}
			});

		} catch (IOException e) {
			Logger.getLogger(RoverLauncher.class.getName()).log(Level.SEVERE,"Problem reading file : " + args[0]);
		}
	}

}
