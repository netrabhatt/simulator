package com.task.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridObjectTest {

  @Test
  void char_to_grid_object_mapping() {
    assertEquals(GridObject.OPEN, GridObject.resolveObject('o'));
    assertEquals(GridObject.ROCK, GridObject.resolveObject('r'));
    assertEquals(GridObject.TREE, GridObject.resolveObject('t'));
    assertEquals(GridObject.PROTECTED_TREE, GridObject.resolveObject('T'));
  }

  @Test
  void object_value_check() {
    assertTrue(GridObject.TREE.isTree());
    assertFalse(GridObject.OPEN.isTree());
    assertFalse(GridObject.ROCK.isTree());
    assertFalse(GridObject.PROTECTED_TREE.isTree());

    assertTrue(GridObject.PROTECTED_TREE.isProtectedTree());
    assertFalse(GridObject.TREE.isProtectedTree());
    assertFalse(GridObject.OPEN.isProtectedTree());
    assertFalse(GridObject.ROCK.isProtectedTree());
  }
  
}