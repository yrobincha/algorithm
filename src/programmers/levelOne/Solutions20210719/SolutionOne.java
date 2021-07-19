package programmers.levelOne.Solutions20210719;

import java.util.ArrayList;

public class SolutionOne {

  public int solution(int[] nums) {
    ArrayList<Integer> tmp = new ArrayList<>();
    for (int num : nums) {
      if (!tmp.contains(num)) {
        tmp.add(num);
      }
    }
    return Math.min(nums.length / 2, tmp.size());
  }
}