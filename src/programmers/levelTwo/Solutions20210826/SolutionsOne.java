package programmers.levelTwo.Solutions20210826;

public class SolutionsOne {

  public int solution(int[][] board) {
    int size = 0;
    if (board.length == 1 || board[0].length == 1) {
      for (int[] ints : board) {
        for (int anInt : ints) {
          if (anInt == 1) {
            return 1;
          }
        }
      }
    }

    for (int i = 1; i < board.length; i++) {
      for (int j = 1; j < board[i].length; j++) {
        if (board[i][j] == 1) {
          size = (size == 0 ? 1 : size);
          int n = board[i][j];
          if (n <= board[i - 1][j] && n <= board[i][j - 1] && n <= board[i - 1][j - 1]) {
            board[i][j] =
                Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
            if (size < board[i][j]) {
              size = board[i][j];
            }
          }
        }
      }
    }
    return size * size;
  }
}