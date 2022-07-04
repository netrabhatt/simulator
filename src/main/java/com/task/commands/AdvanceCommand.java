package com.task.commands;

import com.task.domains.BullDozer;

public class AdvanceCommand implements Command {
  private final BullDozer bullDozer;
  private final int steps;
  
  public AdvanceCommand(BullDozer bullDozer, int steps) {
    this.bullDozer = bullDozer;
    this.steps = steps;
  }

  @Override
  public void execute() {
    bullDozer.advance(steps);
  }

  @Override
  public String name() {
    return "advance " + steps;
  }
}
