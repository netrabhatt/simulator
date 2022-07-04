package com.task.domains;

import com.task.dto.ExpenseReport;

public class BullDozerStats {
  private int visitedSquares = 0;
  private int paintDamages = 0;
  private int protectedTrees = 0;
  private int communicationOverhead = 0;
  private int fuelUsage = 0;
  private int protectedTreesDestroyed = 0;
  private int totalCells = 0;

  void setTotalCells(int totalCells) {
    this.totalCells = totalCells;
  }

  void setProtectedTrees(int protectedTrees) {
    this.protectedTrees = protectedTrees;
  }
  
  void incrementCommOverhead() {
    communicationOverhead++;
  }

  void incrementPaintDamages() {
    paintDamages++;
  }

  void incrementVisitedSquares() {
    visitedSquares++;
  }

  void updateFuelUsage(int fuelUsage) {
    this.fuelUsage += fuelUsage;
  }

  private int unclearedSquares() {
    return totalCells - visitedSquares - protectedTrees;
  }

  void incrementProtectedTreesDestroyed() {
    protectedTreesDestroyed++;
  }

  public ExpenseReport expenseResponse() {
    return new ExpenseReport(
        communicationOverhead,
        fuelUsage,
        unclearedSquares(),
        protectedTreesDestroyed,
        paintDamages);
  }
}