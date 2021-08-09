package programmers.levelTwo.Solutions20210809;

import java.util.Arrays;

public class SolutionsTwo {

  public String solution(int[] numbers) {
    StringBuilder max = new StringBuilder();

    String[] nums = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      nums[i] = numbers[i] + "";
    }
    Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
    for (String num : nums) {
      if (max.length() != 0 || !num.equals("0")) {
        max.append(num);
      }
    }
    if (max.length() == 0) {
      return "0";
    } else {
      return max.toString();
    }
  }
}