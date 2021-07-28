package programmers.levelOne.Solutions20210728;

import java.util.ArrayList;

public class SolutionsThree {

  public long[] solution(long n) {
    ArrayList<Long> arrayList = new ArrayList<>();
    while (n > 9) {
      arrayList.add(n % 10);
      n /= 10;
    }
    arrayList.add(n);
    long[] answer = new long[arrayList.size()];
    for (int i = 0; i < arrayList.size(); i++) {
      answer[i] = arrayList.get(i);
    }
    return answer;
  }
}