package programmers.levelOne.Solutions20210720;

import java.util.Arrays;

public class SolutionTwo {

  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    int index = 0;

    for (int[] command : commands) {
      int[] list = new int[command[1] - command[0] + 1];
      int subIndex = 0;
      for (int i = command[0] - 1; i < command[1]; i++) {
        list[subIndex++] = array[i];
      }
      Arrays.sort(list);
      answer[index++] = list[command[2] - 1];
    }
    return answer;
  }
}