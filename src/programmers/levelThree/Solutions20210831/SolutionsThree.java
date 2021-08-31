package programmers.levelThree.Solutions20210831;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionsThree {

  public int solution(int n, int[][] edge) {
    boolean[] visited = new boolean[n];
    boolean[][] path = new boolean[n][n];
    Queue<Integer> queue = new LinkedList<>();
    for (int[] ints : edge) {
      path[ints[0] - 1][ints[1] - 1] = true;
      path[ints[1] - 1][ints[0] - 1] = true;
    }
    visited[0] = true;
    queue.add(0);

    int answer = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int node = queue.poll();
        for (int j = 0; j < n; j++) {
          if (path[j][node] && !visited[j]) {
            visited[j] = true;
            queue.add(j);
          }
        }
      }
      answer = size;
    }
    return answer;
  }
}