package programmers.levelTwo.Solutions20210818;

import java.util.Arrays;
import java.util.Collections;

public class SolutionsOne {

  public int solution(int[] citations) {
    Integer[] values = new Integer[citations.length];
    int answer = 0;
    for (int i = 0; i < citations.length; i++) {
      values[i] = citations[i];
    }
    Arrays.sort(values, Collections.reverseOrder());
    for (int i = 0; i < values.length; i++) {
      if (values[i] >= i + 1) {
        answer = i + 1;
      }
    }
    return answer;
  }
}