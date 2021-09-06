package programmers.levelThree.Solutions20210906;

import java.util.HashSet;

public class SolutionsOne {

  public int solution(int n, int[][] computers) {
    int[] networks = new int[n];
    for (int i = 0; i < n; i++) {
      networks[i] = i;
    }

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (computers[i][j] == 1) {
          int a = find(networks, i);
          int b = find(networks, j);
          if (a != b) {
            union(networks, a, b);
          }
        }
      }
    }

    HashSet<Integer> answer = new HashSet<>();
    for (int network : networks) {
      answer.add(find(networks, network));
    }
    return answer.size();
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