package com.task.utils;

import java.util.stream.IntStream;

public class StringUtils {
  public static String rPad(String str, int len) {
    if (str.length() >= len) {
      return str;
    }

    StringBuilder sb = new StringBuilder(str);
    IntStream.range(str.length(), len).forEach(i -> sb.append(' '));
    return sb.toString();
  }

  public static String lPad(int n, int len) {
    int length = String.valueOf(n).length();
    if(length >= len) {
      return n + "";
    }
    StringBuilder sb = new StringBuilder();
    IntStream.range(0, len - length).forEach(i -> sb.append(' '));
    sb.append(n);
    return sb.toString();
  }

  public static String lPad(String str, int len) {
    int length = str.length();
    if(length >= len) {
      return str;
    }
    StringBuilder sb = new StringBuilder();
    IntStream.range(0, len - length).forEach(i -> sb.append(' '));
    sb.append(str);
    return sb.toString();
  }
}
