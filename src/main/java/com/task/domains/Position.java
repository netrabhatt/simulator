package com.task.domains;

public class Position {
  private int row;
  private int col;
  
  public Position(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public void moveOneStep(Direction direction) {
   switch (direction) {
     case EAST: col++; return;
     case WEST: col--; return;
     case NORTH: row--; return;
     case SOUTH: row++;
   }
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }
}
