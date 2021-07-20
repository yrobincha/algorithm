package programmers.levelOne.Solutions20210720;

import java.util.ArrayList;

public class SolutionSeven {

  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    ArrayList<Integer> dolls = new ArrayList<>();

    for (int move : moves) {
      int item = 0;
      for (int i = 0; i < board[move - 1].length; i++) {
        if (board[i][move - 1] > 0) {
          item = board[i][move - 1];
          board[i][move - 1] = 0;
          break;
        }
      }

      if (item > 0) {
        if (dolls.isEmpty()) {
          dolls.add(item);
        } else if (dolls.get(dolls.size() - 1) == item) {
          dolls.remove(dolls.size() - 1);
          answer += 2;
        } else {
          dolls.add(item);
        }
      }
    }
    return answer;
  }
}