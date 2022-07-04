package com.task.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GridUtils {

  public static char[][] createGrid(String f) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(f));

    int rows = lines.size();
    int cols = lines.get(0).length();

    char[][] grid = new char[rows][cols];

    for (int row = 0; row < lines.size(); row++) {
      char[] chars = lines.get(row).toCharArray();
      int col = 0;
      for (char c : chars) {
          grid[row][col++] = c;
      }
    }
    
    return grid;
  }

  public static void printGrid(char[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }
}
