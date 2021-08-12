package programmers.levelTwo.Solutions20210812;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SolutionsTwo {

  ArrayList<String> orderList = new ArrayList<>();

  public String[] solution(String[] orders, int[] course) {
    ArrayList<String> menuList = new ArrayList<>();
    for (int n : course) {
      for (String order : orders) {
        if (order.length() >= n) {
          boolean[] visited = new boolean[order.length()];
          char[] orderChars = order.toCharArray();
          Arrays.sort(orderChars);
          combination(orderChars, visited, 0, order.length(), n);
        }
      }
      if (orderList.isEmpty()) {
        continue;
      }
      Collections.sort(orderList);
      ArrayList<String> courseList = new ArrayList<>();
      int count = 1;
      int max = 0;
      String s = orderList.get(0);
      System.out.println(s);
      for (int i = 1; i < orderList.size(); i++) {
        String ss = orderList.get(i);
        System.out.println(ss);
        if (ss.equals(s)) {
          count++;
        } else {
          if (count > 1 && courseList.isEmpty()) {
            courseList.add(s);
            max = count;
          } else if (count > 1 && count > max) {
            courseList.clear();
            courseList.add(s);
            max = count;
          } else if (count > 1 && count == max) {
            courseList.add(s);
          }
          s = ss;
          count = 1;
        }
      }

      if (count > 1) {
        if (courseList.isEmpty()) {
          courseList.add(s);
        } else if (count > max) {
          courseList.clear();
          courseList.add(s);
        } else if (count == max) {
          courseList.add(s);
        }
      }
      menuList.addAll(courseList);
      orderList.clear();
    }
    String[] answer = new String[menuList.size()];
    for (int i = 0; i < menuList.size(); i++) {
      answer[i] = menuList.get(i);
    }
    Arrays.sort(answer);
    return answer;
  }

  void combination(char[] s, boolean[] visited, int depth, int n, int r) {
    if (r == 0) {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (visited[i]) {
          builder.append(s[i]);
        }
      }
      orderList.add(builder.toString());
      return;
    }

    if (depth == n) {
      return;
    }

    visited[depth] = true;
    combination(s, visited, depth + 1, n, r - 1);

    visited[depth] = false;
    combination(s, visited, depth + 1, n, r);
  }
}