package programmers.levelThree.Solutions20210924;

import java.util.ArrayList;

public class SolutionsOne {

  public int[] solution(int n, long k) {
    ArrayList<Integer> list = new ArrayList<>();
    int[] answer = new int[n];
    long f = 1;
    for (int i = 1; i <= n; i++) {
      f *= i;
      list.add(i);
    }
    k--;

    int index = 0;
    while (n > 0) {
      f /= n;
      answer[index++] = list.get((int) (k / f));
      list.remove((int) (k / f));
      k %= f;
      n--;
    }
    return answer;
  }
}