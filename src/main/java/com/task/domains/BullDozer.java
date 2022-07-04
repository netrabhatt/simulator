package com.task.domains;

import com.task.exceptions.SimulationTerminationException;

public class BullDozer {
  private final char[][] grid;
  private final boolean[][] visited;
  private final Position currentPosition;
  private final BullDozerStats dozerStats;
  private Direction currentDirection;

  public BullDozer(char[][] grid, Direction startingDirection, Position startPosition, BullDozerStats stats) {
    this.grid = grid;
    this.currentDirection = startingDirection;
    this.currentPosition = startPosition;
    this.visited = new boolean[grid.length][grid[0].length];
    this.dozerStats = stats;

    initDozerStats();
  }

  private void initDozerStats() {
    dozerStats.setTotalCells(grid.length * grid[0].length);

    int protectedTrees = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == GridObject.PROTECTED_TREE.symbol()) {
          protectedTrees++;
        }
      }
    }
    dozerStats.setProtectedTrees(protectedTrees);
  }

  public synchronized void left() {
    dozerStats.incrementCommOverhead();
    currentDirection = currentDirection.left();
  }

  public synchronized void right() {
    dozerStats.incrementCommOverhead();
    currentDirection = currentDirection.right();
  }

  public synchronized void advance(int steps) {
    dozerStats.incrementCommOverhead();
    for (int currStep = 0; currStep < steps; currStep++) {
      currentPosition.moveOneStep(currentDirection);
      GridObject currentObject = getCurrentObject();
      boolean isAdvancing = currStep < steps - 1;
      updateDozerStats(isAdvancing, currentObject); 
      clearCurrentCell();     
    }
  }
  private GridObject getCurrentObject() {
    requireBullDozerWithinBoundary();
    return requireNoProtectedTreeVisit(
      GridObject.resolveObject(grid[currentPosition.getRow()][currentPosition.getCol()]));
  }

  private void updateDozerStats(boolean isAdvancing, GridObject currentObject) {
    if (!visited[currentPosition.getRow()][currentPosition.getCol()]) {
      visited[currentPosition.getRow()][currentPosition.getCol()] = true;
      dozerStats.incrementVisitedSquares();
    }
    dozerStats.updateFuelUsage(currentObject.fuelUsage());
    if (isAdvancing && currentObject.isTree()) {
      dozerStats.incrementPaintDamages();
    }
  }

  private void clearCurrentCell() {
    grid[currentPosition.getRow()][currentPosition.getCol()] = GridObject.OPEN.symbol();
  }

  private void requireBullDozerWithinBoundary() {
    if (currentPosition.getRow() >= grid.length
        || currentPosition.getCol() >= grid[0].length
        || currentPosition.getRow() < 0
        || currentPosition.getCol() < 0) {
      throw new SimulationTerminationException("Bulldozer is outside the grid!");
    }
  }

  private GridObject requireNoProtectedTreeVisit(GridObject currentObject) {
    if (currentObject.isProtectedTree()) {
      dozerStats.incrementProtectedTreesDestroyed();
      throw new SimulationTerminationException("Protected Tree destructed!");
    }
    return currentObject;
  }
}
