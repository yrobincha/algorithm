package programmers.levelOne.Solutions20210723;

import java.util.ArrayList;

public class SolutionsSeven {

  public int[] solution(int[] arr) {
    int[] answer;
    ArrayList<Integer> arrayList = new ArrayList<>();

    for (int a : arr) {
      if (arrayList.isEmpty()) {
        arrayList.add(a);
      } else if (arrayList.get(arrayList.size() - 1) != a) {
        arrayList.add(a);
      }
    }

    answer = new int[arrayList.size()];
    for (int i = 0; i < arrayList.size(); i++) {
      answer[i] = arrayList.get(i);
    }
    return answer;
  }
}