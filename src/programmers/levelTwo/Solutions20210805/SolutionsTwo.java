package programmers.levelTwo.Solutions20210805;

import java.util.ArrayList;

public class SolutionsTwo {

  long max = 0;
  ArrayList<Character> signs = new ArrayList<>();
  ArrayList<Long> nums = new ArrayList<>();

  public long solution(String expression) {
    char[] prioritySign = new char[]{'+', '-', '*'};
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c >= '0' && c <= '9') {
        s.append(c);
      } else {
        signs.add(c);
        nums.add(Long.parseLong(s.toString()));
        s = new StringBuilder();
      }
    }
    nums.add(Long.parseLong(s.toString()));

    permutation(prioritySign, 0);

    return max;
  }

  void calculate(char[] prioritySign) {
    ArrayList<Character> signs = new ArrayList<>(this.signs);
    ArrayList<Long> nums = new ArrayList<>(this.nums);

    for (char sign : prioritySign) {
      int i = 0;
      while (signs.contains(sign)) {
        if (signs.get(i) == sign) {
          long num1 = nums.get(i);
          long num2 = nums.get(i + 1);
          nums.remove(i);
          nums.remove(i);
          if (signs.get(i) == '+') {
            nums.add(i, num1 + num2);
          } else if (signs.get(i) == '-') {
            nums.add(i, num1 - num2);
          } else {
            nums.add(i, num1 * num2);
          }
          signs.remove(i);
        } else {
          i++;
        }
      }
    }

    long value = Math.abs(nums.get(0));
    if (value > max) {
      max = value;
    }
  }

  void permutation(char[] prioritySign, int index) {
    if (index == prioritySign.length) {
      calculate(prioritySign);
    } else {
      permutation(prioritySign, index + 1);
      for (int i = index + 1; i < prioritySign.length; i++) {
        swap(prioritySign, index, i);
        permutation(prioritySign, index + 1);
        swap(prioritySign, i, index);
      }
    }
  }

  void swap(char[] prioritySign, int pos1, int pos2) {
    char tmp = prioritySign[pos1];
    prioritySign[pos1] = prioritySign[pos2];
    prioritySign[pos2] = tmp;
  }
}