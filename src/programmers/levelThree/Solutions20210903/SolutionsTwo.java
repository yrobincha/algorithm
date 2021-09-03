package programmers.levelThree.Solutions20210903;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionsTwo {

  public int solution(int n, int[][] costs) {
    int answer = 0;
    Arrays.sort(costs, (Comparator.comparingInt(o -> o[2])));
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int[] cost : costs) {
      int a = find(parent, cost[0]);
      int b = find(parent, cost[1]);
      if (a != b) {
        answer += cost[2];
        union(parent, a, b);
      }
    }
    return answer;
  }

  void union(int[] parent, int a, int b) {
    a = find(parent, a);
    b = find(parent, b);
    if (a > b) {
      parent[a] = b;
    } else {
      parent[b] = a;
    }
  }

  int find(int[] parent, int x) {
    if (parent[x] == x) {
      return x;
    } else {
      return find(parent, parent[x]);
    }
  }
}