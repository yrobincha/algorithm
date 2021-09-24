package programmers.levelThree.Solutions20210924;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionsThree {

  Queue<int[]> queue = new LinkedList<>();

  public int[][] solution(int n) {
    hanoi(1, 2, 3, n);
    int[][] answer = new int[queue.size()][2];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = queue.poll();
    }

    return answer;
  }

  void hanoi(int from, int m, int to, int num) {
    if (num == 0) {
      return;
    }
    hanoi(from, to, m, num - 1);
    queue.add(new int[]{from, to});
    hanoi(m, from, to, num - 1);
  }
}