package programmers.levelTwo.Solutions20210921;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionsOne {

  public int[] solution(String[] grid) {
    int m = grid.length;
    int n = grid[0].length();
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    boolean[][][] visited;
    visited = new boolean[m][n][4];

    ArrayList<Integer> cycles = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int d = 0; d < 4; d++) {
          if (!visited[i][j][d]) {
            int cnt = 0;
            int x = i;
            int y = j;

            while (!visited[x][y][d]) {
              cnt++;
              visited[x][y][d] = true;

              if (grid[x].charAt(y) == 'L') {
                d = d == 0 ? 3 : d - 1;
              } else if (grid[x].charAt(y) == 'R') {
                d = d == 3 ? 0 : d + 1;
              }

              x = (x + dx[d] + m) % m;
              y = (y + dy[d] + n) % n;
            }
            cycles.add(cnt);
          }
        }
      }
    }

    Collections.sort(cycles);
    int[] answer = new int[cycles.size()];
    for (int i = 0; i < cycles.size(); i++) {
      answer[i] = cycles.get(i);
    }

    return answer;
  }
}