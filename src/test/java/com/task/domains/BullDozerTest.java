package com.task.domains;

import static org.junit.jupiter.api.Assertions.*;

import com.task.dto.ExpenseReport;
import com.task.utils.GridUtils;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BullDozerTest {
  BullDozer dozer;
  BullDozerStats stats;

  @BeforeEach
  public void setup() {
    char[][] grid = {
        {'o', 'o', 'o', 'o'},
        {'o', 'r', 'T', 'o'},
        {'o', 't', 'o', 'o'}
    };
    stats = new BullDozerStats();
    dozer = new BullDozer(grid, Direction.EAST, new Position(0, -1), stats);
  }

  @Test
  void basic_functionality_check() throws IOException {
    dozer.advance(2);   // FUEL 1 + 1
    dozer.right();
    dozer.advance(2);   // FUEL 2 + 2
    dozer.left();
    dozer.advance(1);   // FUEL 1

    ExpenseReport report = stats.expenseResponse();

    assertEquals(5, report.communicationOverhead());
    assertEquals(7, report.fuelUsage());
    assertEquals(6, report.unclearedSquares());
    assertEquals(18, report.unclearedSquaresCost());
  }

  @Test
  void visited_object_cleared() {
    dozer.advance(2);      // Fuel   2
    dozer.right();
    dozer.advance(2); // Fuel 2 + 2
    dozer.right();
    dozer.right();
    dozer.advance(2); // Fuel 1 + 1

    ExpenseReport report = stats.expenseResponse();
    assertEquals(8, report.fuelUsage());
    assertEquals(7, report.unclearedSquares());
  }
}