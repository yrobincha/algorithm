package backjoon.Solutions20211016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SolutionsOne {

  int max = 0;

  public static void main(String[] args) throws IOException {
    SolutionsOne solution = new SolutionsOne();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int[][] matrix = new int[n + 1][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(solution.solution(n, m, d, matrix));
  }

  int solution(int n, int m, int d, int[][] matrix) {
    findLocation(n, m, d, matrix, 0, 3);
    return max;
  }

  void findLocation(int n, int m, int d, int[][] matrix, int index, int r) {
    if (r == 0) {
      int[][] tmp = new int[n + 1][m];
      for (int i = 0; i < n + 1; i++) {
        System.arraycopy(matrix[i], 0, tmp[i], 0, m);
      }

      int value = 0;
      while (checkMatrix(tmp)) {
        ArrayList<int[]> targets = new ArrayList<>();
        for (int i = 0; i < m; i++) {
          if (tmp[n][i] == 1) {
            int[] t = new int[]{-1, -1};
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < m; k++) {
              for (int j = Math.max(n - d, 0); j < n; j++) {
                int dis = Math.abs(j - n) + Math.abs(i - k);
                if (tmp[j][k] == 1 && dis <= d && (t[0] < 0 || dis < min)) {
                  t[0] = j;
                  t[1] = k;
                  min = dis;
                }
              }
            }
            if (t[0] >= 0 && t[1] >= 0) {
              targets.add(t);
            }
          }
        }

        for (int[] tg : targets) {
          if (tmp[tg[0]][tg[1]] == 1) {
            value++;
            tmp[tg[0]][tg[1]] = 0;
          }
        }

        if (n - 1 >= 0) {
          System.arraycopy(tmp, 0, tmp, 1, n - 1);
        }
        tmp[0] = new int[m];
      }

      if (value > max) {
        max = value;
      }
    } else {
      for (int i = index; i < matrix[n].length; i++) {
        matrix[n][i] = 1;
        findLocation(n, m, d, matrix, i + 1, r - 1);
        matrix[n][i] = 0;
      }
    }
  }

  boolean checkMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) {
          return true;
        }
      }
    }
    return false;
  }
}