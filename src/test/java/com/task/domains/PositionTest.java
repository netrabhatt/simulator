package com.task.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  void moving_east_increments_column() {
    Position position = new Position(0 ,5);
    position.moveOneStep(Direction.EAST);

    assertEquals(0, position.getRow());
    assertEquals(6, position.getCol());
  }

  @Test
  void moving_south_increments_row() {
    Position position = new Position(0 ,5);
    position.moveOneStep(Direction.SOUTH);

    assertEquals(1, position.getRow());
    assertEquals(5, position.getCol());
  }

  @Test
  void moving_west_decrements_column() {
    Position position = new Position(0 ,5);
    position.moveOneStep(Direction.WEST);

    assertEquals(0, position.getRow());
    assertEquals(4, position.getCol());
  }

  @Test
  void moving_north_decrements_row() {
    Position position = new Position(4 ,5);
    position.moveOneStep(Direction.NORTH);

    assertEquals(3, position.getRow());
    assertEquals(5, position.getCol());
  }
}