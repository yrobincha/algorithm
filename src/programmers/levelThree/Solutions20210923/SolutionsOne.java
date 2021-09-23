package programmers.levelThree.Solutions20210923;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionsOne {

  public long solution(int n, int[] works) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int w : works) {
      queue.add(w);
    }

    while (n > 0 && !queue.isEmpty() && queue.peek() > 0) {
      int work = queue.poll();
      queue.add(work - 1);
      n -= 1;
    }

    long answer = 0;
    for (int work : queue) {
      answer += (long) work * work;
    }
    return answer;
  }
}