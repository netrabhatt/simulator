package com.task.dto;

import com.task.config.LineItemCostsPropertyLoader;
public record ExpenseReport(int communicationOverhead,
                            int fuelUsage,
                            int unclearedSquares,
                            int protectedTreeDestroyed,
                            int paintDamages) {
  private static final LineItemCostsPropertyLoader.LineItemCosts lineItemCosts =
      LineItemCostsPropertyLoader.getInstance().getLineItemCosts();
  public int communicationOverheadCost() {
    return communicationOverhead * lineItemCosts.getCommunicationOverheadCost();
  }

  public int fuelCost() {
    return fuelUsage * lineItemCosts.getFuelCost();
  }

  public int unclearedSquaresCost() {
    return unclearedSquares * lineItemCosts.getUnclearedSquareCost();
  }

  public int protectedTreeDestructionCost() {
    return protectedTreeDestroyed * lineItemCosts.getProtectedTreeDestructionCost();
  }

  public int paintDamageCost() {
    return paintDamages * lineItemCosts.getPaintDamageCost();
  }

  public int totalCost() {
    return communicationOverheadCost()
        + fuelCost()
        + unclearedSquaresCost()
        + protectedTreeDestructionCost()
        + paintDamageCost();
  }
}