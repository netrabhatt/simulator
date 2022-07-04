package com.task.domains;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  void left() {
    assertEquals(Direction.NORTH, Direction.EAST.left());
    assertEquals(Direction.WEST, Direction.NORTH.left());
    assertEquals(Direction.SOUTH, Direction.WEST.left());
    assertEquals(Direction.EAST, Direction.SOUTH.left());
  }

  @Test
  void right() {
    assertEquals(Direction.SOUTH, Direction.EAST.right());
    assertEquals(Direction.WEST, Direction.SOUTH.right());
    assertEquals(Direction.NORTH, Direction.WEST.right());
    assertEquals(Direction.EAST, Direction.NORTH.right());
  }
}
