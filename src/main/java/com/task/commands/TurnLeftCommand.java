package com.task.commands;

import com.task.domains.BullDozer;

public class TurnLeftCommand implements Command {
  private final BullDozer dozer;

  public TurnLeftCommand(BullDozer dozer) {
    this.dozer = dozer;
  }

  @Override
  public String name() {
    return "turn left";
  }

  @Override
  public void execute() {
    dozer.left();
  }
}
