package programmers.levelThree.Solutions20210924;

public class SolutionsFour {

  int answer = 0;

  public int solution(int n) {
    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
      board[i][0] = 1;
      findQueen(board, n, 1);
      board[i][0] = 0;
    }
    return answer;
  }

  void findQueen(int[][] board, int n, int index) {
    if (index == n) {
      answer++;
    } else {
      for (int i = 0; i < n; i++) {
        if (check(board, i, index, n)) {
          board[i][index] = 1;
          findQueen(board, n, index + 1);
          board[i][index] = 0;
        }
      }
    }
  }

  boolean check(int[][] board, int x, int y, int n) {
    for (int j = 0; j < y; j++) {
      if (board[x][j] == 1) {
        return false;
      }
    }

    int i = x;
    int j = y;
    for (; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    i = x;
    j = y;
    for (; i < n && j >= 0; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }
    return true;
  }
}