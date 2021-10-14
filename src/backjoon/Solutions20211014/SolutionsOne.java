package backjoon.Solutions20211014;

import java.util.Scanner;

public class SolutionsOne {

  int max = 0;

  public static void main(String[] args) {
    SolutionsOne solution = new SolutionsOne();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String s = scanner.next();
    System.out.println(solution.solution(n, s));
  }

  public int solution(int n, String s) {
    int[] nums = new int[n / 2 + 1];
    char[] cals = new char[n / 2];

    max = s.charAt(0) - '0';
    int numIndex = 0;
    int calIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '+') {
        max += s.charAt(i + 1) - '0';
        cals[calIndex++] = s.charAt(i);
      } else if (s.charAt(i) == '-') {
        max -= s.charAt(i + 1) - '0';
        cals[calIndex++] = s.charAt(i);
      } else if (s.charAt(i) == '*') {
        max *= s.charAt(i + 1) - '0';
        cals[calIndex++] = s.charAt(i);
      } else {
        nums[numIndex++] = s.charAt(i) - '0';
      }
    }
    makeCal(nums, cals, 1, nums[0]);
    return max;
  }

  void makeCal(int[] nums, char[] cals, int index, int value) {
    if (index == nums.length) {
      if (max < value) {
        max = value;
      }
    } else {
      if (index + 1 < nums.length) {
        makeCal(nums, cals, index + 2,
            calculate(value, calculate(nums[index], nums[index + 1], cals[index]),
                cals[index - 1]));
      }
      makeCal(nums, cals, index + 1, calculate(value, nums[index], cals[index - 1]));
    }
  }

  int calculate(int n1, int n2, char cal) {
    if (cal == '+') {
      return n1 + n2;
    } else if (cal == '-') {
      return n1 - n2;
    } else if (cal == '*') {
      return n1 * n2;
    } else {
      return 0;
    }
  }
}