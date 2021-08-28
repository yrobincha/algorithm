package programmers.levelTwo.Solutions20210828;

import java.util.ArrayList;

public class SolutionsSix {

  public long solution(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(1);
    for (int i = 2; i <= n; i++) {
      list.add((list.get(i - 1) + list.get(i - 2)) % 1234567);
    }
    return list.get(n);
  }
}