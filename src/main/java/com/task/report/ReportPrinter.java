package com.task.report;

import java.io.PrintStream;

public class ReportPrinter {
  private final PrintStream out;

  public ReportPrinter(PrintStream out) {
    this.out = out;
  }

  public void println(String str) {
    out.println(str);
  }

  public void print(String s) {
    out.print(s);
  }
}
