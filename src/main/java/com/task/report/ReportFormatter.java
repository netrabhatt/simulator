package com.task.report;

import static com.task.utils.StringUtils.lPad;
import static com.task.utils.StringUtils.rPad;

import com.task.dto.ExpenseReport;

public class ReportFormatter {
  private static final String ENDL = "\n";
  private static final String ENDL2 = ENDL + ENDL;
  
  public String format(ExpenseReport expense, String issuedCommands) {
    return "These are the commands you issued:" + ENDL2
        + issuedCommands
        + ENDL
        + "\nThe costs for this land clearing operation were:" + ENDL2
        + rPad("Item", 40)  + lPad("Quantity", 10) + lPad("Cost", 10) + ENDL
        + rPad("communication overhead", 40) + lPad(expense.communicationOverhead(), 10) + lPad(expense.communicationOverheadCost(), 10) + ENDL
        + rPad("fuel usage", 40) + lPad(expense.fuelUsage(), 10) + lPad(expense.fuelCost(), 10) + ENDL
        + rPad("uncleared squares", 40) + lPad(expense.unclearedSquares(), 10) + lPad(expense.unclearedSquaresCost(), 10) + ENDL
        + rPad("destruction of protected tree", 40) + lPad(expense.protectedTreeDestroyed(), 10) + lPad(expense.protectedTreeDestructionCost(), 10) + ENDL
        + rPad("paint damage to bulldozer", 40) + lPad(expense.paintDamages(), 10) + lPad(expense.paintDamageCost(), 10) + ENDL
        + "----"  + ENDL
        + rPad("Total", 50) + lPad(expense.totalCost(), 10) + ENDL2
        + "Thankyou for using the Aconex site clearing simulator.";
  }
}
