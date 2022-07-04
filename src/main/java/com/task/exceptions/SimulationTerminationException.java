package com.task.exceptions;

public class SimulationTerminationException extends IllegalStateException {
  public SimulationTerminationException(String msg) {
    super(msg);
  }
}
