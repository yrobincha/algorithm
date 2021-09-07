package programmers.levelThree.Solutions20210907;

public class SolutionsOne {

  public int solution(int m, int n, int[][] puddles) {
    int r = 1000000007;
    int[][] routes = new int[n][m];

    routes[0][0] = 1;
    for (int[] puddle : puddles) {
      routes[puddle[1] - 1][puddle[0] - 1] = -1;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (routes[i][j] == -1) {
          routes[i][j] = 0;
        } else {
          if (i != 0) {
            routes[i][j] += routes[i - 1][j] % r;
          }

          if (j != 0) {
            routes[i][j] += routes[i][j - 1] % r;
          }
        }
      }
    }
    return routes[n - 1][m - 1] % r;
  }
}