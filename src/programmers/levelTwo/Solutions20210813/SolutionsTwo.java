package programmers.levelTwo.Solutions20210813;

import java.util.ArrayList;

public class SolutionsTwo {

  public int solution(int[] priorities, int location) {
    int answer = 0;
    ArrayList<String> queue = new ArrayList<>();
    for (int i = 0; i < priorities.length; i++) {
      queue.add(priorities[i] + "" + i);
    }
    while (!queue.isEmpty()) {
      String item = queue.get(0);
      for (int i = 1; i < queue.size(); i++) {
        if (queue.get(i).charAt(0) > item.charAt(0)) {
          queue.add(item);
          queue.remove(0);
          break;
        }
      }
      if (item.equals(queue.get(0))) {
        queue.remove(0);
        answer++;
        if (item.substring(1).equals("" + location)) {
          break;
        }
      }
    }
    return answer;
  }
}