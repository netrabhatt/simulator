package com.task.config;

import java.io.IOException;
import java.util.Properties;

public class LineItemCostsPropertyLoader {
  private final LineItemCosts lineItemCosts;

  private static final LineItemCostsPropertyLoader instance = new LineItemCostsPropertyLoader();

  private LineItemCostsPropertyLoader() {
    try {
      Properties properties = new Properties();
      properties.load(getClass().getClassLoader().getResourceAsStream("cost.properties"));
      lineItemCosts =
          new LineItemCosts(
              Integer.parseInt(properties.get("communication-overhead.cost").toString()),
              Integer.parseInt(properties.get("fuel.cost").toString()),
              Integer.parseInt(properties.get("uncleared-square.cost").toString()),
              Integer.parseInt(properties.get("protected-tree-destruction.cost").toString()),
              Integer.parseInt(properties.get("paint-damage.cost").toString()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  
  public static LineItemCostsPropertyLoader getInstance() {
    return instance;
  }

  public LineItemCosts getLineItemCosts() {
    return lineItemCosts;
  }

  public static class LineItemCosts {
    private final int communicationOverheadCost;
    private final int fuelCost;
    private final int unclearedSquareCost;
    private final int protectedTreeDestructionCost;
    private final int paintDamageCost;

    private LineItemCosts(
        int communicationOverheadCost,
        int fuelCost,
        int unclearedSquareCost,
        int protectedTreeDestructionCost,
        int paintDamageCost) {
      this.communicationOverheadCost = communicationOverheadCost;
      this.fuelCost = fuelCost;
      this.unclearedSquareCost = unclearedSquareCost;
      this.protectedTreeDestructionCost = protectedTreeDestructionCost;
      this.paintDamageCost = paintDamageCost;
    }

    public int getCommunicationOverheadCost() {
      return communicationOverheadCost;
    }

    public int getFuelCost() {
      return fuelCost;
    }

    public int getUnclearedSquareCost() {
      return unclearedSquareCost;
    }

    public int getProtectedTreeDestructionCost() {
      return protectedTreeDestructionCost;
    }

    public int getPaintDamageCost() {
      return paintDamageCost;
    }
  }
}
