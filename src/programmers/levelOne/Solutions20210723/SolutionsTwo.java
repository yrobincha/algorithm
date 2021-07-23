package programmers.levelOne.Solutions20210723;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionsTwo {

  public int[] solution(int[] numbers) {
    ArrayList<Integer> integers = new ArrayList<>();
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        int result = numbers[i] + numbers[j];
        if (!integers.contains(result)) {
          integers.add(result);
        }
      }
    }

    int[] answer = new int[integers.size()];
    for (int i = 0; i < integers.size(); i++) {
      answer[i] = integers.get(i);
    }

    Arrays.sort(answer);
    return answer;
  }
}