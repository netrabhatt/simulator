package com.task;

import com.task.commands.AdvanceCommand;
import com.task.commands.Command;
import com.task.commands.CommandRunner;
import com.task.commands.QuitCommand;
import com.task.commands.TurnLeftCommand;
import com.task.commands.TurnRightCommand;
import com.task.domains.BullDozer;
import com.task.domains.BullDozerStats;
import com.task.domains.Direction;
import com.task.config.LineItemCostsPropertyLoader;
import com.task.domains.Position;
import com.task.exceptions.SimulationTerminationException;
import com.task.report.ReportFormatter;
import com.task.report.ReportPrinter;
import com.task.utils.GridUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Application {
  static {
    try {
      Class.forName(LineItemCostsPropertyLoader.class.getName());
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) throws IOException {
    char[][] grid = GridUtils.createGrid(args[0]);
    printWelcomeScreen(grid);

    ReportFormatter reportFormatter = new ReportFormatter();
    ReportPrinter printer = new ReportPrinter(System.out);

    BullDozerStats dozerStats = new BullDozerStats();
    BullDozer bullDozer = new BullDozer(grid, Direction.EAST, new Position(0, -1), dozerStats);

    CommandRunner commandRunner = new CommandRunner();
    try(Scanner scanner = new Scanner(new InputStreamReader(System.in));
        commandRunner) {
      String line = null;
      do {
        System.out.print("(l)eft, (r)ight, (a)dvance <n>, (q)uit: ");
        line = scanner.nextLine();
        Command command = prepareCommand(commandRunner, bullDozer, line);
        commandRunner.runCommand(command);
      } while(!line.startsWith("q"));

      printer.print("\nThe simulation has ended at your request.");
    } catch (SimulationTerminationException e) {
      printer.print("\nThe simulation has ended, " + e.getMessage());
    } finally {
      printer.println(reportFormatter.format(dozerStats.expenseResponse(), commandRunner.getIssuedCommands()));
    }
  }

  private static Command prepareCommand(CommandRunner commandRunner, BullDozer bullDozer, String line) {
    String[] params = line.split(" ");
    return switch (params[0]) {
      case "a", "advance" -> new AdvanceCommand(bullDozer, Integer.parseInt(params[1]));
      case "l", "left" -> new TurnLeftCommand(bullDozer);
      case "r", "right" -> new TurnRightCommand(bullDozer);
      case "q", "quit" -> new QuitCommand(commandRunner);
      default -> throw new SimulationTerminationException("Unknown Command! ");
    };
  }

  private static void printWelcomeScreen(char[][] grid) {
    System.out.println("Welcome to the Aconex Site clearing simulator. This is a map of the site: \n");
    GridUtils.printGrid(grid);
    System.out.println("\nThe bulldozer is currently located at the Northern edge of the site, "
        + "immediately to the West of the site, and facing East.");
  }
}
