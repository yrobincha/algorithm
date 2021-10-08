package programmers.levelTwo.Solutions20211008;

public class SolutionsOne {

  public int solution(int n, int[][] wires) {
    int answer = n;
    for (int i = 0; i < wires.length; i++) {
      int[] parent = new int[n];
      for (int j = 0; j < n; j++) {
        parent[j] = j;
      }

      for (int j = 0; j < wires.length; j++) {
        if (j != i) {
          int[] wire = wires[j];
          int a = find(parent, wire[0] - 1);
          int b = find(parent, wire[1] - 1);
          if (a != b) {
            union(parent, a, b);
          }
        }
      }

      int count = 0;
      for (int j = 0; j < n; j++) {
        if (parent[0] == find(parent, j)) {
          count++;
        }
      }

      int gap = Math.abs(2 * count - n);
      if (gap < answer) {
        answer = gap;
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