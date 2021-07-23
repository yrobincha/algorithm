package programmers.levelOne.Solutions20210723;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionsEight {

  public int[] solution(int[] arr, int divisor) {
    int[] answer;
    ArrayList<Integer> arrayList = new ArrayList<>();
    for (int n : arr) {
      if (n % divisor == 0) {
        arrayList.add(n);
      }
    }

    if (arrayList.isEmpty()) {
      return new int[]{-1};
    } else {
      answer = new int[arrayList.size()];
      for (int i = 0; i < arrayList.size(); i++) {
        answer[i] = arrayList.get(i);
      }
      Arrays.sort(answer);
      return answer;
    }
  }
}