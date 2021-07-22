package programmers.levelOne.Solutions20210722;

import java.util.Arrays;

public class SolutionsThree {

  public int solution(int[] d, int budget) {
    int answer = 0;
    int sum = 0;
    Arrays.sort(d);
    for (int i = d.length; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        sum += d[j];
      }
      if (sum > budget) {
        sum = 0;
      } else {
        answer = i;
        break;
      }
    }
    return answer;
  }
}