package programmers.levelTwo.Solutions20210816;

import java.util.ArrayList;

public class SolutionsOne {

  public int solution(int[][] maps) {
    int n = maps.length;
    int m = maps[0].length;
    int[][] visited = new int[n][m];

    visited[0][0] = 1;
    ArrayList<int[]> queue = new ArrayList<>();
    queue.add(new int[]{0, 0});

    while (!queue.isEmpty()) {
      int[] point = queue.get(0);
      queue.remove(0);
      int x = point[0];
      int y = point[1];

      if (x == n - 1 && y == m - 1) {
        return visited[x][y];
      }
      for (int i = -1; i <= 1; i++) {
        if (i != 0) {
          int tX = x + i;
          int tY = y + i;
          if (tX >= 0 && tX < n && maps[tX][y] == 1 && visited[tX][y] == 0) {
            queue.add(new int[]{tX, y});
            visited[tX][y] = visited[x][y] + 1;
          }
          if (tY >= 0 && tY < m && maps[x][tY] == 1 && visited[x][tY] == 0) {
            queue.add(new int[]{x, tY});
            visited[x][tY] = visited[x][y] + 1;
          }
        }
      }
    }
    return -1;
  }
}