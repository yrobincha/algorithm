package programmers.levelThree.Solutions20210906;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionsThree {

  public int[] solution(String[] operations) {
    ArrayList<Integer> arrayDeque = new ArrayList<>();
    for (String operation : operations) {
      String[] splits = operation.split(" ");
      if (splits[0].equals("I")) {
        int num = Integer.parseInt(splits[1]);
        arrayDeque.add(num);
        Collections.sort(arrayDeque);
      } else if (!arrayDeque.isEmpty() && splits[0].equals("D")) {
        if (splits[1].charAt(0) == '-') {
          arrayDeque.remove(0);
        } else {
          arrayDeque.remove(arrayDeque.size() - 1);
        }
      }
    }

    int[] answer = new int[2];
    if (!arrayDeque.isEmpty()) {
      answer[0] = arrayDeque.get(arrayDeque.size() - 1);
      answer[1] = arrayDeque.get(0);
    }
    return answer;
  }
}