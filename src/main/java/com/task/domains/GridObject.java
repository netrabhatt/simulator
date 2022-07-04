package com.task.domains;

public enum GridObject {
  OPEN('o', 1), TREE('t', 2), ROCK('r', 2), PROTECTED_TREE('T', 1);

  private final char symbol;
  private final int fuelUsage;

  GridObject(char symbol, int fuelUsage) {
    this.symbol = symbol;
    this.fuelUsage = fuelUsage;
  }

  public int fuelUsage() {
    return this.fuelUsage;
  }

  public boolean isTree() {
    return this == TREE;
  }

  public static GridObject resolveObject(char c) {
    return switch (c) {
      case 'o' -> OPEN;
      case 'r' -> ROCK;
      case 't' -> TREE;
      case 'T' -> PROTECTED_TREE;
      default -> throw new IllegalArgumentException("No GridObject mapped with given character ['" + c + "']");
    };
  }

  public char symbol() {
    return this.symbol;
  }

  public boolean isProtectedTree() {
    return this == PROTECTED_TREE;
  }
}
