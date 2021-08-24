package programmers.levelTwo.Solutions20210824;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SolutionsOne {

  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);
    ArrayDeque<Integer> weights = new ArrayDeque<>();
    for (int person : people) {
      weights.add(person);
    }

    while (!weights.isEmpty()) {
      int sum = weights.pollLast();
      if (!weights.isEmpty() && sum + weights.peekFirst() <= limit) {
        sum += weights.pollFirst();
      }
      answer++;
    }
    return answer;
  }
}