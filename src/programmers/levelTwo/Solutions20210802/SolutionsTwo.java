package programmers.levelTwo.Solutions20210802;

import java.util.ArrayList;

public class SolutionsTwo {

  public int[] solution(int[] progresses, int[] speeds) {
    ArrayList<Integer> queue = new ArrayList<>();
    for (int i = 0; i < progresses.length; i++) {
      int days =
          (100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] == 0 ? 0 : 1);
      queue.add(days);
    }

    ArrayList<Integer> deploy = new ArrayList<>();
    int i = 0;
    int count = 0;
    while (!queue.isEmpty()) {
      if (queue.get(i) > 0) {
        queue.set(i, queue.get(i) - 1);
      }
      if (i == 0 && queue.get(i) == 0) {
        queue.remove(i);
        count++;
      } else {
        if (count > 0) {
          deploy.add(count);
          count = 0;
        }

        if (i < queue.size() - 1) {
          i++;
        } else {
          i = 0;
        }
      }
    }
    deploy.add(count);

    int[] answer = new int[deploy.size()];
    for (int index = 0; index < deploy.size(); index++) {
      answer[index] = deploy.get(index);
    }
    return answer;
  }
}