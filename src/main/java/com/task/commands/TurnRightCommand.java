package com.task.commands;

import com.task.domains.BullDozer;

public class TurnRightCommand implements Command {
  private final BullDozer dozer;

  public TurnRightCommand(BullDozer dozer) {
    this.dozer = dozer;
  }

  @Override
  public String name() {
    return "turn right";
  }

  @Override
  public void execute(){
    dozer.right();
  }
}
