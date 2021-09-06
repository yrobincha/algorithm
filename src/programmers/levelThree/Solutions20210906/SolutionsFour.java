package programmers.levelThree.Solutions20210906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SolutionsFour {

  public int solution(int[][] routes) {
    int answer = 0;
    ArrayList<int[]> queue = new ArrayList<>(Arrays.asList(routes));
    Collections.sort(queue, (Comparator.comparingInt(o -> o[1])));

    while (!queue.isEmpty()) {
      int[] first = queue.get(0);
      queue.remove(0);

      for (int i = queue.size() - 1; i >= 0; i--) {
        if (queue.get(i)[0] <= first[1]) {
          queue.remove(i);
        }
      }

      answer++;
    }
    return answer;
  }
}