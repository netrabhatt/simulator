package com.task.commands;

import static java.util.stream.Collectors.joining;

import com.task.exceptions.SimulationTerminationException;
import java.util.ArrayList;
import java.util.List;

public final class CommandRunner implements AutoCloseable {
  private final List<Command> commands = new ArrayList<>();
  private boolean simulationEnd = false;
  
  public void runCommand(Command command) {
    if(simulationEnd)
      throw new SimulationTerminationException("Simulation ended! commands are no longer accepted!");

    commands.add(command);
    command.execute();
  }

  public String getIssuedCommands() {
    return commands.stream().map(Command::name).collect(joining(", "));
  }

  @Override
  public void close() {
    if(!simulationEnd)
      simulationEnd = true;
  }
}
