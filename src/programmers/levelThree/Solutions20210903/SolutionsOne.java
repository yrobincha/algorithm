package programmers.levelThree.Solutions20210903;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionsOne {

  public int solution(int[][] jobs) {
    Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
    int answer = 0;
    int index = 0;
    int finishAt = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> jobs[o][1]));

    while (index < jobs.length || !queue.isEmpty()) {
      while (index < jobs.length && jobs[index][0] <= finishAt) {
        queue.add(index++);
      }

      if (queue.isEmpty()) {
        finishAt = jobs[index][0];
      } else {
        Integer peek = queue.poll();
        if (peek != null) {
          finishAt += jobs[peek][1];
          answer += (finishAt - jobs[peek][0]);
        }
      }
    }
    return answer / jobs.length;
  }
}