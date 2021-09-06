package programmers.levelThree.Solutions20210906;

public class SolutionsTwo {

  public int solution(int n, int[][] results) {
    boolean[][] games = new boolean[n][n];
    int answer = 0;
    for (int[] result : results) {
      games[result[0] - 1][result[1] - 1] = true;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (games[j][i] && games[i][k]) {
            games[j][k] = true;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (games[i][j] || games[j][i]) {
          count++;
        }
      }
      if (count == n - 1) {
        answer++;
      }
    }
    return answer;
  }
}