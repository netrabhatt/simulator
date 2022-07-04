package com.task.commands;

public class QuitCommand implements Command {
  private final CommandRunner commandRunner;

  public QuitCommand(CommandRunner commandRunner) {
    this.commandRunner = commandRunner;
  }

  @Override
  public void execute() {
    commandRunner.close();
  }

  @Override
  public String name() {
    return "quit";
  }
}
