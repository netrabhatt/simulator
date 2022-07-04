package com.task.commands;

import static org.junit.jupiter.api.Assertions.*;

import com.task.domains.BullDozer;
import com.task.domains.BullDozerStats;
import com.task.domains.Direction;
import com.task.domains.Position;
import com.task.dto.ExpenseReport;
import org.junit.jupiter.api.Test;

class CommandRunnerTest {

  @Test
  void getIssuedCommands() {
    CommandRunner commandRunner = new CommandRunner();
    char[][] grid = {
        {'o', 'o', 'o', 'o'},
        {'o', 'r', 'T', 'o'},
        {'o', 't', 'o', 'o'}
    };
    BullDozerStats stats = new BullDozerStats();
    BullDozer dozer = new BullDozer(grid, Direction.EAST, new Position(0, -1), stats);

    commandRunner.runCommand(new AdvanceCommand(dozer, 4));    // fuel 4
    commandRunner.runCommand(new TurnRightCommand(dozer));
    commandRunner.runCommand(new AdvanceCommand(dozer, 1));    // fuel 1
    commandRunner.runCommand(new AdvanceCommand(dozer, 1));    // fuel 1
    commandRunner.runCommand(new TurnRightCommand(dozer));
    commandRunner.runCommand(new AdvanceCommand(dozer, 3));   // fuel 1 + 2 + 1
    commandRunner.runCommand(new TurnRightCommand(dozer));
    commandRunner.runCommand(new QuitCommand(commandRunner));

    assertEquals("advance 4, turn right, advance 1, advance 1, turn right, advance 3, turn right, quit", commandRunner.getIssuedCommands());
    ExpenseReport report = stats.expenseResponse();

    assertEquals(7, report.communicationOverhead());
    assertEquals(10, report.fuelUsage());
    assertEquals(1, report.paintDamages());
    assertEquals(2, report.unclearedSquares());
  }
}