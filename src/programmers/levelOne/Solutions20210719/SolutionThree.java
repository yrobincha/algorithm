package programmers.levelOne.Solutions20210719;

import java.util.HashMap;

public class SolutionThree {

  public int[] solution(int[] lottos, int[] win_nums) {
    HashMap<Integer, Integer> winMap = new HashMap<>();
    for (int num : win_nums) {
      winMap.put(num, 1);
    }

    int winNum = 0;
    int zeroNum = 0;
    for (int lotto : lottos) {
      if (lotto == 0) {
        zeroNum++;
      } else {
        winNum += winMap.getOrDefault(lotto, 0);
      }
    }

    int best = 6;
    int worst = 6;

    if (winNum + zeroNum >= 2) {
      best = 7 - (winNum + zeroNum);
    }

    if (winNum >= 2) {
      worst = 7 - winNum;
    }
    return new int[]{best, worst};
  }
}