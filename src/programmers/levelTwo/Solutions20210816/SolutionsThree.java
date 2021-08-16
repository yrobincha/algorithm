package programmers.levelTwo.Solutions20210816;

import java.util.PriorityQueue;

public class SolutionsThree {

  public int solution(int N, int[][] road, int K) {
    int answer = 0;
    int[][] path = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i != j) {
          path[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    for (int[] r : road) {
      int x = r[0] - 1;
      int y = r[1] - 1;
      int value = r[2];
      if (path[x][y] > value) {
        path[x][y] = value;
        path[y][x] = value;
      } else if (path[x][y] == 0) {
        path[x][y] = value;
        path[y][x] = value;
      }
    }

    PriorityQueue<Pair> queue = new PriorityQueue<>();
    int[] time = new int[N];
    boolean[] visited = new boolean[N];

    queue.add(new Pair(0, 0));
    time[0] = 0;
    visited[0] = true;

    for (int i = 0; i < N; i++) {
      time[i] = path[0][i];
      queue.add(new Pair(time[i], i));
    }

    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      visited[p.index] = true;
      for (int i = 0; i < N; ++i) {
        if (!visited[i] && path[p.index][i] != Integer.MAX_VALUE) {
          if (time[p.index] + path[p.index][i] < time[i]) {
            time[i] = time[p.index] + path[p.index][i];
            queue.add(new Pair(time[i], i));
          }
        }
      }
    }

    for (int i = 0; i < N; ++i) {
      if (time[i] <= K) {
        answer++;
      }
    }
    return answer;
  }
}

class Pair implements Comparable<Pair> {

  int weight;
  int index;

  public Pair(int weight, int index) {
    this.weight = weight;
    this.index = index;
  }

  @Override
  public int compareTo(Pair p) {
    return Integer.compare(this.weight, p.weight);
  }
}